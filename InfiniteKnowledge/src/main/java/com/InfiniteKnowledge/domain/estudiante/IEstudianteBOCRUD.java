package com.InfiniteKnowledge.domain.estudiante;

import com.InfiniteKnowledge.entities.Estudiante;
import java.util.List;

public interface IEstudianteBOCRUD {
    public Estudiante save(Estudiante estudiante);
    public List<Estudiante> findAll();
    public List<Estudiante> findByFullName(String nombre);
    public Estudiante findByDni(String dni);
    public Estudiante findById(int estudianteId);
    public void deleteById(int estudianteId);
}
