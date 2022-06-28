package com.sofka.gestionRiesgo.usecases.riesgosusecase;

import com.sofka.gestionRiesgo.mappers.MapperRiesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import com.sofka.gestionRiesgo.repository.GuardarRiesgo;
import com.sofka.gestionRiesgo.repository.ProyectoRepository;
import com.sofka.gestionRiesgo.repository.RiesgoRepository;
import com.sofka.gestionRiesgo.service.SequenceGeneratorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import static com.sofka.gestionRiesgo.collections.Riesgo.SEQUENCE_RIESGO;

@Service
@Validated
public class CrearRiesgoUseCase implements GuardarRiesgo {
    private final ProyectoRepository proyectoRepository;
    private final RiesgoRepository riesgoRepository;
    private final MapperRiesgo mapperRiesgo;

    private final SequenceGeneratorService service;

    public CrearRiesgoUseCase(ProyectoRepository proyectoRepository, RiesgoRepository riesgoRepository, MapperRiesgo mapperRiesgo, SequenceGeneratorService service) {
        this.proyectoRepository = proyectoRepository;
        this.riesgoRepository = riesgoRepository;
        this.mapperRiesgo = mapperRiesgo;
        this.service = service;
    }


    @Override
    public Mono<RiesgoDTO> apply(RiesgoDTO riesgoDTO) {
        var riesgoDto = service.getSequenceNumber(SEQUENCE_RIESGO).flatMap(id -> {
                    riesgoDTO.setId(id.intValue());
                    return proyectoRepository.findById(riesgoDTO.getIdProyecto())
                            .flatMap(proyecto -> {
                                riesgoDTO.setNombreProyecto(proyecto.getNombre());
                                return riesgoRepository
                                        .save(mapperRiesgo.riesgoDtoARiesgo(null).apply(riesgoDTO))
                                        .thenReturn(riesgoDTO);

                            });


                }

        );


        return riesgoDto;
    }
}