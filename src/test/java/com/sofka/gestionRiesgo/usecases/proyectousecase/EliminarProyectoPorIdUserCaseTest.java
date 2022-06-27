package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class EliminarProyectoPorIdUserCaseTest {

    @Mock
    ProyectoRepository proyectoRepository;
    @Mock
    EliminarProyectoPorIdUserCase eliminarProyectoPorIdUserCase;

    MapperProyecto mapperProyecto = new MapperProyecto();

    @BeforeEach
    public void setUp() {

        proyectoRepository = mock(ProyectoRepository.class);
        eliminarProyectoPorIdUserCase = new EliminarProyectoPorIdUserCase(proyectoRepository, mapperProyecto);

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


        Mono.just(proyecto).flatMap(proyectoRepository::save);

        when(proyectoRepository.findById(1)).thenReturn(Mono.just(proyecto));
        when(proyectoRepository.delete(proyecto)).thenReturn(Mono.empty());

        StepVerifier.create(eliminarProyectoPorIdUserCase.apply("1"))
                .expectNextMatches(proyec -> {
                    assert proyec.equals(1);
                    return true;
                }).expectComplete();

        verify(proyectoRepository, times(1)).findById(1);


    }

}