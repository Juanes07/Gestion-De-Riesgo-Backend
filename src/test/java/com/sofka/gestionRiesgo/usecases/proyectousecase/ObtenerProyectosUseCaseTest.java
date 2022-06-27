package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class ObtenerProyectosUseCaseTest {

    ProyectoRepository proyectoRepository;

    ObtenerProyectosUseCase obtenerProyectosUseCase;


    @BeforeEach
    public void setup(){
        MapperProyecto mapperProyecto = new MapperProyecto();
        proyectoRepository = mock(ProyectoRepository.class);
       obtenerProyectosUseCase =new ObtenerProyectosUseCase(proyectoRepository,mapperProyecto);
    }

    @Test
    void getValidationTest(){
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
        when(proyectoRepository.findAll()).thenReturn(Flux.just(proyecto ));

        StepVerifier.create(obtenerProyectosUseCase.get())
                .expectNextMatches(proyectoDto -> {
                    assert proyectoDto.getId().equals(1);
                    assert proyectoDto.getNombre().equals("Matematicas");
                    assert proyectoDto.getFechaInicio().equals("26/06/2022");
                    assert proyectoDto.getFechaFin().equals("23/04/22");
                    assert proyectoDto.getEtiquetas().equals(List.of("primera", "lista"));
                    assert proyectoDto.getResponsables().equals(List.of("david", "jesus"));
                    assert proyectoDto.getDescripcion().equals("hello como estas");
                    assert proyectoDto.getLiderProyecto().equals("manuel salas");
                    assert proyectoDto.getEstado().equals("activo");
                    return true;
                })
                .expectComplete();

        verify(proyectoRepository).findAll();
    }

}