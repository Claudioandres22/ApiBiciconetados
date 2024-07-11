package com.biciconectados.apibicis.Services;

import com.biciconectados.apibicis.Models.Perfil;
import com.biciconectados.apibicis.Models.Usuario;
import com.biciconectados.apibicis.Repository.PerfilRepository;
import com.biciconectados.apibicis.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Perfil crearPerfil(Perfil perfil) {
        Optional<Perfil> existingPerfil = perfilRepository.findByUsuarioId(perfil.getUsuario().getId());
        if (existingPerfil.isPresent()) {
            throw new DataIntegrityViolationException("Perfil ya existe para este usuario.");
        }
        return perfilRepository.save(perfil);
    }

    public Optional<Perfil> obtenerPerfilPorId(Long id) {
        return perfilRepository.findById(id);
    }

    public List<Perfil> obtenerTodosLosPerfiles() {
        return perfilRepository.findAll();
    }

    public void eliminarPerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}