package com.sofka.gestionRiesgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
/**
 * @coleccion riesgoDTO
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RiesgoDTO {
    private Integer id;

    private Integer idProyecto;

    private String creadorRiesgo;

    @NotBlank(message = "Debe existir el nombreProyecto para este objeto")
    private String nombreProyecto;

    @Length(min = 5, max = 50, message = "la longitud del nombreRiesgo debe estar entre 5 y 50 caracteres")
    @NotBlank(message = "Debe existir el nombreRiesgo para este objeto")
    private String nombreRiesgo;

    @NotBlank(message = "Debe existir el fechaDeteccion para este objeto")
    private String fechaDeteccion;

    private String fechaCierre;

    private List<String> etiquetas;

    @Length(min = 2, max = 699, message = "la longitud de la descripcion debe estar entre 5 y 699 caracteres")
    @NotBlank(message = "Debe existir el descripcionRiesgo para este objeto")
    private String descripcionRiesgo;

    @NotBlank(message = "Debe existir el estadoRiesgo para este objeto")
    private String estadoRiesgo;

    @NotBlank(message = "Debe existir el audiencia para este objeto")
    private String audiencia;

    @NotBlank(message = "Debe existir el categoria para este objeto")
    private String categoria;

    @NotBlank(message = "Debe existir el tipoRiesgo para este objeto")
    private String tipoRiesgo;

    @Length(min = 5, max = 500, message = "la longitud del detalleTipoRiesgo debe estar entre 5 y 500 caracteres")
    @NotBlank(message = "Debe existir el detalleTipoRiesgo para este objeto")
    private String detalleTipoRiesgo;

    private Integer probabilidadDeOcurrenciaDelRiesgo;

    private Integer impactoDeOcurrenciaDelRiesgo;

    @Length(min = 5, max = 1000, message = "la longitud del descripcionPlanMitigacion debe estar entre 5 y 1000 caracteres")
    @NotBlank(message = "Debe existir el descripcionPlanDeMitigacion para este objeto")
    private String descripcionPlanDeMitigacion;

    @Size(min = 1,  message = "Debe existir al menos una persona responsable para el plan de mitigacion")
    private List<String> emailsPlanDeMitigacion;

    @Length(min = 5, max = 1000, message = "la longitud del descripcionPlanContigencia debe estar entre 5 y 1000 caracteres")
    @NotBlank(message = "Debe existir la descripcionPlanDeContigencia para este objeto")
    private String descripcionPlanDeContingencia;
    @Size(min = 1,  message = "Debe existir al menos una persona responsable para el plan de contigencia")
    private List<String> emailsPlanDeContingencia;

    private Integer valorCriticidad;

    @NotBlank(message = "Debe existir el estadoDeVidaDelRiesgo para este objeto")
    private String estadoDeVidaDelRiesgo;


    @Override
    public String toString() {
        return "RiesgoDTO{" +
                "id=" + id +
                ", idProyecto=" + idProyecto +
                ", creadorRiesgo='" + creadorRiesgo + '\'' +
                ", nombreProyecto='" + nombreProyecto + '\'' +
                ", nombreRiesgo='" + nombreRiesgo + '\'' +
                ", fechaDeteccion=" + fechaDeteccion +
                ", fechaCierre=" + fechaCierre +
                ", etiquetas=" + etiquetas +
                ", descripcionRiesgo='" + descripcionRiesgo + '\'' +
                ", estadoRiesgo='" + estadoRiesgo + '\'' +
                ", audencia='" + audiencia + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tipoRiesgo='" + tipoRiesgo + '\'' +
                ", detalleTipoRiesgo='" + detalleTipoRiesgo + '\'' +
                ", probabilidadDeOcurrenciaDelRiesgo=" + probabilidadDeOcurrenciaDelRiesgo +
                ", impactoDeOcurrenciaDelRiesgo=" + impactoDeOcurrenciaDelRiesgo +
                ", descripcionPlanDeMitigacion='" + descripcionPlanDeMitigacion + '\'' +
                ", emailsPlanDeMitigacion=" + emailsPlanDeMitigacion +
                ", descripcionPlanDeContigencia='" + descripcionPlanDeContingencia + '\'' +
                ", emailsPlanDeContigencia=" + emailsPlanDeContingencia +
                ", valorCriticidad=" + valorCriticidad +
                ", estadoDeVidaDelRiesgo='" + estadoDeVidaDelRiesgo + '\'' +
                '}';
    }
}
