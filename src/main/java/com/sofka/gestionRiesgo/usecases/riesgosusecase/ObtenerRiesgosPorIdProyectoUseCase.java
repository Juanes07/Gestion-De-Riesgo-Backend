package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
@Service
@Validated
public class ObtenerRiesgosPorIdProyectoUseCase implements Function<String, Flux<RiesgoDTO>> {

    private final RiesgoRepository riesgoRepository;
    private final MapperRiesgo mapperRiesgo;

    public ObtenerRiesgosPorIdProyectoUseCase(RiesgoRepository riesgoRepository, MapperRiesgo mapperRiesgo) {
        this.riesgoRepository = riesgoRepository;
        this.mapperRiesgo = mapperRiesgo;
    }


    @Override
    public Flux<RiesgoDTO> apply(String id) {
        return riesgoRepository.findAllByIdProyecto(Integer.parseInt(id))
                .map(riesgo -> mapperRiesgo.riesgoARiesgoDto().apply(riesgo));
    }
}
