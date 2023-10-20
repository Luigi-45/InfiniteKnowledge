package com.InfiniteKnowledge.RegistrosReportes.controllers;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import com.InfiniteKnowledge.RegistrosReportes.services.RegistroCalificacion.IRegistroCalificacionServiceCRUD;
import com.InfiniteKnowledge.RegistrosReportes.services.RegistroMatricula.IRegistroMatriculaServiceCRUD;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/verRegistros")
@CrossOrigin(origins = "*")
public class VerRegistroController {
    
    private final IRegistroCalificacionServiceCRUD registroCalificacionesService;
    private final IRegistroMatriculaServiceCRUD registroMatriculaService;

    public VerRegistroController(IRegistroCalificacionServiceCRUD registroCalificacionesService, IRegistroMatriculaServiceCRUD registroMatriculaService) {
        this.registroCalificacionesService = registroCalificacionesService;
        this.registroMatriculaService = registroMatriculaService;
    }
    
    @GetMapping("/findRCDocenteCurso")
    public ResponseEntity<List<Object[]>> findDocenteCursoByEstudianteId(@RequestParam(name="estudianteId",defaultValue="0") int estudianteId){
        List<Object[]> nombres = registroCalificacionesService.findDocenteCursoByEstudianteId(estudianteId);
        return ResponseEntity.ok(nombres);
    }
    
    @GetMapping("/findRCByDocenteCursoAndEstudiante")
    public ResponseEntity<List<RegistroCalificacion>> findAllRCByDcoenteCursoAndEstudiante(@RequestParam(name="docenteCursoId",defaultValue="0") int docenteCursoId,
            @RequestParam(name="estudianteId",defaultValue="0") int estudianteId){
        List<RegistroCalificacion> registros = registroCalificacionesService.findAllByDcoenteCursoAndEstudiante(docenteCursoId, estudianteId);
        return ResponseEntity.ok(registros);
    }
    
    @GetMapping("/findRMByEstudianteId")
    public ResponseEntity<RegistroMatricula> findRMByEstudianteId(@RequestParam(name="estudianteId",defaultValue="0") int estudianteId){
        RegistroMatricula registroMatricula = registroMatriculaService.findByEstudianteId(estudianteId);
        return ResponseEntity.ok(registroMatricula);
    }
}
