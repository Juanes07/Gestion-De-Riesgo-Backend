package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.collections.Usuario;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUsuario {


    public Function<UsuarioDTO, Usuario> usuarioDtoAUsuario(Object o) {
        return usuarioDTO -> {
            var usuario = new Usuario();
            usuario.setId(usuarioDTO.getId());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setRoles(usuarioDTO.getRoles());
            return usuario;
        };
    }

    public Function<Usuario, UsuarioDTO> usuarioAUsuarioDto() {
        return usuario -> new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRoles()
        );
    }
}
