package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.GuardarProyecto;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import com.sofka.gestionRiesgo.service.SequenceGeneratorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import static com.sofka.gestionRiesgo.collections.Proyecto.SEQUENCE_PROYECTO;
import static com.sofka.gestionRiesgo.collections.Usuario.SEQUENCE_USUARIO;

@Service
@Validated
public class CrearProyectoUseCase implements GuardarProyecto {

    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    private final SequenceGeneratorService service;

    public CrearProyectoUseCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto, SequenceGeneratorService service) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
        this.service = service;
    }

    @Override
    public Mono<ProyectoDTO> apply(ProyectoDTO nuevoProyecto) {
       return  service.getSequenceNumber(SEQUENCE_PROYECTO).flatMap(id->{
            nuevoProyecto.setId(id.intValue());
            nuevoProyecto.setEstado("Creado");
            return proyectoRepository
                    .save(mapperProyecto.proyectoDtoAProyecto(null).apply(nuevoProyecto))
                    .thenReturn(nuevoProyecto);
        });

    }
}
