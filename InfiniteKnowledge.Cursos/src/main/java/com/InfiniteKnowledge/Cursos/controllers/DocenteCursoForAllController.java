package com.InfiniteKnowledge.Cursos.controllers;

import com.InfiniteKnowledge.Cursos.services.docenteCurso.IDocenteCursoServiceCRUD;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docenteCursoForAll")
@CrossOrigin(origins = "*")
public class DocenteCursoForAllController {
        
    private final IDocenteCursoServiceCRUD docenteCursoService;

    public DocenteCursoForAllController(IDocenteCursoServiceCRUD docenteCursoService) {
        this.docenteCursoService = docenteCursoService;
    }
    
    @GetMapping("/findNames")
    public List<Object[]> findNames(){
        List<Object[]> listaNombres = docenteCursoService.findNames();
        return (ArrayList<Object[]>) listaNombres;
    }
}
