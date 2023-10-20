package com.InfiniteKnowledge.Cursos.domain.gradoSeccion;

import com.InfiniteKnowledge.Cursos.entities.GradoSeccion;
import com.InfiniteKnowledge.Cursos.repositories.IGradoSeccionRepository;
import com.InfiniteKnowledge.Cursos.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GradoSeccionBO implements IGradoSeccionBOCRUD{

    @Autowired
    private IGradoSeccionRepository gradoSeccionRepository;
    
    @Override
    public GradoSeccion save(GradoSeccion gradoSeccion) {
        return gradoSeccionRepository.save(gradoSeccion);
    }

    @Override
    public List<GradoSeccion> findAll() {
        return gradoSeccionRepository.findAll();
    }

    @Override
    public GradoSeccion findById(int gradoSeccionId) {
        return gradoSeccionRepository.findById(gradoSeccionId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el grado y sección con el id: "+gradoSeccionId));
    }

    @Override
    public void deleteById(int gradoSeccionId) {
        gradoSeccionRepository.deleteById(gradoSeccionId);
    }
    
}