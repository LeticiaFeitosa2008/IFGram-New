package com.ifpb.ifgram.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "tb_follow",
        uniqueConstraints = @UniqueConstraint(name = "uk_follow_seguidor_seguido", columnNames = {"seguidor_id", "seguido_id"})
)
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seguidor_id")
    private User seguidor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seguido_id")
    private User seguido;

    public Follow() {
    }
    public Follow(User seguidor, User seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {return id;
    }
    public LocalDateTime getCriadoEm() {return criadoEm;
    }
    public User getSeguidor() {return seguidor;
    }
    public User getSeguido() {return seguido;
    }
}