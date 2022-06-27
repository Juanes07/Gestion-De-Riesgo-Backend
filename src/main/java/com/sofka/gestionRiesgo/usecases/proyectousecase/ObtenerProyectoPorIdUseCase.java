package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class ObtenerProyectoPorIdUseCase implements Function<String, Mono<ProyectoDTO>> {

    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public ObtenerProyectoPorIdUseCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<ProyectoDTO> apply(String id) {
        return proyectoRepository
                .findById(Integer.parseInt(id))
                .map(mapperProyecto.proyectoAProyectoDto());


    }
}
