package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;
/**
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Service
@Validated
public class ObtenerRiesgoPorIdUseCase implements Function<String, Mono<RiesgoDTO>> {

    private final RiesgoRepository riesgoRepository;
    private final MapperRiesgo mapperRiesgo;

    public ObtenerRiesgoPorIdUseCase(RiesgoRepository riesgoRepository, MapperRiesgo mapperRiesgo) {
        this.riesgoRepository = riesgoRepository;
        this.mapperRiesgo = mapperRiesgo;
    }

    @Override
    public Mono<RiesgoDTO> apply(String id) {
        return riesgoRepository
                .findById(Integer.parseInt(id))
                .map(riesgo -> mapperRiesgo.riesgoARiesgoDto().apply(riesgo));


    }
}
