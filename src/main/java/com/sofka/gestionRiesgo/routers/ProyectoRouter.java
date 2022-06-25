package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.CrearProyectoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RestController
@Configuration
public class ProyectoRouter {

    @Bean
    public RouterFunction<ServerResponse> create(CrearProyectoUseCase useCase) {
        Function<ProyectoDTO, Mono<ServerResponse>> executor = proyectoDTO -> useCase.apply(proyectoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class).flatMap(executor)
        );
    }
}
