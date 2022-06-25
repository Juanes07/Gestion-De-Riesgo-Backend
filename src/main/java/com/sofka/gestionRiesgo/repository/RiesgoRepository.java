package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.collections.Riesgo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RiesgoRepository extends ReactiveCrudRepository<Riesgo, Integer> {

}

