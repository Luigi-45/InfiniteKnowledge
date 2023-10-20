package com.InfiniteKnowledge.Cursos.entities;

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
@Table(name = "grado_seccion")
public class GradoSeccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradoSeccionId;
    
    private int grado;
    private String seccion;
    
}
