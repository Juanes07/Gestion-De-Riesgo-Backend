package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActualizarRiesgoPorIdUseCaseTest {

    @Mock
    RiesgoRepository riesgoRepository;

    @Mock
    CrearRiesgoUseCase crearRiesgoUseCase;

    MapperRiesgo mapperRiesgo = new MapperRiesgo();

    @BeforeEach
    public void setUp() {
        riesgoRepository = mock(RiesgoRepository.class);
        crearRiesgoUseCase = new CrearRiesgoUseCase(riesgoRepository, mapperRiesgo);
    }

    @Test
    void getValidationCreateTest(){
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
        riesgo.setAudencia("audiencia");
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

        RiesgoDTO riesgoDTO = mapperRiesgo.riesgoARiesgoDto().apply(riesgo);
        riesgoDTO.setNombreProyecto("Proyecto prueba Actualizado");

        when(riesgoRepository.save(Mockito.any(Riesgo.class))).thenReturn(Mono.just(riesgo));

        StepVerifier.create(crearRiesgoUseCase.apply(riesgoDTO))
                .expectNextMatches(riesgoDTO1 -> {
                    assert riesgoDTO1.getId().equals(riesgo.getId());
                    assert riesgoDTO1.getNombreProyecto().equals("Proyecto prueba Actualizado");
                    return true;
                }).expectComplete();

        verify(riesgoRepository).save(Mockito.any(Riesgo.class));

    }
}