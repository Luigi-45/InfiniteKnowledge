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
@Table(name = "docente_curso")
public class DocenteCurso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docenteCursoId;

    private int docenteId;
    private int cursoId;
}
