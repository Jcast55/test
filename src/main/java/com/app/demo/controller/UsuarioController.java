package com.app.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.Usuario;
import com.app.demo.service.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService user) {
        super();
        this.usuarioService = user;
    }


    // Iniica la rest api
    @PostMapping()
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<Usuario>(usuarioService.saveUsuario(usuario), HttpStatus.CREATED);

    }
    //all usuarios
    @GetMapping()
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuarios();

    }

    //Usario por id
    @GetMapping("{id}")

    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") long usuarioId){
    return new ResponseEntity<Usuario>(usuarioService.getUsuarioById(usuarioId), HttpStatus.OK);
    }
    //Actualizar
    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsario(@PathVariable("id") long id, @RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioService.updateUsuario(usuario, id), HttpStatus.OK);
    }

        //Eliminar
    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteUsario(@PathVariable("id") long id){
        usuarioService.deleteUsario(id);
        return new ResponseEntity<String>("Eliminado con exito", HttpStatus.OK);

    }
}
