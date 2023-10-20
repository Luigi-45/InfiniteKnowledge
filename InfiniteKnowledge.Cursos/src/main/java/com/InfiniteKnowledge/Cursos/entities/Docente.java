package com.InfiniteKnowledge.Cursos.entities;

import lombok.Data;

@Data
public class Docente {

    private int docenteId;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String numTelefonico;
    private String especialidad;
    
}
