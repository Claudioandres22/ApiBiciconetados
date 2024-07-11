package com.biciconectados.apibicis.Repository;

import com.biciconectados.apibicis.Models.Perfil;
import com.biciconectados.apibicis.Models.Publicacion;
import com.biciconectados.apibicis.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByUsuarioId(Long usuarioId);


}
