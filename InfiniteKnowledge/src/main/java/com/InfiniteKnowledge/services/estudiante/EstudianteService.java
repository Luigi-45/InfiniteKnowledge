package com.InfiniteKnowledge.services.estudiante;

import com.InfiniteKnowledge.entities.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.InfiniteKnowledge.domain.estudiante.IEstudianteBOCRUD;

@Service
public class EstudianteService implements IEstudianteServiceCRUD{

    @Autowired
    private IEstudianteBOCRUD estudianteBO;
    
    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteBO.save(estudiante);
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteBO.findAll();
    }

    @Override
    public Estudiante findById(int estudianteId) {
        return estudianteBO.findById(estudianteId);
    }

    @Override
    public void deleteById(int estudianteId) {
        estudianteBO.deleteById(estudianteId);
    }

    @Override
    public List<Estudiante> findByFullName(String nombre) {
        return estudianteBO.findByFullName(nombre);
    }

    @Override
    public Estudiante findByDni(String dni) {
        return estudianteBO.findByDni(dni);
    }
    
}
