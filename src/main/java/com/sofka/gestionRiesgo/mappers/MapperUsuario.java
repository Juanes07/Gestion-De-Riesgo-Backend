package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Usuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuario {

    public Usuario usuarioDtoAUsuario(UsuarioDTO usuarioDTO) {
        var usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setRoles(usuarioDTO.getRoles());
        return usuario;
    }

    public UsuarioDTO usuarioAUsuarioDto(Usuario usuario) {
        var usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setRoles(usuario.getRoles());
        return usuarioDTO;
    }
}
