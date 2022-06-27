package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface GuardarRiesgo {

    Mono<RiesgoDTO> apply(@Valid RiesgoDTO riesgoDTO);
}
