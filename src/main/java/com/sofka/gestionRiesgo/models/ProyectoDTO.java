package com.sofka.gestionRiesgo.models;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class ProyectoDTO {

    @NotBlank(message = "Debe existir el Id para este objeto")
    private Integer id;

    @Length(min = 5, max = 50, message = "la longitud del nombre debe estar entre 5 y 50 caracteres")
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La fechaInicio es requerida")
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Length(min = 5, max = 50, message = "la longitud de las etiquetas debe estar entre 5 y 50 caracteres")
    private List<String> etiquetas;

    @NotBlank(message = "Los emails son requeridos")
    private List<String> emails;

    @Length(min = 5, max = 699, message = "la longitud de la descripcion debe estar entre 5 y 699 caracteres")
    @NotBlank(message = "La descripcion es requerida")
    private String descripcion;


    public ProyectoDTO(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, List<String> etiquetas, List<String> emails, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etiquetas = etiquetas;
        this.emails = emails;
        this.descripcion = descripcion;
    }

    public ProyectoDTO(Integer id, String nombre, LocalDate fechaInicio, List<String> etiquetas, List<String> emails, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.etiquetas = etiquetas;
        this.emails = emails;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ProyectoDTO{" +
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
