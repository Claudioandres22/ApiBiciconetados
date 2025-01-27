package com.biciconectados.apibicis.Repository;

import com.biciconectados.apibicis.Models.ERol;
import com.biciconectados.apibicis.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERol nombre);
}

