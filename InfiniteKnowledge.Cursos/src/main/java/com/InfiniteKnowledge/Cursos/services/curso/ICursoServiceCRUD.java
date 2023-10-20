package com.InfiniteKnowledge.Cursos.services.curso;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import java.util.List;

public interface ICursoServiceCRUD {
    public Curso save(Curso curso);
    public List<Curso> findAll();
    public Curso findById(int cursoId);
    public void deleteById(int cursoId);
}
