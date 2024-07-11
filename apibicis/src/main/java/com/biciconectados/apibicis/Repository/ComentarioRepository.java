package com.biciconectados.apibicis.Repository;

import com.biciconectados.apibicis.Models.Comentario;
import com.biciconectados.apibicis.Models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByPublicacion(Publicacion publicacion);

}

