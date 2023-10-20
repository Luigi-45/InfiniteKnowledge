package com.InfiniteKnowledge.controllers;

import com.InfiniteKnowledge.entities.Secretario;
import com.InfiniteKnowledge.services.secretario.ISecretarioServiceCRUD;
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
@RequestMapping("/api/secretario")
@CrossOrigin(origins = "*")
public class SecretarioController {
    
    @Autowired
    private ISecretarioServiceCRUD secretarioService;
    
    @GetMapping
    public List<Secretario> findAll(){
        return (ArrayList<Secretario>) secretarioService.findAll();
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Secretario> findById(@PathVariable int id){
        Secretario secretario = secretarioService.findById(id);
        return ResponseEntity.ok(secretario);
    }
    
    @GetMapping("/findByDni")
    public ResponseEntity<Secretario> findByDni(@RequestParam(name="dni",defaultValue="0") String dni){
        Secretario secretario = secretarioService.findByDni(dni);
        return ResponseEntity.ok(secretario);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    @PostMapping("/guardar")
    public Secretario save(@RequestBody Secretario secretario){
        return secretarioService.save(secretario);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Secretario> update(@PathVariable int id,@RequestBody Secretario secretariorequest){
        Secretario secretario = secretarioService.findById(id);
         secretario.setDni(secretariorequest.getDni());
         secretario.setNombre(secretariorequest.getNombre());
         secretario.setApellido(secretariorequest.getApellido());
         secretario.setNombre(secretariorequest.getNombre());
         secretario.setEdad(secretariorequest.getEdad());
         secretario.setGenero(secretariorequest.getGenero());
         secretario.setNumTelefonico(secretariorequest.getNumTelefonico());
         secretario.setAniosLabor(secretariorequest.getAniosLabor());
         
         Secretario actualizado=secretarioService.save(secretario);
        return ResponseEntity.ok(actualizado);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable int id){
        secretarioService.deleteById(id);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
