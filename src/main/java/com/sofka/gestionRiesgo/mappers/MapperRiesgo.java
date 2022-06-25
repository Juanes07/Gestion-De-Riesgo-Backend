package com.sofka.gestionRiesgo.mappers;

import com.sofka.gestionRiesgo.collections.Riesgo;
import com.sofka.gestionRiesgo.models.RiesgoDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperRiesgo {

    public Riesgo riesgoDtoARiesgo(RiesgoDTO riesgoDTO) {
        var riesgo = new Riesgo();
        riesgo.setId(riesgoDTO.getId());
        riesgo.setIdProyecto(riesgoDTO.getIdProyecto());
        riesgo.setNombreProyecto(riesgoDTO.getNombreProyecto());
        riesgo.setNombreRiesgo(riesgoDTO.getNombreRiesgo());
        riesgo.setFechaDeteccion(riesgoDTO.getFechaDeteccion());
        riesgo.setFechaCierre(riesgoDTO.getFechaCierre());
        riesgo.setEtiquetas(riesgoDTO.getEtiquetas());
        riesgo.setDescripcionRiesgo(riesgoDTO.getDescripcionRiesgo());
        riesgo.setEstadoRiesgo(riesgoDTO.getEstadoRiesgo());
        riesgo.setAudencia(riesgoDTO.getAudencia());
        riesgo.setCategoria(riesgoDTO.getCategoria());
        riesgo.setTipoRiesgo(riesgoDTO.getTipoRiesgo());
        riesgo.setDetalleTipoRiesgo(riesgoDTO.getDetalleTipoRiesgo());
        riesgo.setProbabilidadDeOcurrenciaDelRiesgo(riesgoDTO.getProbabilidadDeOcurrenciaDelRiesgo());
        riesgo.setImpactoDeOcurrenciaDelRiesgo(riesgoDTO.getImpactoDeOcurrenciaDelRiesgo());
        riesgo.setDescripcionPlanDeMitigacion(riesgoDTO.getDescripcionPlanDeMitigacion());
        riesgo.setEmailsPlanDeMitigacion(riesgoDTO.getEmailsPlanDeMitigacion());
        riesgo.setDescripcionPlanDeContigencia(riesgoDTO.getDescripcionPlanDeContigencia());
        riesgo.setEmailsPlanDeContigencia(riesgoDTO.getEmailsPlanDeContigencia());
        riesgo.setValorCriticidad(riesgoDTO.getValorCriticidad());
        riesgo.setEstadoDeVidaDelRiesgo(riesgoDTO.getEstadoDeVidaDelRiesgo());
        return riesgo;
    }

    public RiesgoDTO riesgoARiesgoDto(Riesgo riesgo) {
        var riesgoDTO = new RiesgoDTO();
        riesgoDTO.setId(riesgo.getId());
        riesgoDTO.setIdProyecto(riesgo.getIdProyecto());
        riesgoDTO.setNombreProyecto(riesgo.getNombreProyecto());
        riesgoDTO.setNombreRiesgo(riesgo.getNombreRiesgo());
        riesgoDTO.setFechaDeteccion(riesgo.getFechaDeteccion());
        riesgoDTO.setFechaCierre(riesgo.getFechaCierre());
        riesgoDTO.setEtiquetas(riesgo.getEtiquetas());
        riesgoDTO.setDescripcionRiesgo(riesgo.getDescripcionRiesgo());
        riesgoDTO.setEstadoRiesgo(riesgo.getEstadoRiesgo());
        riesgoDTO.setAudencia(riesgo.getAudencia());
        riesgoDTO.setCategoria(riesgo.getCategoria());
        riesgoDTO.setTipoRiesgo(riesgo.getTipoRiesgo());
        riesgoDTO.setDetalleTipoRiesgo(riesgo.getDetalleTipoRiesgo());
        riesgoDTO.setProbabilidadDeOcurrenciaDelRiesgo(riesgo.getProbabilidadDeOcurrenciaDelRiesgo());
        riesgoDTO.setImpactoDeOcurrenciaDelRiesgo(riesgo.getImpactoDeOcurrenciaDelRiesgo());
        riesgoDTO.setDescripcionPlanDeMitigacion(riesgo.getDescripcionPlanDeMitigacion());
        riesgoDTO.setEmailsPlanDeMitigacion(riesgo.getEmailsPlanDeMitigacion());
        riesgoDTO.setDescripcionPlanDeContigencia(riesgo.getDescripcionPlanDeContigencia());
        riesgoDTO.setEmailsPlanDeContigencia(riesgo.getEmailsPlanDeContigencia());
        riesgoDTO.setValorCriticidad(riesgo.getValorCriticidad());
        riesgoDTO.setEstadoDeVidaDelRiesgo(riesgo.getEstadoDeVidaDelRiesgo());
        return riesgoDTO;

    }
}
