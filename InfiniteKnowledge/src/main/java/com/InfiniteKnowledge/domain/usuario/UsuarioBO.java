package com.InfiniteKnowledge.domain.usuario;

import com.InfiniteKnowledge.entities.Usuario;
import com.InfiniteKnowledge.repositories.IUsuarioRepository;
import com.InfiniteKnowledge.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBO implements IUsuarioBOCRUD{

    @Autowired
    private IUsuarioRepository usuarioRepository;
    
    
    
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    @Override
    public Usuario findById(int usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el id: "+usuarioId));
    }

    @Override
    public Usuario findByDni(String dni) {
        return usuarioRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el dni: "+dni));
    }

    @Override
    public void deleteById(int usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public Usuario findByCorreoElectronico(String correoElectronico) {
        return usuarioRepository.findByCorreoElectronico(correoElectronico);
    }
}
