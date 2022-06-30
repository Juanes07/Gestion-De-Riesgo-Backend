package com.sofka.gestionRiesgo.usecases.usuariosusecase;

import com.sofka.gestionRiesgo.mappers.MapperUsuario;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;
/**
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Service
@Validated
public class ObtenerUsuariosUseCase implements Supplier<Flux<UsuarioDTO>> {

    private final UsuarioRepository usuarioRepository;
    private final MapperUsuario mapperUsuario;


    public ObtenerUsuariosUseCase(UsuarioRepository usuarioRepository, MapperUsuario mapperUsuario) {
        this.usuarioRepository = usuarioRepository;
        this.mapperUsuario = mapperUsuario;
    }

    @Override
    public Flux<UsuarioDTO> get() {
        return usuarioRepository.findAll()
                .map(usuario -> mapperUsuario.usuarioAUsuarioDto().apply(usuario));

    }
}
