package com.ifpb.ifgram.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;

@Entity
@Table(name="table_coment")
public class ModelComent {

    @Id

    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 300)
    private String texto;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name="Post_id")
    private Post post;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private User autor;

    public ModelComent(){}

    public ModelComent (String texto, LocalDateTime criadoEm){

        this.texto=texto;
        this.criadoEm=criadoEm;
    }

    public ModelComent(@NotBlank(message = "O texto do comentário é obrigatório") @Size(max = 500, message = "O comentário deve ter no máximo 500 caracteres") String texto, Post post, User autor) {
    }

    public Long getId (){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
