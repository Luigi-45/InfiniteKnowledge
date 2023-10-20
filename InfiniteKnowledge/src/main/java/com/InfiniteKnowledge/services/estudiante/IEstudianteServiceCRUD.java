package com.InfiniteKnowledge.services.estudiante;

import com.InfiniteKnowledge.entities.Estudiante;
import java.util.List;

public interface IEstudianteServiceCRUD {
    public Estudiante save(Estudiante estudiante);
    public List<Estudiante> findAll();
    public Estudiante findByDni(String dni);
    public List<Estudiante> findByFullName(String nombre);
    public Estudiante findById(int estudianteId);
    public void deleteById(int estudianteId);
}
