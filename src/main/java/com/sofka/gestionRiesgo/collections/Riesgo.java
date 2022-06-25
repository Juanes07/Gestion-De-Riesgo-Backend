package com.sofka.gestionRiesgo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "riesgo")
public class Riesgo {

    @Id
    private Integer id;
    private Integer idProyecto;
    private String nombreRiesgo;
    private LocalDate fechaDeteccion;
    private LocalDate fechaCierre;
    private List<String> etiquetas;
    private String descripcionRiesgo;
    private String estadoRiesgo;
    private String audencia;
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
                  String nombreRiesgo,
                  LocalDate fechaDeteccion,
                  LocalDate fechaCierre,
                  List<String> etiquetas,
                  String descripcionRiesgo,
                  String estadoRiesgo,
                  String audencia,
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
        this.nombreRiesgo = nombreRiesgo;
        this.fechaDeteccion = fechaDeteccion;
        this.fechaCierre = fechaCierre;
        this.etiquetas = etiquetas;
        this.descripcionRiesgo = descripcionRiesgo;
        this.estadoRiesgo = estadoRiesgo;
        this.audencia = audencia;
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
                ", nombreRiesgo='" + nombreRiesgo + '\'' +
                ", fechaDeteccion=" + fechaDeteccion +
                ", fechaCierre=" + fechaCierre +
                ", etiquetas=" + etiquetas +
                ", descripcionRiesgo='" + descripcionRiesgo + '\'' +
                ", estadoRiesgo='" + estadoRiesgo + '\'' +
                ", audencia='" + audencia + '\'' +
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