package com.sofka.gestionRiesgo.collections;
/**
 *
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @coleccion riesgo
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */

import java.util.List;

@Data
@Document(collection = "riesgo")
public class Riesgo {
    @Transient
    public static final String SEQUENCE_RIESGO = "riesgo_sequence";
    @Id
    private Integer id;
    private Integer idProyecto;

    private String creadorRiesgo;
    private String nombreProyecto;
    private String nombreRiesgo;
    private String fechaDeteccion;
    private String fechaCierre;
    private List<String> etiquetas;
    private String descripcionRiesgo;
    private String estadoRiesgo;
    private String audiencia;
    private String categoria;
    private String tipoRiesgo;
    private String detalleTipoRiesgo;
    private Integer probabilidadDeOcurrenciaDelRiesgo;
    private Integer impactoDeOcurrenciaDelRiesgo;
    private String descripcionPlanDeMitigacion;
    private List<String> emailsPlanDeMitigacion;
    private String descripcionPlanDeContingencia;
    private List<String> emailsPlanDeContingencia;
    private Integer valorCriticidad;
    private String estadoDeVidaDelRiesgo;


    public Riesgo() {
    }

    public Riesgo(Integer id,
                  Integer idProyecto,
                  String creadorRiesgo,
                  String nombreProyecto,
                  String nombreRiesgo,
                  String fechaDeteccion,
                  String fechaCierre,
                  List<String> etiquetas,
                  String descripcionRiesgo,
                  String estadoRiesgo,
                  String audiencia,
                  String categoria,
                  String tipoRiesgo,
                  String detalleTipoRiesgo,
                  Integer probabilidadDeOcurrenciaDelRiesgo,
                  Integer impactoDeOcurrenciaDelRiesgo,
                  String descripcionPlanDeMitigacion,
                  List<String> emailsPlanDeMitigacion,
                  String descripcionPlanDeContingencia,
                  List<String> emailsPlanDeContingencia,
                  Integer valorCriticidad,
                  String estadoDeVidaDelRiesgo) {
        this.id = id;
        this.idProyecto = idProyecto;
        this.creadorRiesgo = creadorRiesgo;
        this.nombreProyecto = nombreProyecto;
        this.nombreRiesgo = nombreRiesgo;
        this.fechaDeteccion = fechaDeteccion;
        this.fechaCierre = fechaCierre;
        this.etiquetas = etiquetas;
        this.descripcionRiesgo = descripcionRiesgo;
        this.estadoRiesgo = estadoRiesgo;
        this.audiencia = audiencia;
        this.categoria = categoria;
        this.tipoRiesgo = tipoRiesgo;
        this.detalleTipoRiesgo = detalleTipoRiesgo;
        this.probabilidadDeOcurrenciaDelRiesgo = probabilidadDeOcurrenciaDelRiesgo;
        this.impactoDeOcurrenciaDelRiesgo = impactoDeOcurrenciaDelRiesgo;
        this.descripcionPlanDeMitigacion = descripcionPlanDeMitigacion;
        this.emailsPlanDeMitigacion = emailsPlanDeMitigacion;
        this.descripcionPlanDeContingencia = descripcionPlanDeContingencia;
        this.emailsPlanDeContingencia = emailsPlanDeContingencia;
        this.valorCriticidad = valorCriticidad;
        this.estadoDeVidaDelRiesgo = estadoDeVidaDelRiesgo;
    }

    @Override
    public String toString() {
        return "Riesgo{" +
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