package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.ActualizarUsuarioPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.CrearUsuarioUseCase;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.ObtenerUsuariosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RestController
@Configuration
public class UsuarioRouter {

    @Bean
    public RouterFunction<ServerResponse> crearUsuario(CrearUsuarioUseCase useCase) {
        Function<UsuarioDTO, Mono<ServerResponse>> executor = usuarioDTO -> useCase.apply(usuarioDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crearUsuario").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UsuarioDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarUsuario(ActualizarUsuarioPorIdUseCase useCase) {
        Function<UsuarioDTO, Mono<ServerResponse>> executor = usuarioDTO -> useCase.apply(usuarioDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                PUT("/actualizarUsuario/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UsuarioDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> obtenerUsuarios(ObtenerUsuariosUseCase useCase) {
        return route(GET("/obtenerUsuarios").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), UsuarioDTO.class))
        );
    }
}
