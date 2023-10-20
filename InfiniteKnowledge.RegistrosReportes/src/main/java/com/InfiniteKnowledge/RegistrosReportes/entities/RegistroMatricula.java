package com.InfiniteKnowledge.RegistrosReportes.entities;

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
@Table(name = "registro_matricula")
public class RegistroMatricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registroMatriculaId;
    
    private int estudianteId;
    private int gradoSeccionId;
    private String nombrePaqueteCurso;
    
}
