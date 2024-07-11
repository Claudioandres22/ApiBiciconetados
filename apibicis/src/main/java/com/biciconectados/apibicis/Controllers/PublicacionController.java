package com.biciconectados.apibicis.Controllers;

import com.biciconectados.apibicis.Models.Publicacion;
import com.biciconectados.apibicis.Services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publicaciones")
@CrossOrigin("*")
public class PublicacionController {
    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion, @RequestParam Long usuarioId) {
        return publicacionService.crearPublicacion(publicacion, usuarioId);
    }

    @GetMapping("/{id}")
    public Optional<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        return publicacionService.obtenerPublicacionPorId(id);
    }

    @GetMapping("/lista")
    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionService.obtenerTodasLasPublicaciones();
    }

    @DeleteMapping("/{id}")
    public void eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
    }

    @PostMapping("/{id}/like")
    public Publicacion darLike(@PathVariable Long id, @RequestParam Long usuarioId) {
        return publicacionService.darLike(id, usuarioId);
    }

    @PostMapping("/{id}/unlike")
    public Publicacion quitarLike(@PathVariable Long id, @RequestParam Long usuarioId) {
        return publicacionService.quitarLike(id, usuarioId);
    }
}