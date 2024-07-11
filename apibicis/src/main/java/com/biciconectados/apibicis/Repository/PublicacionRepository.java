package com.biciconectados.apibicis.Repository;

import com.biciconectados.apibicis.Models.Publicacion;
import com.biciconectados.apibicis.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByUsuario(Usuario usuario);

}