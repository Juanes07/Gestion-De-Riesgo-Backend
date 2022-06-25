package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ActualizarProyectoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.proyectousecase.CrearProyectoUseCase;
import com.sofka.gestionRiesgo.usecases.proyectousecase.EliminarProyectoPorIdUserCase;
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
public class ProyectoRouter {

    @Bean
    public RouterFunction<ServerResponse> crear(CrearProyectoUseCase useCase) {
        Function<ProyectoDTO, Mono<ServerResponse>> executor = proyectoDTO -> useCase.apply(proyectoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> actualizar(ActualizarProyectoPorIdUseCase useCase) {
        Function<ProyectoDTO, Mono<ServerResponse>> executor = proyectoDTO -> useCase.apply(proyectoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                PUT("/actualizar").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> delete(EliminarProyectoPorIdUserCase useCase) {
        return route(
                DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), Void.class))
        );
    }


}
