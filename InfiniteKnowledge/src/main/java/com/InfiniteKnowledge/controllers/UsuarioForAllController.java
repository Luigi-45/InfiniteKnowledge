package com.InfiniteKnowledge.controllers;

import com.InfiniteKnowledge.entities.Docente;
import com.InfiniteKnowledge.entities.Usuario;
import com.InfiniteKnowledge.services.docente.IDocenteServiceCRUD;
import com.InfiniteKnowledge.services.usuario.IUsuarioServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarioForAll")
@CrossOrigin(origins = "*")
public class UsuarioForAllController {
    
    @Autowired 
    private IUsuarioServiceCRUD usuarioService;
    
    private final IDocenteServiceCRUD docenteService;

    public UsuarioForAllController(IDocenteServiceCRUD docenteService) {
        this.docenteService = docenteService;
    }
    
    @GetMapping("/findByCorreoElectronico")
    public ResponseEntity<Usuario> findByCorreoElectronico(@RequestParam(name="correoElectronico",defaultValue="0") String correoElectronico){
        Usuario usuario = usuarioService.findByCorreoElectronico(correoElectronico);
        return ResponseEntity.ok(usuario);
    }
    
    @GetMapping("/findDocenteById")
    public ResponseEntity<Docente> findDocenteById(@RequestParam(name="docenteId",defaultValue="0") int docenteId){
        Docente docente = docenteService.findById(docenteId);
        return ResponseEntity.ok(docente);
    }
}
