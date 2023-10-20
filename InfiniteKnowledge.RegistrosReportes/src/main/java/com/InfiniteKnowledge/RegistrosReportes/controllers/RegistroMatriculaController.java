package com.InfiniteKnowledge.RegistrosReportes.controllers;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import com.InfiniteKnowledge.RegistrosReportes.services.RegistroMatricula.IRegistroMatriculaServiceCRUD;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/registroMatricula")
@CrossOrigin(origins = "*")
public class RegistroMatriculaController {
    
    @Autowired
    private IRegistroMatriculaServiceCRUD registroMatriculaService;
    
    @GetMapping
    public List<RegistroMatricula> findAllByGradoSeccion(@RequestParam(name="gradoSeccionId",defaultValue="0") int gradoSeccionId){
        return (ArrayList<RegistroMatricula>) registroMatriculaService.findAllByGradoSeccion(gradoSeccionId);
    }
    
    @GetMapping("/findById")
    public ResponseEntity<RegistroMatricula> findById(@RequestParam(name="registroMatriculaId",defaultValue="0") int registroMatriculaId){
        RegistroMatricula registroMatricula = registroMatriculaService.findById(registroMatriculaId);
        return ResponseEntity.ok(registroMatricula);
    }
    
    @PostMapping("/guardar")
    public RegistroMatricula save(@RequestBody RegistroMatricula registroMatricula){
        return registroMatriculaService.save(registroMatricula);
    }
    
    @PostMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf(@RequestBody List<Object[]> registrosMatricula){
        byte[] pdfBytes = registroMatriculaService.generatePdf(registrosMatricula); 

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ReporteMatricula"+String.valueOf(registrosMatricula.get(0)[2])+".pdf"); 

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
    
    @PostMapping("/excel")
    public ResponseEntity<byte[]> exportExcel(@RequestBody List<Object[]> registrosMatricula){
        Workbook workbook = registroMatriculaService.generateExcel(registrosMatricula); 

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            byte[] bytes = outputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "ReporteMatricula"+String.valueOf(registrosMatricula.get(0)[2])+".xlsx");

            return ResponseEntity.ok().headers(headers).body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/actualizar")
    public RegistroMatricula update(@RequestBody RegistroMatricula registroMatricula){
        return registroMatriculaService.save(registroMatricula);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="registroMatriculaId",defaultValue="0") int registroMatriculaId){
        registroMatriculaService.deleteById(registroMatriculaId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
