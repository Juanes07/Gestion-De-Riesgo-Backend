package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.*;
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
    public RouterFunction<ServerResponse> crearProyecto(CrearProyectoUseCase useCase) {
        Function<ProyectoDTO, Mono<ServerResponse>> executor = proyectoDTO -> useCase.apply(proyectoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crearProyecto").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarProyecto(ActualizarProyectoPorIdUseCase useCase) {
        Function<ProyectoDTO, Mono<ServerResponse>> executor = proyectoDTO -> useCase.apply(proyectoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                PUT("/actualizarProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProyectoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> eliminarProyecto(EliminarProyectoPorIdUserCase useCase) {
        return route(
                DELETE("/eliminarProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> obtenerProyectos(ObtenerProyectosUseCase useCase) {
        return route(GET("/obtenerProyectos").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), ProyectoDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> obtenerProyectosPorId(ObtenerProyectoPorIdUseCase useCase) {
        return route(
                GET("/obtenerProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.apply(request.pathVariable("id")),
                                ProyectoDTO.class
                        ))
        );

    }

}
