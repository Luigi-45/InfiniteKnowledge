package com.InfiniteKnowledge.Cursos.controllers;

import com.InfiniteKnowledge.Cursos.entities.GradoSeccion;
import com.InfiniteKnowledge.Cursos.services.gradoSeccion.IGradoSeccionServiceCRUD;
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
@RequestMapping("/api/gradoSeccion")
@CrossOrigin(origins = "*")
public class GradoSeccionController {
    @Autowired
    private IGradoSeccionServiceCRUD gradoSeccionService;
    
    @GetMapping
    public List<GradoSeccion> findAll(){
        return (ArrayList<GradoSeccion>) gradoSeccionService.findAll();
    }
    
    @GetMapping("/findById")
    public ResponseEntity<GradoSeccion> findById(@RequestParam(name="gradoSeccionId",defaultValue="0") int gradoSeccionId){
        GradoSeccion gradoSeccion = gradoSeccionService.findById(gradoSeccionId);
        return ResponseEntity.ok(gradoSeccion);
    }
    
    @PostMapping("/guardar")
    public GradoSeccion save(@RequestBody GradoSeccion gradoSeccion){
        return gradoSeccionService.save(gradoSeccion);
    }
    
    @PutMapping("/actualizar")
    public GradoSeccion update(@RequestBody GradoSeccion gradoSeccion){
        return gradoSeccionService.save(gradoSeccion);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="gradoSeccionId",defaultValue="0") int gradoSeccionId){
        gradoSeccionService.deleteById(gradoSeccionId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
}
