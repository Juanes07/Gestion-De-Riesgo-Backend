package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import com.sofka.gestionRiesgo.service.SequenceGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;


import static org.mockito.Mockito.*;

class CrearRiesgoUseCaseTest {

    @Mock
    RiesgoRepository riesgoRepository;
    @Mock
    ProyectoRepository proyectoRepository;

    @Mock
    CrearRiesgoUseCase crearRiesgoUseCase;

    @Mock
    SequenceGeneratorService service;

    MapperRiesgo mapperRiesgo = new MapperRiesgo();

    @BeforeEach
    public void setUp() {
        service = Mockito.mock(SequenceGeneratorService.class);
        proyectoRepository = mock(ProyectoRepository.class);
        riesgoRepository = mock(RiesgoRepository.class);

        crearRiesgoUseCase = new CrearRiesgoUseCase(proyectoRepository, riesgoRepository, mapperRiesgo, service);
    }

    @Test
    void getValidationCreateTest() {

        var proyecto = new Proyecto();
        proyecto.setId(1);
        proyecto.setNombre("Matematicas");
        proyecto.setFechaInicio("26/06/2022");
        proyecto.setFechaFin("23/04/22");
        proyecto.setEtiquetas(List.of("primera", "lista"));
        proyecto.setResponsables(List.of("david", "jesus"));
        proyecto.setDescripcion("hello como estas");
        proyecto.setLiderProyecto("manuel salas");
        proyecto.setEstado("activo");

        var riesgo = new Riesgo();
        riesgo.setId(1);
        riesgo.setIdProyecto(1);
        riesgo.setNombreProyecto("Proyecto prueba");
        riesgo.setNombreRiesgo("Costo");
        riesgo.setFechaDeteccion("2022-06-15");
        riesgo.setFechaCierre("2022-06-19");
        riesgo.setEtiquetas(List.of("etiqueta1", "etiqueta1"));
        riesgo.setDescripcionRiesgo("descripcion----");
        riesgo.setEstadoRiesgo("estado riesgo");
        riesgo.setAudiencia("audiencia");
        riesgo.setCategoria("categoria");
        riesgo.setTipoRiesgo("tipo riesgo");
        riesgo.setDetalleTipoRiesgo("detalle riesgo ");
        riesgo.setProbabilidadDeOcurrenciaDelRiesgo(1);
        riesgo.setImpactoDeOcurrenciaDelRiesgo(1);
        riesgo.setDescripcionPlanDeMitigacion("descripcion plan mitigacion");
        riesgo.setEmailsPlanDeMitigacion(List.of("correo@gmail.com", "correo2@gmail.com"));
        riesgo.setDescripcionPlanDeContingencia("descripcion plan contigencia");
        riesgo.setEmailsPlanDeContingencia(List.of("correo@gmail.com", "correo2@gmail.com"));
        riesgo.setValorCriticidad(2);
        riesgo.setEstadoDeVidaDelRiesgo("mitigado");

        RiesgoDTO riesgoDTO = mapperRiesgo.riesgoARiesgoDto().apply(riesgo);


        when(proyectoRepository.findById(1)).thenReturn(Mono.just(proyecto));

        when(service.getSequenceNumber("riesgo_sequence")).thenReturn(Mono.just(1));

        when(riesgoRepository.save(any(Riesgo.class))).thenReturn(Mono.just(riesgo));

        StepVerifier.create(crearRiesgoUseCase.apply(riesgoDTO))
                .expectNextMatches(riesgoDTO1 -> {

                    assert riesgoDTO1.getId().equals(riesgo.getId());
                    assert riesgoDTO1.getIdProyecto().equals(riesgo.getIdProyecto());
                    assert riesgoDTO1.getNombreProyecto().equals(riesgo.getNombreProyecto());
                    assert riesgoDTO1.getNombreRiesgo().equals(riesgo.getNombreRiesgo());
                    assert riesgoDTO1.getFechaDeteccion().equals(riesgo.getFechaDeteccion());
                    assert riesgoDTO1.getFechaCierre().equals(riesgo.getFechaCierre());
                    assert riesgoDTO1.getEtiquetas().equals(riesgo.getEtiquetas());
                    assert riesgoDTO1.getDescripcionRiesgo().equals(riesgo.getDescripcionRiesgo());
                    assert riesgoDTO1.getEstadoRiesgo().equals(riesgo.getEstadoRiesgo());
                    assert riesgoDTO1.getAudiencia().equals(riesgo.getAudiencia());
                    assert riesgoDTO1.getCategoria().equals(riesgo.getCategoria());
                    assert riesgoDTO1.getTipoRiesgo().equals(riesgo.getTipoRiesgo());
                    assert riesgoDTO1.getDetalleTipoRiesgo().equals(riesgo.getDetalleTipoRiesgo());
                    assert riesgoDTO1.getProbabilidadDeOcurrenciaDelRiesgo().equals(riesgo.getProbabilidadDeOcurrenciaDelRiesgo());
                    assert riesgoDTO1.getImpactoDeOcurrenciaDelRiesgo().equals(riesgo.getImpactoDeOcurrenciaDelRiesgo());
                    assert riesgoDTO1.getDescripcionPlanDeMitigacion().equals(riesgo.getDescripcionPlanDeMitigacion());
                    assert riesgoDTO1.getEmailsPlanDeMitigacion().equals(riesgo.getEmailsPlanDeMitigacion());
                    assert riesgoDTO1.getDescripcionPlanDeContingencia().equals(riesgo.getDescripcionPlanDeContingencia());
                    assert riesgoDTO1.getEmailsPlanDeContingencia().equals(riesgo.getEmailsPlanDeContingencia());
                    assert riesgoDTO1.getValorCriticidad().equals(riesgo.getValorCriticidad());
                    assert riesgoDTO1.getEstadoDeVidaDelRiesgo().equals(riesgo.getEstadoDeVidaDelRiesgo());

                    return true;
                }).expectComplete();




        verify(service).getSequenceNumber("riesgo_sequence");


    }
}