package com.sofka.gestionRiesgo.models;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class UsuarioDTO {

    @NotBlank(message = "Debe existir el Id para este objeto")
    private Integer id;

    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La listaRoles es requerido")
    private List<String> roles;

    @NotBlank(message = "La listaProyectosId es requerido")
    private List<Integer> proyectosId;


public UsuarioDTO(Integer id, String email, List<String> roles, List<Integer> proyectosId) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.proyectosId = proyectosId;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", proyectosId=" + proyectosId +
                '}';
    }
}
