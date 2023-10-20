package com.InfiniteKnowledge.controllers;

import com.InfiniteKnowledge.entities.Estudiante;
import com.InfiniteKnowledge.services.estudiante.IEstudianteServiceCRUD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin(origins = "*")
public class EstudianteController {
    
    @Autowired
    private IEstudianteServiceCRUD estudianteService;
    
    @GetMapping
    public List<Estudiante> findAll(){
        return (ArrayList<Estudiante>) estudianteService.findAll();
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Estudiante> findById(@PathVariable int id){
        Estudiante estudiante = estudianteService.findById(id);
        return ResponseEntity.ok(estudiante);
    }
    
    @GetMapping("/findByDni")
    public ResponseEntity<Estudiante> findByDni(@RequestParam(name="dni",defaultValue="0") String dni){
        Estudiante estudiante = estudianteService.findByDni(dni);
        return ResponseEntity.ok(estudiante);
    }
    
    @GetMapping("/findByFullName")
    public ResponseEntity<List<Estudiante>> findById(@RequestParam(name="nombre",defaultValue="0") String nombre){
        List<Estudiante> listaEstudiantes = estudianteService.findByFullName(nombre);
        return ResponseEntity.ok(listaEstudiantes);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    @PostMapping("/guardar")
    public Estudiante save(@RequestBody Estudiante estudiante){
        return estudianteService.save(estudiante);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante> update(@PathVariable int id,@RequestBody Estudiante estudianterequest){
        Estudiante estudiante = estudianteService.findById(id);
         estudiante.setDni(estudianterequest.getDni());
         estudiante.setNombre(estudianterequest.getNombre());
         estudiante.setApellido(estudianterequest.getApellido());
         estudiante.setNombre(estudianterequest.getNombre());
         estudiante.setEdad(estudianterequest.getEdad());
         estudiante.setGenero(estudianterequest.getGenero());
         estudiante.setNumTelefonico(estudianterequest.getNumTelefonico());
         
         Estudiante actualizado=estudianteService.save(estudiante);
        return ResponseEntity.ok(actualizado);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id){
        estudianteService.deleteById(id);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
}
