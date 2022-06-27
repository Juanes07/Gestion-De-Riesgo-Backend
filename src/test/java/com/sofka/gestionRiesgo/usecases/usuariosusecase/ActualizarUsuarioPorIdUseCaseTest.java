package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.collections.Usuario;
import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.ObtenerRiesgosPorIdProyectoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActualizarUsuarioPorIdUseCaseTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    ActualizarUsuarioPorIdUseCase actualizarUsuarioPorIdUseCase;

    MapperUsuario mapperUsuario = new MapperUsuario();

    @BeforeEach
    public void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        actualizarUsuarioPorIdUseCase = new ActualizarUsuarioPorIdUseCase(usuarioRepository, mapperUsuario);
    }

    @Test
    void getValidationUpdateTest(){
        var usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("correo@gmail.com");
        usuario.setRoles(List.of("lector", "mantenedor", "admin"));
        usuario.setNombre("Juanes");

        UsuarioDTO usuarioDTO = mapperUsuario.usuarioAUsuarioDto().apply(usuario);

        usuarioDTO.setNombre("Juan Esteban");

        when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        StepVerifier.create(actualizarUsuarioPorIdUseCase.apply(usuarioDTO))
                .expectNextMatches(usuarioDTO1 -> {
                    assertEquals(usuarioDTO1.getNombre(),"Juan Esteban");
                    return true;
                })
                .verifyComplete();

        verify(usuarioRepository).save(Mockito.any(Usuario.class));
    }

}