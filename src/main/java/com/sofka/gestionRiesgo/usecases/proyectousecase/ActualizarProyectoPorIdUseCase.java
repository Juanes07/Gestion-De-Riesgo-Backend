package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.GuardarProyecto;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarProyectoPorIdUseCase implements GuardarProyecto {

    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public ActualizarProyectoPorIdUseCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<ProyectoDTO> apply(ProyectoDTO proyectoDTO) {
        Objects.requireNonNull(proyectoDTO.getId(), "El id del proyecto es requerido");
        return proyectoRepository
                .save(mapperProyecto.proyectoDtoAProyecto(proyectoDTO.getId())
                        .apply(proyectoDTO))
                .thenReturn(proyectoDTO);
    }
}
