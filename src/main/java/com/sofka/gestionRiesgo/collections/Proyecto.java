package com.sofka.gestionRiesgo.collections;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "proyecto")
public class Proyecto {

    @Id
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<String> etiquetas;
    private List<String> emails;
    private String descripcion;


    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, List<String> etiquetas, List<String> emails, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etiquetas = etiquetas;
        this.emails = emails;
        this.descripcion = descripcion;
    }

    public Proyecto(Integer id, String nombre, LocalDate fechaInicio, List<String> etiquetas, List<String> emails, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.etiquetas = etiquetas;
        this.emails = emails;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", etiquetas=" + etiquetas +
                ", emails=" + emails +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
