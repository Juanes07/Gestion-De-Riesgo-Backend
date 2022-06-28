package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerRiesgoPorIdUseCaseTest {

    @Mock
    RiesgoRepository riesgoRepository;

    @Mock
    ObtenerRiesgoPorIdUseCase obtenerRiesgoPorIdUseCase;

    MapperRiesgo mapperRiesgo = new MapperRiesgo();

    @BeforeEach
    public void setUp() {
        riesgoRepository = mock(RiesgoRepository.class);
        obtenerRiesgoPorIdUseCase = new ObtenerRiesgoPorIdUseCase(riesgoRepository, mapperRiesgo);
    }

    @Test
    void getValidationGetRiesgoIdTest(){
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
        riesgo.setDescripcionPlanDeContigencia("descripcion plan contigencia");
        riesgo.setEmailsPlanDeContigencia(List.of("correo@gmail.com", "correo2@gmail.com"));
        riesgo.setValorCriticidad(2);
        riesgo.setEstadoDeVidaDelRiesgo("mitigado");


        when(riesgoRepository.findById(1)).thenReturn(Mono.just(riesgo));

        StepVerifier.create(obtenerRiesgoPorIdUseCase.apply("1"))
                .expectNextMatches(riesgoDTO1 -> {
                    assertEquals(riesgoDTO1.getId(),1);
                    assertEquals(riesgoDTO1.getNombreProyecto(),"Proyecto prueba");
                    return true;
                }).expectComplete();

        verify(riesgoRepository).findById(1);

    }

}