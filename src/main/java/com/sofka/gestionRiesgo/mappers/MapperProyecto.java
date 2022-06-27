package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperProyecto {

    public Function<ProyectoDTO, Proyecto> proyectoDtoAProyecto(Object o) {
        return proyectoDTO -> {
            var proyecto = new Proyecto();
            proyecto.setId(proyectoDTO.getId());
            proyecto.setNombre(proyectoDTO.getNombre());
            proyecto.setFechaInicio(proyectoDTO.getFechaInicio());
            proyecto.setFechaFin(proyectoDTO.getFechaFin());
            proyecto.setEtiquetas(proyectoDTO.getEtiquetas());
            proyecto.setResponsables(proyectoDTO.getResponsables());
            proyecto.setDescripcion(proyectoDTO.getDescripcion());
            proyecto.setLiderProyecto(proyectoDTO.getLiderProyecto());
            proyecto.setEstado(proyectoDTO.getEstado());
            return proyecto;
        };
    }


    public  Function<Proyecto, ProyectoDTO> proyectoAProyectoDto() {
        return proyecto -> new ProyectoDTO(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                proyecto.getEtiquetas(),
                proyecto.getResponsables(),
                proyecto.getDescripcion(),
                proyecto.getLiderProyecto(),
                proyecto.getEstado()
        );
    }
}

