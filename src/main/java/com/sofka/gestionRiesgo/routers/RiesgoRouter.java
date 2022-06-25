package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ActualizarProyectoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ObtenerProyectoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.ActualizarRiesgoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.CrearRiesgoUseCase;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.ObtenerRiesgoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.ObtenerRiesgosPorIdProyectoUseCase;
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
public class RiesgoRouter {

    @Bean
    public RouterFunction<ServerResponse> crearRiesgo(CrearRiesgoUseCase useCase) {
        Function<RiesgoDTO, Mono<ServerResponse>> executor = riesgoDTO -> useCase.apply(riesgoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crearRiesgo").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RiesgoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarRiesgo(ActualizarRiesgoPorIdUseCase useCase) {
        Function<RiesgoDTO, Mono<ServerResponse>> executor = riesgoDTO -> useCase.apply(riesgoDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                PUT("/actualizarRiesgo/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RiesgoDTO.class).flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> obtenerRiesgoPorId(ObtenerRiesgoPorIdUseCase useCase) {
        return route(
                GET("/obtenerRiesgo/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.apply(request.pathVariable("id")),
                                RiesgoDTO.class
                        ))
        );

    }

    @Bean
    public RouterFunction<ServerResponse> obtenerRiesgoPorIdProyecto(ObtenerRiesgosPorIdProyectoUseCase useCase) {
        return route(
                GET("/obtenerRiesgoPorProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.apply(request.pathVariable("id")),
                                RiesgoDTO.class
                        ))
        );

    }

}
