package com.biciconectados.apibicis.Models;

import jakarta.persistence.*;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public void setPublicacion(Publicacion publicacion) {
    }

    public void setUsuario(Usuario usuario) {

    }
}