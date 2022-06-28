package com.sofka.gestionRiesgo.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "usuario")
public class Usuario {

    @Transient
    public static final String SEQUENCE_USUARIO = "user_sequence";
    @Id
    private Integer id;
    private String nombre;
    private String email;
    private List<String> roles;


    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String email, List<String> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.roles = roles;

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}