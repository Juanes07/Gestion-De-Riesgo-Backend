package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.GuardarRiesgo;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearRiesgoUseCase implements GuardarRiesgo {

    private final RiesgoRepository riesgoRepository;
    private final MapperRiesgo mapperRiesgo;

    public CrearRiesgoUseCase(RiesgoRepository riesgoRepository, MapperRiesgo mapperRiesgo) {
        this.riesgoRepository = riesgoRepository;
        this.mapperRiesgo = mapperRiesgo;
    }

    @Override
    public Mono<RiesgoDTO> apply(RiesgoDTO riesgoDTO) {
        return riesgoRepository
                .save(mapperRiesgo.riesgoDtoARiesgo(null).apply(riesgoDTO))
                .thenReturn(riesgoDTO);
    }
}

