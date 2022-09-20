package com.app.demo.service.impl;

import java.util.List;
//import java.util.Optional;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.model.Usuario;
import com.app.demo.repository.UsuarioRepository;
import com.app.demo.service.UsuarioService;


@Service
public class UsuarioServiceImpl  implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        super();
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario saveUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }
    @Override
    public List<Usuario> getAllUsuarios() {
        
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario getUsuarioById(long id) {
        /* 
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            throw new ResourceNotFoundException("Usuario", "Id", id);
        }
     */
    return usuarioRepository.findById(id).orElseThrow(()-> 
                        new ResourceNotFoundException("Usuario", "id", id));
    }
    @Override
    public Usuario updateUsuario(Usuario usuario, long id) {
        Usuario usuarioExis= usuarioRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Usuario", "id", id));
        usuarioExis.setNombre(usuario.getNombre());
        usuarioExis.setAdmin(usuario.getAdmin());
        usuarioExis.setCorreo(usuario.getCorreo());
        usuarioRepository.save(usuarioExis);

        
        return usuarioExis;
    }
    @Override
    public void deleteUsario (long id) {
        //Busca si existe
        usuarioRepository.findById(id).orElseThrow(()-> 
                        new ResourceNotFoundException("Usuario", "id", id));

        usuarioRepository.deleteById(id);
        
    }
    
}
