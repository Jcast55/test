package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Usuario;

public interface UsuarioService {
    Usuario saveUsuario (Usuario user);
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(long id);
    Usuario updateUsuario(Usuario usuario, long id);
    void deleteUsario(long id);
}
