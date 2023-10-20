package com.InfiniteKnowledge.Cursos.domain.curso;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import com.InfiniteKnowledge.Cursos.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.InfiniteKnowledge.Cursos.repositories.ICursoRepository;

@Component
public class CursoBO implements ICursoBOCRUD{
    
    @Autowired
    private ICursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(int cursoId) {
        return cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el curso con el id: "+cursoId));
    }

    @Override
    public void deleteById(int cursoId) {
        cursoRepository.deleteById(cursoId);
    }
    
}
