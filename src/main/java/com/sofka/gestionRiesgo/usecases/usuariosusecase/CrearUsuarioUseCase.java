package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.GuardarUsuario;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearUsuarioUseCase implements GuardarUsuario {

    private final UsuarioRepository usuarioRepository;
    private final MapperUsuario mapperUsuario;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository, MapperUsuario mapperUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUsuario = mapperUsuario;
    }

    @Override
    public Mono<UsuarioDTO> apply(UsuarioDTO usuarioDTO) {
        return usuarioRepository
                .save(mapperUsuario.usuarioDtoAUsuario(null).apply(usuarioDTO))
                .thenReturn(usuarioDTO);


    }
}
