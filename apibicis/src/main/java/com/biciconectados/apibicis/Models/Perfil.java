package com.biciconectados.apibicis.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "perfil", uniqueConstraints = @UniqueConstraint(columnNames = "usuario_id"))
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kilometrosRecorridos;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}