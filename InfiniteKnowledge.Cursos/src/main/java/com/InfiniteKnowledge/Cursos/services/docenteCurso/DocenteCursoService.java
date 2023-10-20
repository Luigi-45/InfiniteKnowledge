package com.InfiniteKnowledge.Cursos.services.docenteCurso;

import com.InfiniteKnowledge.Cursos.domain.docenteCurso.IDocenteCursoBOCRUD;
import com.InfiniteKnowledge.Cursos.entities.DocenteCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteCursoService implements IDocenteCursoServiceCRUD{

    @Autowired
    private IDocenteCursoBOCRUD docenteCursoBO;
    
    @Override
    public DocenteCurso save(DocenteCurso docenteCurso) {
        return docenteCursoBO.save(docenteCurso);
    }

    @Override
    public List<DocenteCurso> findAll() {
        return docenteCursoBO.findAll();
    }

    @Override
    public DocenteCurso findById(int docenteCursoId) {
        return docenteCursoBO.findById(docenteCursoId);
    }

    @Override
    public void deleteById(int docenteCursoId) {
        docenteCursoBO.deleteById(docenteCursoId);
    }

    @Override
    public DocenteCurso findByDocenteIdAndCursoId(int docenteId, int cursoId) {
        return docenteCursoBO.findByDocenteIdAndCursoId(docenteId, cursoId);
    }

    @Override
    public List<Object[]> findNames() {
        return docenteCursoBO.findNames();
    }
    
}
