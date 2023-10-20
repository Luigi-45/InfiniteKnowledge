package com.InfiniteKnowledge.Cursos.domain.curso;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import java.util.List;

public interface ICursoBOCRUD {
    public Curso save(Curso curso);
    public List<Curso> findAll();
    public Curso findById(int cursoId);
    public void deleteById(int cursoId);
}
