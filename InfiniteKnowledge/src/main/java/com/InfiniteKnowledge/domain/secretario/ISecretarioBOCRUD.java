package com.InfiniteKnowledge.domain.secretario;

import com.InfiniteKnowledge.entities.Secretario;
import java.util.List;

public interface ISecretarioBOCRUD {
    public Secretario save(Secretario secretario);
    public List<Secretario> findAll();
    public Secretario findById(int secretarioId);
    public Secretario findByDni(String dni);
    public void deleteById(int secretarioId);
}
