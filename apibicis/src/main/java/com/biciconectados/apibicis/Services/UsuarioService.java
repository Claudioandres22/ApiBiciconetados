package com.biciconectados.apibicis.Services;

import com.biciconectados.apibicis.Models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario newUser);

    List<Usuario> buscarUsuarios();
}