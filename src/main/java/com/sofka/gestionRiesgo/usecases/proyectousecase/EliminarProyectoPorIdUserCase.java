package com.sofka.gestionRiesgo.usecases.proyectousecase;


import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;
/**
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Service
@Validated
public class EliminarProyectoPorIdUserCase implements Function<String, Mono<Void>> {
    private final ProyectoRepository proyectoRepository;
    private final MapperProyecto mapperProyecto;

    public EliminarProyectoPorIdUserCase(ProyectoRepository proyectoRepository, MapperProyecto mapperProyecto) {
        this.proyectoRepository = proyectoRepository;
        this.mapperProyecto = mapperProyecto;
    }

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "El id del proyecto es requerido");
        Mono<Proyecto> proyecto = proyectoRepository.findById(Integer.parseInt(id));
        return proyecto.flatMap(p -> {
            if (p.getEstado().equalsIgnoreCase("Creado")) {
                return proyectoRepository.deleteById(Integer.parseInt(id));
            } else {
                return Mono.error(new Exception("El proyecto no puede ser eliminado"));
            }
        });

    }
}
