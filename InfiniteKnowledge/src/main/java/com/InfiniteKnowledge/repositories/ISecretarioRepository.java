package com.InfiniteKnowledge.repositories;

import com.InfiniteKnowledge.entities.Secretario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecretarioRepository extends JpaRepository<Secretario,Integer>{
    
    public Optional<Secretario> findByDni(String dni);
    
}
