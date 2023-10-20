package com.InfiniteKnowledge.domain.usuario;

import com.InfiniteKnowledge.entities.Usuario;
import java.util.List;

public interface IUsuarioBOCRUD {
    public Usuario save(Usuario usuario);
    public List<Usuario> findAll();
    public Usuario findById(int usuarioId);
    public Usuario findByDni(String dni);
    public Usuario findByCorreoElectronico(String correoElectronico);
    public void deleteById(int usuarioId);
}
