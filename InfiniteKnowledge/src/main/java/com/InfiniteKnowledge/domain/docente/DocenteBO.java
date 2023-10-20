package com.InfiniteKnowledge.domain.docente;

import com.InfiniteKnowledge.entities.Docente;
import com.InfiniteKnowledge.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.InfiniteKnowledge.repositories.IDocenteRepository;

@Component
public class DocenteBO implements IDocenteBOCRUD{
    
    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente findById(int docenteId) {
        return docenteRepository.findById(docenteId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el docente con el id: "+docenteId));
    }

    @Override
    public void deleteById(int docenteId) {
        docenteRepository.deleteById(docenteId);
    }

    @Override
    public Docente findByDni(String dni) {
        return docenteRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el docente con el dni: "+dni));
    }

    
    
}
