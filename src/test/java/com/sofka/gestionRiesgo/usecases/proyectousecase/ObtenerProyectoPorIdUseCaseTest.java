package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerProyectoPorIdUseCaseTest {

    ProyectoRepository proyectoRepository;

    ObtenerProyectoPorIdUseCase obtenerProyectoPorIdUseCase;

    @BeforeEach
    public void setup(){
        MapperProyecto mapperProyecto = new MapperProyecto();
        proyectoRepository = mock(ProyectoRepository.class);
        obtenerProyectoPorIdUseCase =new ObtenerProyectoPorIdUseCase(proyectoRepository,mapperProyecto);
    }

    @Test
    void getValidationTest() {

        var proyectoDto = new ProyectoDTO(1,"matematicas","26/06/2022","23/04/22","hello como estas","manuel salas","activo" );

        var proyecto = new Proyecto();
        proyecto.setId(1);
        proyecto.setNombre("Matematicas");
        proyecto.setFechaInicio("26/06/2022");
        proyecto.setFechaFin("23/04/22");
        proyecto.setDescripcion("hello como estas");
        proyecto.setLiderProyecto("manuel salas");
        proyecto.setEstado("activo");

           when(proyectoRepository.findById(1)).thenReturn(Mono.just(proyecto));

        StepVerifier.create(obtenerProyectoPorIdUseCase.apply("1"))
                .expectNextMatches(proyectoDTO-> {
                    assertEquals(proyectoDTO.getId(),1);
                    assertEquals(proyectoDTO.getNombre(),"Matematicas");
                    assertEquals(proyectoDTO.getFechaInicio(),"26/06/2022");
                    assertEquals(proyectoDTO.getFechaFin(),"23/04/22");
                    assertEquals(proyectoDTO.getDescripcion(),"hello como estas");
                    assertEquals(proyectoDTO.getLiderProyecto(),"manuel salas");
                    assertEquals(proyectoDTO.getEstado(),"activo");
                    return true;
                }).expectComplete();


        verify(proyectoRepository).findById(proyectoDto.getId());


    }
}
