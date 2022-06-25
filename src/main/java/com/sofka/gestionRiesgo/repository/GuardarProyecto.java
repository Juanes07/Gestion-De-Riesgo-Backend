package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface GuardarProyecto {
    Mono<ProyectoDTO> apply(@Valid ProyectoDTO proyectoDTO);
}
