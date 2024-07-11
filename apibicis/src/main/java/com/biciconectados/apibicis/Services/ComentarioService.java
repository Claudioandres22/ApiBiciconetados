package com.biciconectados.apibicis.Services;

import com.biciconectados.apibicis.Models.Comentario;
import com.biciconectados.apibicis.Models.Publicacion;
import com.biciconectados.apibicis.Models.Usuario;
import com.biciconectados.apibicis.Repository.ComentarioRepository;
import com.biciconectados.apibicis.Repository.PublicacionRepository;
import com.biciconectados.apibicis.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Comentario crearComentario(Comentario comentario, Long publicacionId, Long usuarioId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RuntimeException("Publicacion no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        comentario.setPublicacion(publicacion);
        comentario.setUsuario(usuario);
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> obtenerTodosLosComentarios() {
        return comentarioRepository.findAll();
    }

    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}