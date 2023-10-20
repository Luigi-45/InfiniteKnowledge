package com.InfiniteKnowledge.Cursos.domain.docenteCurso;

import com.InfiniteKnowledge.Cursos.entities.DocenteCurso;
import java.util.List;

public interface IDocenteCursoBOCRUD {
    public DocenteCurso save(DocenteCurso docenteCurso);
    public List<DocenteCurso> findAll();
    public List<Object[]> findNames();
    public DocenteCurso findById(int docenteCursoId);
    public void deleteById(int docenteCursoId);
    public DocenteCurso findByDocenteIdAndCursoId(int docenteId, int cursoId);
}
