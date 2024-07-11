package com.biciconectados.apibicis.Controllers;

import com.biciconectados.apibicis.Exceptions.DuplicateEntryException;
import com.biciconectados.apibicis.Models.Perfil;
import com.biciconectados.apibicis.Services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin("*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public Perfil crearPerfil(@RequestBody Perfil perfil) {
        try {
            return perfilService.crearPerfil(perfil);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateEntryException("Ya existe un perfil con este usuario ID.");
        }

}
    @GetMapping("/{id}")
    public Optional<Perfil> obtenerPerfilPorId(@PathVariable Long id) {
        return perfilService.obtenerPerfilPorId(id);
    }

    @GetMapping("/lista")
    public List<Perfil> obtenerTodosLosPerfiles() {
        return perfilService.obtenerTodosLosPerfiles();
    }

    @DeleteMapping("/{id}")
    public void eliminarPerfil(@PathVariable Long id) {
        perfilService.eliminarPerfil(id);
    }
}
