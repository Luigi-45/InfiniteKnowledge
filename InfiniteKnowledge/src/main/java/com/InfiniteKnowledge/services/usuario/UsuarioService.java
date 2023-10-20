package com.InfiniteKnowledge.services.usuario;

import com.InfiniteKnowledge.domain.usuario.IUsuarioBOCRUD;
import com.InfiniteKnowledge.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioServiceCRUD{
    
    @Autowired
    private IUsuarioBOCRUD usuarioBO;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioBO.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioBO.findAll();
    }

    @Override
    public Usuario findById(int usuarioId) {
        return usuarioBO.findById(usuarioId);
    }

    @Override
    public void deleteById(int usuarioId) {
        usuarioBO.deleteById(usuarioId);
    }

    @Override
    public Usuario findByDni(String dni) {
        return usuarioBO.findByDni(dni);
    }

    @Override
    public Usuario findByCorreoElectronico(String correoElectronico) {
        return usuarioBO.findByCorreoElectronico(correoElectronico);
    }
    
}
