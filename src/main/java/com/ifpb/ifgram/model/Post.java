package com.ifpb.ifgram.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

@Table(name="tb_post")

public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagemURL;

    @Column(length = 300)
    private String legenda;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private User autor;

    public Post(){

    }

    public Post(String imagemURL, String legenda, User autor){

        this.imagemURL=imagemURL;
        this.legenda=legenda;
        this.autor=autor;
    }

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
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
}
