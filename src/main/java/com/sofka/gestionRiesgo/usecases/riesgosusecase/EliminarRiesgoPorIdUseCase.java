package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class EliminarRiesgoPorIdUseCase implements Function<String, Mono<RiesgoDTO>> {

    private final RiesgoRepository riesgoRepository;

    private final MapperRiesgo mapperRiesgo;


    public EliminarRiesgoPorIdUseCase(RiesgoRepository riesgoRepository, MapperRiesgo mapperRiesgo) {
        this.riesgoRepository = riesgoRepository;
        this.mapperRiesgo = mapperRiesgo;
    }

    @Override
    public Mono<RiesgoDTO> apply(String s) {
        return riesgoRepository.findById(Integer.parseInt(s)).flatMap(riesgo -> {
            riesgo.setEstadoDeVidaDelRiesgo("Inactivo");
            return riesgoRepository.save(riesgo).map(mapperRiesgo.riesgoARiesgoDto());
        });
    }

}



