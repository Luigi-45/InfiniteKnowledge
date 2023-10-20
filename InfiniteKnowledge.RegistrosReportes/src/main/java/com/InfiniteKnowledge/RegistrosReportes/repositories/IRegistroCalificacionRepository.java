package com.InfiniteKnowledge.RegistrosReportes.repositories;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistroCalificacionRepository extends JpaRepository<RegistroCalificacion,Integer>{
    
    @Query("SELECT rc FROM RegistroCalificacion rc WHERE rc.docenteCursoId = :docenteCursoId AND rc.bimestre = :bimestre")
    public List<RegistroCalificacion> findAllByGradoSeccion(@Param("docenteCursoId") int docenteCursoId, @Param("bimestre") int bimestre);
    
    @Query("SELECT DISTINCT rc.docenteCursoId FROM RegistroCalificacion rc WHERE rc.estudianteId = :estudianteId")
    public List<Integer> findDocenteCursoIdByEstudianteId(@Param("estudianteId") int estudianteId);
    
    @Query("SELECT rc FROM RegistroCalificacion rc WHERE rc.docenteCursoId = :docenteCursoId AND rc.estudianteId = :estudianteId")
    public List<RegistroCalificacion> findAllByDcoenteCursoAndEstudiante(@Param("docenteCursoId") int docenteCursoId, @Param("estudianteId") int estudianteId);
    
}
