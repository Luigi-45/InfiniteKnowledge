package com.InfiniteKnowledge.services.secretario;

import com.InfiniteKnowledge.domain.secretario.ISecretarioBOCRUD;
import com.InfiniteKnowledge.entities.Secretario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretarioService implements ISecretarioServiceCRUD{

    @Autowired
    private ISecretarioBOCRUD secretarioBO;
    
    @Override
    public Secretario save(Secretario secretario) {
        return secretarioBO.save(secretario);
    }

    @Override
    public List<Secretario> findAll() {
        return secretarioBO.findAll();
    }

    @Override
    public Secretario findById(int secretarioId) {
        return secretarioBO.findById(secretarioId);
    }

    @Override
    public void deleteById(int secretarioId) {
        secretarioBO.deleteById(secretarioId);
    }

    @Override
    public Secretario findByDni(String dni) {
        return secretarioBO.findByDni(dni);
    }
    
}
