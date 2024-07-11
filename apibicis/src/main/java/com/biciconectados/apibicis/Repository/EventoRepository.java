package com.biciconectados.apibicis.Repository;

import com.biciconectados.apibicis.Models.Evento;
import com.biciconectados.apibicis.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByCreador(Usuario creador);}