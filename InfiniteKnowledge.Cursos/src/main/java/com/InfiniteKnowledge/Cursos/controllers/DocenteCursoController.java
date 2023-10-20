package com.InfiniteKnowledge.Cursos.controllers;

import com.InfiniteKnowledge.Cursos.entities.DocenteCurso;
import com.InfiniteKnowledge.Cursos.services.docenteCurso.IDocenteCursoServiceCRUD;
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
@RequestMapping("/api/docenteCurso")
@CrossOrigin(origins = "*")
public class DocenteCursoController {
    
    @Autowired
    private IDocenteCursoServiceCRUD docenteCursoService;
    
    @GetMapping
    public List<DocenteCurso> findAll(){
        return (ArrayList<DocenteCurso>) docenteCursoService.findAll();
    }
    
    @GetMapping("/findById")
    public ResponseEntity<DocenteCurso> findById(@RequestParam(name="docenteCursoId",defaultValue="0") int docenteCursoId){
        DocenteCurso docenteCurso = docenteCursoService.findById(docenteCursoId);
        return ResponseEntity.ok(docenteCurso);
    }
    
    @GetMapping("/findNames")
    public List<Object[]> findNames(){
        List<Object[]> listaNombres = docenteCursoService.findNames();
        return (ArrayList<Object[]>) listaNombres;
    }
    
    @GetMapping("/findByDocenteCurso")
    public ResponseEntity<DocenteCurso> findByDocenteIdAndCursoId(@RequestParam(name="docenteId",defaultValue="0") int docenteId, 
            @RequestParam(name="cursoId",defaultValue="0") int cursoId){
        DocenteCurso docenteCurso = docenteCursoService.findByDocenteIdAndCursoId(docenteId,cursoId);
        return ResponseEntity.ok(docenteCurso);
    }
    
    @PostMapping("/guardar")
    public DocenteCurso save(@RequestBody DocenteCurso docenteCurso){
        return docenteCursoService.save(docenteCurso);
    }
    
    @PutMapping("/actualizar")
    public DocenteCurso update(@RequestBody DocenteCurso docenteCurso){
        return docenteCursoService.save(docenteCurso);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="docenteCursoId",defaultValue="0") int docenteCursoId){
        docenteCursoService.deleteById(docenteCursoId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
