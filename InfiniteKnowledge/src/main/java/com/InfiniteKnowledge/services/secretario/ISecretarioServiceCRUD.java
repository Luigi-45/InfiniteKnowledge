package com.InfiniteKnowledge.services.secretario;

import com.InfiniteKnowledge.entities.Secretario;
import java.util.List;

public interface ISecretarioServiceCRUD {
    public Secretario save(Secretario secretario);
    public List<Secretario> findAll();
    public Secretario findById(int secretarioId);
    public Secretario findByDni(String dni);
    public void deleteById(int secretarioId);
}
