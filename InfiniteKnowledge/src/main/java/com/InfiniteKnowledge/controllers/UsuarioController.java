package com.InfiniteKnowledge.controllers;

import com.InfiniteKnowledge.entities.Usuario;
import com.InfiniteKnowledge.services.usuario.IUsuarioServiceCRUD;
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
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired 
    private IUsuarioServiceCRUD usuarioService;
    
    @GetMapping
    public List<Usuario> findAll(){
        return (ArrayList<Usuario>) usuarioService.findAll();
    }
    
    @GetMapping("/findById")
    public ResponseEntity<Usuario> findByDni(@RequestParam(name="usuarioId",defaultValue="0") int usuarioId){
        Usuario usuario = usuarioService.findById(usuarioId);
        return ResponseEntity.ok(usuario);
    }
    
    @GetMapping("/findByCorreoElectronico")
    public ResponseEntity<Usuario> findByCorreoElectronico(@RequestParam(name="correoElectronico",defaultValue="0") String correoElectronico){
        Usuario usuario = usuarioService.findByCorreoElectronico(correoElectronico);
        return ResponseEntity.ok(usuario);
    }
    
    @GetMapping("/findByDni")
    public ResponseEntity<Usuario> findByDni(@RequestParam(name="dni",defaultValue="0") String dni){
        Usuario usuario = usuarioService.findByDni(dni);
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping("/guardar")
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }
    
    @PutMapping("/actualizar")
    public Usuario update(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="usuarioId",defaultValue="0") int usuarioId){
        usuarioService.deleteById(usuarioId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
