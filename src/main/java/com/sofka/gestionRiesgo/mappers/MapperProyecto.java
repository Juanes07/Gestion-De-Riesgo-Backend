package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Proyecto;
import com.sofka.gestionRiesgo.models.ProyectoDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperProyecto {

    public Proyecto proyectoDtoAProyecto(ProyectoDTO proyectoDTO) {
        var proyecto = new Proyecto();
        proyecto.setId(proyectoDTO.getId());
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setFechaInicio(proyectoDTO.getFechaInicio());
        proyecto.setFechaFin(proyectoDTO.getFechaFin());
        proyecto.setEtiquetas(proyectoDTO.getEtiquetas());
        proyecto.setResponsables(proyectoDTO.getResponsables());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setLiderProyecto(proyectoDTO.getLiderProyecto());
        return proyecto;
    }


    public  ProyectoDTO proyectoAProyectoDto(Proyecto proyecto) {
        var proyectoDTO = new ProyectoDTO();
        proyectoDTO.setId(proyecto.getId());
        proyectoDTO.setNombre(proyecto.getNombre());
        proyectoDTO.setFechaInicio(proyecto.getFechaInicio());
        proyectoDTO.setFechaFin(proyecto.getFechaFin());
        proyectoDTO.setEtiquetas(proyecto.getEtiquetas());
        proyectoDTO.setResponsables(proyecto.getResponsables());
        proyectoDTO.setDescripcion(proyecto.getDescripcion());
        proyectoDTO.setLiderProyecto(proyecto.getLiderProyecto());
        return proyectoDTO;
    }
}
