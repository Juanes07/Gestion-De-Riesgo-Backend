package com.sofka.gestionRiesgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotBlank(message = "El email es requerido")
    private String email;

    private List<String> roles;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
