package com.InfiniteKnowledge.services.docente;

import com.InfiniteKnowledge.entities.Docente;
import java.util.List;

public interface IDocenteServiceCRUD {
    public Docente save(Docente docente);
    public List<Docente> findAll();
    public Docente findById(int docenteId);
    public Docente findByDni(String dni);
    public void deleteById(int docenteId);
}
