package com.biciconectados.apibicis.Controllers;

import com.biciconectados.apibicis.Models.Evento;
import com.biciconectados.apibicis.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin("*")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public Evento crearEvento(@RequestBody Evento evento, @RequestParam Long organizadorId) {
        return eventoService.crearEvento(evento, organizadorId);
    }

    @GetMapping("/{id}")
    public Optional<Evento> obtenerEventoPorId(@PathVariable Long id) {
        return eventoService.obtenerEventoPorId(id);
    }

    @GetMapping("/lista")
    public List<Evento> obtenerTodosLosEventos() {
        return eventoService.obtenerTodosLosEventos();
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Long id) {
        eventoService.eliminarEvento(id);
    }

    @PostMapping("/{id}/participantes/{usuarioId}")
    public Evento agregarParticipante(@PathVariable Long id, @PathVariable Long usuarioId) {
        return eventoService.agregarParticipante(id, usuarioId);
    }

    @DeleteMapping("/{id}/participantes/{usuarioId}")
    public Evento quitarParticipante(@PathVariable Long id, @PathVariable Long usuarioId) {
        return eventoService.quitarParticipante(id, usuarioId);
    }
}
