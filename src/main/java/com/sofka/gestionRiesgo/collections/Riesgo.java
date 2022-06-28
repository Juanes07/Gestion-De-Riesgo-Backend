package com.sofka.gestionRiesgo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document(collection = "riesgo")
public class Riesgo {

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
    private String descripcionPlanDeContigencia;
    private List<String> emailsPlanDeContigencia;
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
                  String descripcionPlanDeContigencia,
                  List<String> emailsPlanDeContigencia,
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
        this.descripcionPlanDeContigencia = descripcionPlanDeContigencia;
        this.emailsPlanDeContigencia = emailsPlanDeContigencia;
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
                ", descripcionPlanDeContigencia='" + descripcionPlanDeContigencia + '\'' +
                ", emailsPlanDeContigencia=" + emailsPlanDeContigencia +
                ", valorCriticidad=" + valorCriticidad +
                ", estadoDeVidaDelRiesgo='" + estadoDeVidaDelRiesgo + '\'' +
                '}';
    }
}