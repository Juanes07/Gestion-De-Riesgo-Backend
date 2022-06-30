package com.sofka.gestionRiesgo.collections;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 * @coleccion proyecto
 * @author camila morales
 * @author Duvan Botero
 * @version 1.0
 */
@Data
@Document(collection = "proyecto")
public class Proyecto {

    @Transient
    public static final String SEQUENCE_PROYECTO = "proyecto_sequence";

    @Id
    private Integer id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private List<String> etiquetas;
    private List<String> responsables;
    private String descripcion;
    private String liderProyecto;
    private String estado;

    public Proyecto() {
    }

    public Proyecto(Integer id, String nombre, String fechaInicio, String fechaFin, List<String> etiquetas, List<String> responsables, String descripcion, String liderProyecto, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etiquetas = etiquetas;
        this.responsables = responsables;
        this.descripcion = descripcion;
        this.liderProyecto = liderProyecto;
        this.estado = estado;
    }

    public Proyecto(Integer id, String nombre, String fechaInicio, String fechaFin, String descripcion, String liderProyecto, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.liderProyecto = liderProyecto;
        this.estado = estado;

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
                ", estado='" + estado + '\'' +
                '}';
    }
}
