package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.models.UsuarioDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

public interface GuardarUsuario {
    Mono<String> apply(@Valid UsuarioDTO usuarioDTO);
}
