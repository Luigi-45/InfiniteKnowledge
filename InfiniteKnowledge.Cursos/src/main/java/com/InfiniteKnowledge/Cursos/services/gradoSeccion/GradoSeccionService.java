package com.InfiniteKnowledge.Cursos.services.gradoSeccion;

import com.InfiniteKnowledge.Cursos.domain.gradoSeccion.IGradoSeccionBOCRUD;
import com.InfiniteKnowledge.Cursos.entities.GradoSeccion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoSeccionService implements IGradoSeccionServiceCRUD{

    @Autowired
    private IGradoSeccionBOCRUD gradoSeccionBO;
    
    @Override
    public GradoSeccion save(GradoSeccion gradoSeccion) {
        return gradoSeccionBO.save(gradoSeccion);
    }

    @Override
    public List<GradoSeccion> findAll() {
        return gradoSeccionBO.findAll();
    }

    @Override
    public GradoSeccion findById(int gradoSeccionId) {
        return gradoSeccionBO.findById(gradoSeccionId);
    }

    @Override
    public void deleteById(int gradoSeccionId) {
        gradoSeccionBO.deleteById(gradoSeccionId);
    }
    
}
