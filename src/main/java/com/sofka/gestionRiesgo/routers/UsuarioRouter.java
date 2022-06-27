package com.sofka.gestionRiesgo.routers;

import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.models.UsuarioDTO;
import com.sofka.gestionRiesgo.usecases.riesgosusecase.CrearRiesgoUseCase;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.ActualizarUsuarioPorIdUseCase;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.CrearUsuarioUseCase;
import com.sofka.gestionRiesgo.usecases.usuariosusecase.ObtenerUsuariosUseCase;
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
public class UsuarioRouter {

    @Bean
    @RouterOperation(beanClass = CrearUsuarioUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "usuarioDTO", summary = "Crear Usuario", tags = {"Usuario"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "email", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "roles", description = "List<String>")},

                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
                            @ApiResponse(responseCode = "404", description = "User not found")}))
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
    @RouterOperation(beanClass = CrearUsuarioUseCase.class, beanMethod = "apply",
            operation = @Operation(operationId = "usuarioDTO", summary = "Actualizar usuario por id", tags = {"Usuario"},
                    parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Integer"),
                            @Parameter(in = ParameterIn.PATH, name = "nombre", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "email", description = "String"),
                            @Parameter(in = ParameterIn.PATH, name = "roles", description = "List<String>")},

                    responses = {@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = UsuarioDTO.class))),
                            @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
                            @ApiResponse(responseCode = "404", description = "User not found")}))
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
    @RouterOperation(operation = @Operation(operationId = "Obtener todas los usuarios", summary = "Obtener todas los usuarios", tags = {"Usuario"},
            responses = {@ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid user supplied"),
                    @ApiResponse(responseCode = "404", description = "User not found")}))
    public RouterFunction<ServerResponse> obtenerUsuarios(ObtenerUsuariosUseCase useCase) {
        return route(GET("/obtenerUsuarios").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), UsuarioDTO.class))
        );
    }
}
