package com.InfiniteKnowledge.Cursos.controllers;

import com.InfiniteKnowledge.Cursos.entities.Curso;
import com.InfiniteKnowledge.Cursos.services.curso.ICursoServiceCRUD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private ICursoServiceCRUD cursoService;
    
    @GetMapping
    public List<Curso> findAll(){
        return (ArrayList<Curso>) cursoService.findAll();
    }
    
    @GetMapping("/findById")
    public ResponseEntity<Curso> findById(@RequestParam(name="cursoId",defaultValue="0") int cursoId){
        Curso curso = cursoService.findById(cursoId);
        return ResponseEntity.ok(curso);
    }
    
    @PostMapping("/guardar")
    public Curso save(@RequestBody Curso curso){
        return cursoService.save(curso);
    }
    
    @PutMapping("/actualizar")
    public Curso update(@RequestBody Curso curso){
        return cursoService.save(curso);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="cursoId",defaultValue="0") int cursoId){
        cursoService.deleteById(cursoId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
