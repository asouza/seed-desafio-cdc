package com.cdc.autor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    private final LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Autor() {}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
