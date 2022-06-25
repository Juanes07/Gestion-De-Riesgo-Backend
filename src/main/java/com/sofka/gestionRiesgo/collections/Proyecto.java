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
    private String fechaInicio;
    private String fechaFin;
    private List<String> etiquetas;
    private List<String> responsables;
    private String descripcion;
    private String liderProyecto;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String fechaInicio, String fechaFin, List<String> etiquetas, List<String> responsables, String descripcion, String liderProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etiquetas = etiquetas;
        this.responsables = responsables;
        this.descripcion = descripcion;
        this.liderProyecto = liderProyecto;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", etiquetas=" + etiquetas +
                ", responsables=" + responsables +
                ", descripcion='" + descripcion + '\'' +
                ", liderProyecto='" + liderProyecto + '\'' +
                '}';
    }
}
