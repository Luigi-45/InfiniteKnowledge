package com.InfiniteKnowledge.domain.estudiante;

import com.InfiniteKnowledge.entities.Estudiante;
import com.InfiniteKnowledge.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.InfiniteKnowledge.repositories.IEstudianteRepository;

@Component
public class EstudianteBO implements IEstudianteBOCRUD{

    @Autowired
    private IEstudianteRepository estudianteRepository;
    
    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(int estudianteId) {
        return estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el estudiante con el id: "+estudianteId));
    }

    @Override
    public void deleteById(int estudianteId) {
        estudianteRepository.deleteById(estudianteId);
    }

    @Override
    public List<Estudiante> findByFullName(String nombre) {
        return estudianteRepository.findByFullName(nombre);
    }

    @Override
    public Estudiante findByDni(String dni) {
        return estudianteRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el estudiante con el dni: "+dni));
    }
    
}
