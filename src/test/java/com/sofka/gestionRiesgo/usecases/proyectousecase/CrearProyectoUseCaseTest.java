package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CrearProyectoUseCaseTest {

    @Mock
    ProyectoRepository proyectoRepository;

    @Mock
    CrearProyectoUseCase crearProyectoUseCase;

    MapperProyecto mapperProyecto = new MapperProyecto();


    @BeforeEach
    public void setUp() {

        proyectoRepository = mock(ProyectoRepository.class);
        crearProyectoUseCase = new CrearProyectoUseCase(proyectoRepository,mapperProyecto);

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


        var proyectoDto = new ProyectoDTO();
        proyectoDto.setId(proyecto.getId());
        proyectoDto.setNombre(proyecto.getNombre());
        proyectoDto.setFechaInicio(proyecto.getFechaInicio());
        proyectoDto.setFechaFin(proyecto.getFechaFin());
        proyectoDto.setEtiquetas(proyecto.getEtiquetas());
        proyectoDto.setResponsables(proyecto.getResponsables());
        proyectoDto.setDescripcion(proyecto.getDescripcion());
        proyectoDto.setLiderProyecto(proyecto.getLiderProyecto());
        proyectoDto.setEstado(proyecto.getEstado());


        when(proyectoRepository.save(Mockito.any(Proyecto.class))).thenReturn(Mono.just(proyecto));

        StepVerifier.create(crearProyectoUseCase.apply(proyectoDto))

                .expectNextMatches(q -> {

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
                }).expectComplete();

        verify(proyectoRepository).save(Mockito.any(Proyecto.class));
    }
}



