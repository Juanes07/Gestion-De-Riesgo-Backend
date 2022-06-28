package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.collections.Usuario;
import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import com.sofka.gestionRiesgo.service.SequenceGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CrearUsuarioUseCaseTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    CrearUsuarioUseCase crearUsuarioUseCase;

    MapperUsuario mapperUsuario = new MapperUsuario();

    @Mock
    SequenceGeneratorService service;


    @BeforeEach
    public void setUp() {
        service = Mockito.mock(SequenceGeneratorService.class);
        usuarioRepository = mock(UsuarioRepository.class);
        crearUsuarioUseCase = new CrearUsuarioUseCase(usuarioRepository, mapperUsuario, service);

    }

    @Test
    void getValidationCreateTest() {
        var usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("mario");
        usuario.setEmail("mario@gmail.com");
        usuario.setRoles(List.of("lector", "administrador"));


        var usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setRoles(usuario.getRoles());


        when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(Mono.just(usuario));

        when(service.getSequenceNumber("user_sequence")).thenReturn(Mono.just(1));

        StepVerifier.create(crearUsuarioUseCase.apply(usuarioDTO))

                .expectNextMatches(q -> {

                    assert usuarioDTO.getId().equals(q.getId());
                    assert usuarioDTO.getNombre().equals("mario");
                    assert usuarioDTO.getEmail().equals("mario@gmail.com");
                    assert usuarioDTO.getRoles().equals(List.of("lector", "administrador"));
                    return true;
                }).verifyComplete();

        verify(service).getSequenceNumber("user_sequence");
    }
}





