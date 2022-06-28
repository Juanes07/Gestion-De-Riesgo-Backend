package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.GuardarUsuario;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import com.sofka.gestionRiesgo.service.SequenceGeneratorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import static com.sofka.gestionRiesgo.collections.Usuario.SEQUENCE_USUARIO;

@Service
@Validated
public class CrearUsuarioUseCase implements GuardarUsuario {

    private final UsuarioRepository usuarioRepository;
    private final MapperUsuario mapperUsuario;

    private  final SequenceGeneratorService service;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository, MapperUsuario mapperUsuario, SequenceGeneratorService service) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUsuario = mapperUsuario;
        this.service = service;
    }

    @Override
    public Mono<UsuarioDTO> apply(UsuarioDTO usuarioDTO) {
        var usuarioDto2= service.getSequenceNumber(SEQUENCE_USUARIO).flatMap(id->{
            usuarioDTO.setId(id.intValue());
            return usuarioRepository
                    .save(mapperUsuario.usuarioDtoAUsuario(null).apply(usuarioDTO))
                    .thenReturn(usuarioDTO);
        });

        return usuarioDto2;



    }
}
