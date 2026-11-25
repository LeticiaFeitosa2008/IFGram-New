package com.ifpb.ifgram.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "tb_like",
        uniqueConstraints = @UniqueConstraint(name = "uk_like_post_user", columnNames = {"post_id", "user_id"})
)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User autor;

    public Like() {
    }
    public Like(Post post, User autor) {
        this.post = post;
        this.autor = autor;
        this.criadoEm = LocalDateTime.now();
    }
    public Long getId() {return id;}
    public LocalDateTime getCriadoEm() {return criadoEm;}
    public Post getPost() {return post;}
    public User getAutor() {return autor;}
}