package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperRiesgo {

    public Function<RiesgoDTO, Riesgo> riesgoDtoARiesgo(Object o) {
        return riesgoDTO -> {
            var riesgo = new Riesgo();
            riesgo.setId(riesgoDTO.getId());
            riesgo.setIdProyecto(riesgoDTO.getIdProyecto());
            riesgo.setCreadorRiesgo(riesgoDTO.getCreadorRiesgo());
            riesgo.setNombreProyecto(riesgoDTO.getNombreProyecto());
            riesgo.setNombreRiesgo(riesgoDTO.getNombreRiesgo());
            riesgo.setFechaDeteccion(riesgoDTO.getFechaDeteccion());
            riesgo.setFechaCierre(riesgoDTO.getFechaCierre());
            riesgo.setEtiquetas(riesgoDTO.getEtiquetas());
            riesgo.setDescripcionRiesgo(riesgoDTO.getDescripcionRiesgo());
            riesgo.setEstadoRiesgo(riesgoDTO.getEstadoRiesgo());
            riesgo.setAudiencia(riesgoDTO.getAudiencia());
            riesgo.setCategoria(riesgoDTO.getCategoria());
            riesgo.setTipoRiesgo(riesgoDTO.getTipoRiesgo());
            riesgo.setDetalleTipoRiesgo(riesgoDTO.getDetalleTipoRiesgo());
            riesgo.setProbabilidadDeOcurrenciaDelRiesgo(riesgoDTO.getProbabilidadDeOcurrenciaDelRiesgo());
            riesgo.setImpactoDeOcurrenciaDelRiesgo(riesgoDTO.getImpactoDeOcurrenciaDelRiesgo());
            riesgo.setDescripcionPlanDeMitigacion(riesgoDTO.getDescripcionPlanDeMitigacion());
            riesgo.setEmailsPlanDeMitigacion(riesgoDTO.getEmailsPlanDeMitigacion());
            riesgo.setDescripcionPlanDeContingencia(riesgoDTO.getDescripcionPlanDeContingencia());
            riesgo.setEmailsPlanDeContingencia(riesgoDTO.getEmailsPlanDeContingencia());
            riesgo.setValorCriticidad(riesgoDTO.getValorCriticidad());
            riesgo.setEstadoDeVidaDelRiesgo(riesgoDTO.getEstadoDeVidaDelRiesgo());
            return riesgo;
        };
    }

    public Function<Riesgo, RiesgoDTO> riesgoARiesgoDto() {
        return riesgo -> new RiesgoDTO(
                riesgo.getId(),
                riesgo.getIdProyecto(),
                riesgo.getCreadorRiesgo(),
                riesgo.getNombreProyecto(),
                riesgo.getNombreRiesgo(),
                riesgo.getFechaDeteccion(),
                riesgo.getFechaCierre(),
                riesgo.getEtiquetas(),
                riesgo.getDescripcionRiesgo(),
                riesgo.getEstadoRiesgo(),
                riesgo.getAudiencia(),
                riesgo.getCategoria(),
                riesgo.getTipoRiesgo(),
                riesgo.getDetalleTipoRiesgo(),
                riesgo.getProbabilidadDeOcurrenciaDelRiesgo(),
                riesgo.getImpactoDeOcurrenciaDelRiesgo(),
                riesgo.getDescripcionPlanDeMitigacion(),
                riesgo.getEmailsPlanDeMitigacion(),
                riesgo.getDescripcionPlanDeContingencia(),
                riesgo.getEmailsPlanDeContingencia(),
                riesgo.getValorCriticidad(),
                riesgo.getEstadoDeVidaDelRiesgo()
        );

    }
}
