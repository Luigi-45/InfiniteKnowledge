package com.InfiniteKnowledge.Cursos.repositories;

import com.InfiniteKnowledge.Cursos.entities.GradoSeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradoSeccionRepository extends JpaRepository<GradoSeccion,Integer>{
    
}
