package com.biciconectados.apibicis.Services;

import com.biciconectados.apibicis.Models.Evento;
import com.biciconectados.apibicis.Models.Usuario;
import com.biciconectados.apibicis.Repository.EventoRepository;
import com.biciconectados.apibicis.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Evento crearEvento(Evento evento, Long organizadorId) {
        Usuario creador = usuarioRepository.findById(organizadorId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        evento.setCreador(creador);
        return eventoRepository.save(evento);
    }

    public Optional<Evento> obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }

    public void eliminarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public Evento agregarParticipante(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        evento.getParticipantes().add(usuario);
        return eventoRepository.save(evento);
    }

    public Evento quitarParticipante(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        evento.getParticipantes().remove(usuario);
        return eventoRepository.save(evento);
    }
}