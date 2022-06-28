package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class ObtenerRiesgosPorIdProyectoUseCaseTest {

    @Mock
    RiesgoRepository riesgoRepository;

    @Mock
    ObtenerRiesgosPorIdProyectoUseCase obtenerRiesgosPorIdProyectoUseCase;

    MapperRiesgo mapperRiesgo = new MapperRiesgo();

    @BeforeEach
    public void setUp() {
        riesgoRepository = mock(RiesgoRepository.class);
        obtenerRiesgosPorIdProyectoUseCase = new ObtenerRiesgosPorIdProyectoUseCase(riesgoRepository, mapperRiesgo);
    }

    @Test
    void getValidationGetRiesgosIdProyectoTest(){
        var riesgo = new Riesgo();
        riesgo.setId(1);
        riesgo.setIdProyecto(2);
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
        riesgo.setDescripcionPlanDeContigencia("descripcion plan contigencia");
        riesgo.setEmailsPlanDeContigencia(List.of("correo@gmail.com", "correo2@gmail.com"));
        riesgo.setValorCriticidad(2);
        riesgo.setEstadoDeVidaDelRiesgo("mitigado");

        var riesgo2 = new Riesgo();
        riesgo.setId(3);
        riesgo.setIdProyecto(2);
        riesgo.setNombreProyecto("Proyecto prueba riesgo 2");
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
        riesgo.setDescripcionPlanDeContigencia("descripcion plan contigencia");
        riesgo.setEmailsPlanDeContigencia(List.of("correo@gmail.com", "correo2@gmail.com"));
        riesgo.setValorCriticidad(2);
        riesgo.setEstadoDeVidaDelRiesgo("mitigado");

        when(riesgoRepository.findAllByIdProyecto(Mockito.anyInt())).thenReturn(Flux.just(riesgo,riesgo2));

        StepVerifier.create(obtenerRiesgosPorIdProyectoUseCase.apply("2"))
                .expectNextMatches(riesgo1 -> riesgo1.getId().equals(1))
                .expectNextMatches(riesgo1 -> riesgo1.getId().equals(3))
                .expectComplete();
        verify(riesgoRepository).findAllByIdProyecto(2);

    }
}