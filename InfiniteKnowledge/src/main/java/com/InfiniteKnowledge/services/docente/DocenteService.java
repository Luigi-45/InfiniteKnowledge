package com.InfiniteKnowledge.services.docente;

import com.InfiniteKnowledge.domain.docente.IDocenteBOCRUD;
import com.InfiniteKnowledge.entities.Docente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteService implements IDocenteServiceCRUD{

    @Autowired
    private IDocenteBOCRUD docenteBO;
    
    @Override
    public Docente save(Docente docente) {
        return docenteBO.save(docente);
    }

    @Override
    public List<Docente> findAll() {
        return docenteBO.findAll();
    }

    @Override
    public Docente findById(int docenteId) {
        return docenteBO.findById(docenteId);
    }

    @Override
    public void deleteById(int docenteId) {
        docenteBO.deleteById(docenteId);
    }

    @Override
    public Docente findByDni(String dni) {
        return docenteBO.findByDni(dni);
    }

 

    
    
}
