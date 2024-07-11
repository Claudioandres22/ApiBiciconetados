package com.biciconectados.apibicis.Services;

import com.biciconectados.apibicis.Models.Publicacion;
import com.biciconectados.apibicis.Models.Usuario;
import com.biciconectados.apibicis.Repository.PublicacionRepository;
import com.biciconectados.apibicis.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Publicacion crearPublicacion(Publicacion publicacion, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        publicacion.setUsuario(usuario);
        return publicacionRepository.save(publicacion);
    }

    public Optional<Publicacion> obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id);
    }

    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }

    public Publicacion darLike(Long publicacionId, Long usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        publicacion.getLikes().add(usuario);
        return publicacionRepository.save(publicacion);
    }

    public Publicacion quitarLike(Long publicacionId, Long usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        publicacion.getLikes().remove(usuario);
        return publicacionRepository.save(publicacion);
    }
}