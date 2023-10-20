package com.InfiniteKnowledge.controllers;

import com.InfiniteKnowledge.entities.Docente;
import com.InfiniteKnowledge.services.docente.IDocenteServiceCRUD;
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
@RequestMapping("/api/docente")
@CrossOrigin(origins = "*")
public class DocenteController {
    
    @Autowired 
    private IDocenteServiceCRUD docenteService;
    
    @GetMapping
    public List<Docente> findAll(){
        return (ArrayList<Docente>) docenteService.findAll();
    }
    
  
    @GetMapping("/findById/{id}")
    public ResponseEntity<Docente> findById(@PathVariable int id){
        Docente docente = docenteService.findById(id);
        return ResponseEntity.ok(docente);
    }
     
    
    @GetMapping("/findByDni")
    public ResponseEntity<Docente> findByDni(@RequestParam(name="dni",defaultValue="0") String dni){
        Docente docente = docenteService.findByDni(dni);
        return ResponseEntity.ok(docente);
    }
    @RequestMapping(method=RequestMethod.POST)
    @PostMapping("/guardar")
    public Docente save(@RequestBody Docente docente){
        return docenteService.save(docente);
    }
    
   
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Docente> update( @PathVariable int id,@RequestBody Docente docenterequest){
         Docente docente = docenteService.findById(id);
         docente.setDni(docenterequest.getDni());
         docente.setNombre(docenterequest.getNombre());
         docente.setApellido(docenterequest.getApellido());
         docente.setNombre(docenterequest.getNombre());
         docente.setEdad(docenterequest.getEdad());
         docente.setGenero(docenterequest.getGenero());
         docente.setNumTelefonico(docenterequest.getNumTelefonico());
         docente.setEspecialidad(docenterequest.getEspecialidad());
         
         Docente actualizado=docenteService.save(docente);
        return ResponseEntity.ok(actualizado);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id){
        docenteService.deleteById(id);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
