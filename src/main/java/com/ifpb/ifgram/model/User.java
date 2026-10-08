package com.ifpb.ifgram.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class User {
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column (nullable = false, unique = true)
    private String email;

    public User(@Size(min=3) @NotNull String nome, @Email String email) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
