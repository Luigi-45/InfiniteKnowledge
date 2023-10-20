package com.InfiniteKnowledge.entities;
        
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "secretario")
public class Secretario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int secretarioId;
    
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String numTelefonico;
    private int aniosLabor;
}
