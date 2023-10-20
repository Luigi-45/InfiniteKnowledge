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
@Table(name = "registro_calificacion")
public class RegistroCalificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registroCalificacionId;
    
    private int estudianteId;
    private int docenteCursoId;
    private int calificacion1;
    private int calificacion2;
    private int calificacion3;
    private int calificacion4;
    private int bimestre;
}
