package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.GuardarProyecto;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearProyectoUseCase implements GuardarProyecto {

    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public CrearProyectoUseCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<ProyectoDTO> apply(ProyectoDTO nuevoProyecto) {
        return proyectoRepository
                .save(mapperProyecto.proyectoDtoAProyecto(null).apply(nuevoProyecto))
                .thenReturn(nuevoProyecto);
    }
}
