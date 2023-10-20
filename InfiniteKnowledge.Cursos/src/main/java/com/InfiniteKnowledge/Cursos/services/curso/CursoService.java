package com.InfiniteKnowledge.Cursos.services.curso;

import com.InfiniteKnowledge.Cursos.domain.curso.ICursoBOCRUD;
import com.InfiniteKnowledge.Cursos.entities.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoServiceCRUD{

    @Autowired
    private ICursoBOCRUD cursoBO;
    
    @Override
    public Curso save(Curso curso) {
        return cursoBO.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoBO.findAll();
    }

    @Override
    public Curso findById(int cursoId) {
        return cursoBO.findById(cursoId);
    }

    @Override
    public void deleteById(int cursoId) {
        cursoBO.deleteById(cursoId);
    }
    
}
