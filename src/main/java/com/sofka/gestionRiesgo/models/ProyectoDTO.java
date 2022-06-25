package com.sofka.gestionRiesgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProyectoDTO {

    private Integer id;

    @Length(min = 5, max = 50, message = "la longitud del nombre debe estar entre 5 y 50 caracteres")
    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "La fechaInicio es requerida")
    private String fechaInicio ;

    private String fechaFin ;

    private List<String> etiquetas;

    private List<String> responsables;

    @Length(min = 5, max = 699, message = "la longitud de la descripcion debe estar entre 5 y 699 caracteres")
    @NotBlank(message = "La descripcion es requerida")
    private String descripcion;

    private String liderProyecto;

    private String estado;


    @Override
    public String toString() {
        return "ProyectoDTO{" +
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
