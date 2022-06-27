package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.collections.Usuario;
import com.sofka.gestionRiesgo.mappers.MapperProyecto;
import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ObtenerProyectosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ObtenerUsuariosUseCaseTest {

    UsuarioRepository usuarioRepository;

    ObtenerUsuariosUseCase obtenerUsuariosUseCase;


    @BeforeEach
    public void setup() {
        MapperUsuario mapperUsuario = new MapperUsuario();
        usuarioRepository = mock(UsuarioRepository.class);
        obtenerUsuariosUseCase = new ObtenerUsuariosUseCase(usuarioRepository, mapperUsuario);
    }


    @Test
    void getValidationTest() {
        var usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("mario");
        usuario.setEmail("mario@gmail.com");
        usuario.setRoles(List.of("lector", "administrador"));

        when(usuarioRepository.findAll()).thenReturn(Flux.just(usuario));

        StepVerifier.create(obtenerUsuariosUseCase.get())
                .expectNextMatches(usuarioDTO -> {
                    assert usuarioDTO.getId().equals(1);
                    assert usuarioDTO.getNombre().equals("mario");
                    assert usuarioDTO.getEmail().equals("mario@gmail.com");
                    assert usuarioDTO.getRoles().equals(List.of("lector", "administrador"));
                    return true;
                })
                .verifyComplete();

        verify(usuarioRepository).findAll();
    }

}

