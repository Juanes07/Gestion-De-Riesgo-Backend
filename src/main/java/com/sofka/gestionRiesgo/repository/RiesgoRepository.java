package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.collections.Riesgo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.net.http.HttpHeaders;

public interface RiesgoRepository extends ReactiveCrudRepository<Riesgo, Integer> {


    Flux<Riesgo> findAllByIdProyecto(Integer proyectoId);

}

