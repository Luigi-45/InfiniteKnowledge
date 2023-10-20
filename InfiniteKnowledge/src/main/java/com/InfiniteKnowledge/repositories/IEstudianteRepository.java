package com.InfiniteKnowledge.repositories;

import com.InfiniteKnowledge.entities.Estudiante;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante,Integer>{
    
    @Query("SELECT e FROM Estudiante e WHERE CONCAT(e.apellido,' ',e.nombre) LIKE %:nombre%")
    public List<Estudiante> findByFullName(@Param("nombre") String nombre);
    
    public Optional<Estudiante> findByDni(String dni);
}
