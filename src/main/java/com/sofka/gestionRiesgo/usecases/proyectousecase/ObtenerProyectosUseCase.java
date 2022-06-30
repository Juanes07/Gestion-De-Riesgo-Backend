package com.sofka.gestionRiesgo.usecases.proyectousecase;

import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;
/**
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Service
@Validated
public class ObtenerProyectosUseCase implements Supplier<Flux<ProyectoDTO>> {


    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public ObtenerProyectosUseCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Flux<ProyectoDTO> get() {
        return proyectoRepository.findAll()
                .map(mapperProyecto.proyectoAProyectoDto());


    }
}
