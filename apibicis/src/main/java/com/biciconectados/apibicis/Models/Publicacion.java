package com.biciconectados.apibicis.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String contenido;


    @ManyToMany
    @JoinTable(
            name = "publicacion_likes",
            joinColumns = @JoinColumn(name = "publicacion_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )

    private Set<Usuario> likes = new HashSet<>();


    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comentario> comentarios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}