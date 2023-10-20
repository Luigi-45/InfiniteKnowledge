package com.InfiniteKnowledge.Cursos.repositories;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso,Integer>{
    
}
