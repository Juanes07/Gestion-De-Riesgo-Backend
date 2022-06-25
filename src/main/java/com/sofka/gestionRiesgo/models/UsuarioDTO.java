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

    @NotBlank(message = "Debe existir el Id para este objeto")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;
    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La listaRoles es requerido")
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
