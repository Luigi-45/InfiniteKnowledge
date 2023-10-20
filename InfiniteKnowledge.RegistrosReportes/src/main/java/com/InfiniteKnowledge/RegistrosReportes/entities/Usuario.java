package com.InfiniteKnowledge.RegistrosReportes.entities;

import lombok.Data;

@Data
public class Usuario {
    
    private int usuarioId;
    private String dni;
    private String correoElectronico;
    private String contrasenia;
    private int rol;
    
}
