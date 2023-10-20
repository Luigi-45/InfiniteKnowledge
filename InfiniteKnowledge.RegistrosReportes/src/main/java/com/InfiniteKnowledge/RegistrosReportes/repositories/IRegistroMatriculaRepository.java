package com.InfiniteKnowledge.RegistrosReportes.repositories;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistroMatriculaRepository extends JpaRepository<RegistroMatricula,Integer>{
    
    @Query("SELECT rm FROM RegistroMatricula rm WHERE rm.gradoSeccionId = :gradoSeccionId")
    public List<RegistroMatricula> findAllByGradoSeccion(@Param("gradoSeccionId") int gradoSeccionId);
    
    @Query("SELECT rm FROM RegistroMatricula rm WHERE rm.estudianteId = :estudianteId")
    public RegistroMatricula findByEstudianteId(@Param("estudianteId") int estudianteId);
}
