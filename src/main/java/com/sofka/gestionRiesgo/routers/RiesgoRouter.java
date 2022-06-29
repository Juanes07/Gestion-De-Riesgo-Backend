package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.ProyectoDTO;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ActualizarProyectoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.proyectousecase.CrearProyectoUseCase;
import com.sofka.gestionRiesgo.usecases.proyectousecase.ObtenerProyectoPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.*;
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
public class RiesgoRouter {

    @Bean
    @RouterOperation(beanClass = CrearRiesgoUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "riesgoDTO", summary = "Crear Riesgo", tags = {"Riesgo"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombreProyecto", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "nombreRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaDeteccion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaCierre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "responsables", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "etiquetas", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "estadoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "audiencia", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "categoria", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "tipoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "detalleTipoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = " probabilidadDeOcurrenciaDelRiesgo", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "impactoDeOcurrenciaDelRiesgo", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionPlanDeMitigacion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "emailsPlanDeMitigacion", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionPlanDeContigencia", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "emailsPlanDeContigencia", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "valorCriticidad", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "estadoDeVidaDelRiesgo", description = "String")},

                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = RiesgoDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid risk supplied"),
                            @ApiResponse(responseCode = "404", description = "Risk not found")}))
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
    @RouterOperation(beanClass = ActualizarRiesgoPorIdUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "riesgoDTO", summary = "Actualizar riesgo por id", tags = {"Riesgo"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombreProyecto", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "nombreRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaDeteccion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "fechaCierre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "responsables", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "etiquetas", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "estadoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "audiencia", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "categoria", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "tipoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "detalleTipoRiesgo", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = " probabilidadDeOcurrenciaDelRiesgo", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "impactoDeOcurrenciaDelRiesgo", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionPlanDeMitigacion", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "emailsPlanDeMitigacion", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "descripcionPlanDeContigencia", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "emailsPlanDeContigencia", description = "List<String>"),
                            @Parameter(in = ParameterIn.PATH, name = "valorCriticidad", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "estadoDeVidaDelRiesgo", description = "String")},

                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = RiesgoDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid risk supplied"),
                            @ApiResponse(responseCode = "404", description = "Risk not found")}))

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
    @RouterOperation(operation = @Operation(operationId = "Obtener riesgo por id", summary = "Obtener riesgo por id", tags = {"Riesgo"},
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer")},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid risk ID supplied"),
                    @ApiResponse(responseCode = "404", description = "risk not found")}))
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
    @RouterOperation(operation = @Operation(operationId = "Obtener riesgo por id de proyecto", summary = "Obtener riesgo por id de proyecto", tags = {"Riesgo"},
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer")},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid risk ID supplied"),
                    @ApiResponse(responseCode = "404", description = "risk not found")}))
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

    @Bean
    @RouterOperation(operation = @Operation(operationId = "Eliminar riesgo por id", summary = "Eliminar riesgo por id", tags = {"Riesgo"},
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer")},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid risk ID supplied"),
                    @ApiResponse(responseCode = "404", description = "risk not found")}))
    public RouterFunction<ServerResponse> eliminarRiesgoPorId(EliminarRiesgoPorIdUseCase useCase) {
        return route(
                PUT("/eliminarRiesgoPorId/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.apply(request.pathVariable("id")),
                                RiesgoDTO.class
                        ))
        );

    }

}
