package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
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
    @RouterOperation(beanClass = CrearProyectoUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "ProyectoDTO", summary = "Crear Proyecto", tags = {"Proyecto"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaInicio", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaFin", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "etiquetas", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "responsables", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "liderProyecto", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "estado", description = "String")},
                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProyectoDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid project supplied"),
                            @ApiResponse(responseCode = "404", description = "Project not found")}))
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
    @RouterOperation(beanClass = CrearProyectoUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "ProyectoDTO", summary = "Actualizar proyecto por id", tags = {"Proyecto"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaInicio", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaFin", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "etiquetas", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "responsables", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "liderProyecto", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "estado", description = "String")},
                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ProyectoDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid project supplied"),
                            @ApiResponse(responseCode = "404", description = "Project not found")}))

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
    @RouterOperation(beanClass = EliminarProyectoPorIdUserCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "Eliminar proyecto por id", summary = "Eliminar proyecto por id", tags = {"Proyecto"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer")},
                    responses = {@ApiResponse(responseCode = "202", description = "successful operation"),
                            @ApiResponse(responseCode = "400", description = "Invalid project ID supplied"),
                            @ApiResponse(responseCode = "404", description = "Project not found")}))
    public RouterFunction<ServerResponse> eliminarProyecto(EliminarProyectoPorIdUserCase useCase) {
        return route(
                DELETE("/eliminarProyecto/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("id")), void.class))
        );
    }

    @Bean
    @RouterOperation(operation = @Operation(operationId = "Obtener todas los proyectos", summary = "Obtener todas los proyectos", tags = {"Proyecto"},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid project supplied"),
                    @ApiResponse(responseCode = "404", description = "Project not found")}))
    public RouterFunction<ServerResponse> obtenerProyectos(ObtenerProyectosUseCase useCase) {
        return route(GET("/obtenerProyectos").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), ProyectoDTO.class))
        );
    }

    @Bean
    @RouterOperation(operation = @Operation(operationId = "Obtener proyecto por id", summary = "Obtener proyecto por id", tags = {"Proyecto"},
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer")},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid project ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Project not found")}))
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
