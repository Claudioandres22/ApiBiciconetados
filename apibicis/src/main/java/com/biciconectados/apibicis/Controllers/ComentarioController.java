package com.biciconectados.apibicis.Controllers;

import com.biciconectados.apibicis.Models.Comentario;
import com.biciconectados.apibicis.Services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin("*")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario, @RequestParam Long publicacionId, @RequestParam Long usuarioId) {
        return comentarioService.crearComentario(comentario, publicacionId, usuarioId);
    }

    @GetMapping("/{id}")
    public Optional<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        return comentarioService.obtenerComentarioPorId(id);
    }

    @GetMapping
    public List<Comentario> obtenerTodosLosComentarios() {
        return comentarioService.obtenerTodosLosComentarios();
    }

    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
    }
}