package com.sofka.gestionRiesgo.collections;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Usuario {
    @Id
    private Integer id;
    private String email;
    private List<String> roles;
    private List<Integer> proyectosId;

    public Usuario() {
    }

    public Usuario(Integer id, String email, List<String> roles, List<Integer> proyectosId) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.proyectosId = proyectosId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", proyectosId=" + proyectosId +
                '}';
    }
}
