package com.InfiniteKnowledge.Cursos.domain.gradoSeccion;

import com.InfiniteKnowledge.Cursos.entities.GradoSeccion;
import java.util.List;

public interface IGradoSeccionBOCRUD {
    public GradoSeccion save(GradoSeccion gradoSeccion);
    public List<GradoSeccion> findAll();
    public GradoSeccion findById(int gradoSeccionId);
    public void deleteById(int gradoSeccionId);
}
