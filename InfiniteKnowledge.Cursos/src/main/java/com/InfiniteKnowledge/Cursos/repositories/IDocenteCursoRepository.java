package com.InfiniteKnowledge.Cursos.repositories;

import com.InfiniteKnowledge.Cursos.entities.DocenteCurso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteCursoRepository extends JpaRepository<DocenteCurso,Integer>{
    
    @Query("SELECT d FROM DocenteCurso d WHERE d.docenteId = :docenteId AND d.cursoId = :cursoId")
    public Optional<DocenteCurso> findByDocenteIdAndCursoId(@Param("docenteId") int docenteId, @Param("cursoId") int cursoId);
    
}
