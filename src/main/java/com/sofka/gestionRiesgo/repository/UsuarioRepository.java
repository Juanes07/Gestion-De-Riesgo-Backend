package com.sofka.gestionRiesgo.repository;

import com.sofka.gestionRiesgo.collections.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Integer> {

}

