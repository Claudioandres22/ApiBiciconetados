package com.biciconectados.apibicis.Security;

import com.biciconectados.apibicis.Models.ERol;
import com.biciconectados.apibicis.Models.Rol;
import com.biciconectados.apibicis.Repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public Optional<Rol> buscarRolPorNombre(ERol nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
