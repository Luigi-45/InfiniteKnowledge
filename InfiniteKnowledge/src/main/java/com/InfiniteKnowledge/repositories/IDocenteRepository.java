package com.InfiniteKnowledge.repositories;

import com.InfiniteKnowledge.entities.Docente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepository extends JpaRepository<Docente,Integer>{
    
    public Optional<Docente> findByDni(String dni);
    
}
