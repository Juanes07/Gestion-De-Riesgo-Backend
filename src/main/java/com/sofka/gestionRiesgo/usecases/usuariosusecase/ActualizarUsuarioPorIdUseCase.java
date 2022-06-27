package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.GuardarUsuario;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarUsuarioPorIdUseCase implements GuardarUsuario {

    private final UsuarioRepository usuarioRepository;
    private final MapperUsuario mapperUsuario;


    public ActualizarUsuarioPorIdUseCase(UsuarioRepository usuarioRepository, MapperUsuario mapperUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUsuario = mapperUsuario;
    }


    @Override
    public Mono<UsuarioDTO> apply(UsuarioDTO usuarioDTO) {
        Objects.requireNonNull(usuarioDTO.getId(), "El id del proyecto es requerido");
        return usuarioRepository
                .save(mapperUsuario.usuarioDtoAUsuario(usuarioDTO.getId())
                        .apply(usuarioDTO))
                .thenReturn(usuarioDTO);
    }
}

