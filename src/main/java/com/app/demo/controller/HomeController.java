package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.app.demo.model.Usuario;
import com.app.demo.service.UsuarioService;

@Controller
@RequestMapping("/")
public class HomeController {
    UsuarioService usuarioService;
    public UsuarioService getJdbcUserDAO() {
        return usuarioService;
    }

    @Autowired
    public void setJdbcUserDAO(UsuarioService jdbcUserDAO) {
        this.usuarioService = jdbcUserDAO;
    }
    @GetMapping()
    public ResponseEntity<String> home(){
        List<Usuario> usarios= usuarioService.getAllUsuarios();
        String present = "Hola mundo\n";
        for (Usuario usuario : usarios) {
            present = usuario.toString() + "\n";
        }
        return new ResponseEntity<String>(present, HttpStatus.OK);
}


}
