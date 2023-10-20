package com.InfiniteKnowledge.repositories;

import com.InfiniteKnowledge.entities.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
    
    public Optional<Usuario> findByDni(String dni);
    public Usuario findByCorreoElectronico(String correoElectronico);
    
}
