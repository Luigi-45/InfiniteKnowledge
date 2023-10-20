package com.InfiniteKnowledge.RegistrosReportes.controllers;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import com.InfiniteKnowledge.RegistrosReportes.services.RegistroCalificacion.IRegistroCalificacionServiceCRUD;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registroCalificacion")
@CrossOrigin(origins = "*")
public class RegistroCalificacionController {
    
    @Autowired
    private IRegistroCalificacionServiceCRUD registroCalificacionService;
    
    @GetMapping
    public List<RegistroCalificacion> findAllByDocenteCursoBimestre(@RequestParam(name="docenteCursoId",defaultValue="0") int docenteCursoId,
            @RequestParam(name="bimestre",defaultValue="0") int bimestre){
        return (ArrayList<RegistroCalificacion>) registroCalificacionService.findAllByDocenteCursoBimestre(docenteCursoId, bimestre);
    }
    
    @GetMapping("/findById")
    public ResponseEntity<RegistroCalificacion> findById(@RequestParam(name="registroCalificacionId",defaultValue="0") int registroCalificacionId){
        RegistroCalificacion registroCalificacion = registroCalificacionService.findById(registroCalificacionId);
        return ResponseEntity.ok(registroCalificacion);
    }
    
    @PostMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf(@RequestBody List<Object[]> registrosCalificacion){
        byte[] pdfBytes = registroCalificacionService.generatePdf(registrosCalificacion); 

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ReporteCalificaciones"+String.valueOf(registrosCalificacion.get(0)[2])+
                String.valueOf(registrosCalificacion.get(0)[8])+".pdf"); 

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
    
    @PostMapping("/excel")
    public ResponseEntity<byte[]> exportExcel(@RequestBody List<Object[]> registrosCalificacion){
        Workbook workbook = registroCalificacionService.generateExcel(registrosCalificacion); 

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            byte[] bytes = outputStream.toByteArray();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "ReporteCalificaciones"+String.valueOf(registrosCalificacion.get(0)[2])+
                String.valueOf(registrosCalificacion.get(0)[8])+".xlsx");

            return ResponseEntity.ok().headers(headers).body(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/guardar")
    public void save(@RequestBody List<RegistroCalificacion> registrosCalificacion){
        registroCalificacionService.save(registrosCalificacion);
    }
    
    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String,Boolean>> delete(@RequestParam(name="registroCalificacionId",defaultValue="0") int registroCalificacionId){
        registroCalificacionService.deleteById(registroCalificacionId);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
