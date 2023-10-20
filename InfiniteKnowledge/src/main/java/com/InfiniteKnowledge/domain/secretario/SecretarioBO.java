package com.InfiniteKnowledge.domain.secretario;

import com.InfiniteKnowledge.entities.Secretario;
import com.InfiniteKnowledge.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.InfiniteKnowledge.repositories.ISecretarioRepository;

@Component
public class SecretarioBO implements ISecretarioBOCRUD{

    @Autowired
    private ISecretarioRepository secretarioRepository;
    
    @Override
    public Secretario save(Secretario secretario) {
        return secretarioRepository.save(secretario);
    }

    @Override
    public List<Secretario> findAll() {
        return secretarioRepository.findAll();
    }

    @Override
    public Secretario findById(int secretarioId) {
        return secretarioRepository.findById(secretarioId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el secretario con el id: "+secretarioId));
    }

    @Override
    public void deleteById(int secretarioId) {
        secretarioRepository.deleteById(secretarioId);
    }

    @Override
    public Secretario findByDni(String dni) {
        return secretarioRepository.findByDni(dni)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el secretario con el dni: "+dni));
    }
    
}
