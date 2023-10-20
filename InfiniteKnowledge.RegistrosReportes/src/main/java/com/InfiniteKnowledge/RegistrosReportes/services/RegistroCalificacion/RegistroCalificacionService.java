package com.InfiniteKnowledge.RegistrosReportes.services.RegistroCalificacion;

import com.InfiniteKnowledge.RegistrosReportes.domain.RegistroCalificacion.IRegistroCalificacionBOCRUD;
import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroCalificacionService implements IRegistroCalificacionServiceCRUD{

    @Autowired
    private IRegistroCalificacionBOCRUD registroCalificacionBO;
    
    @Override
    public void save(List<RegistroCalificacion> registroCalificacion) {
        registroCalificacionBO.save(registroCalificacion);
    }

    @Override
    public List<RegistroCalificacion> findAllByDocenteCursoBimestre(int docenteCursoId, int bimestre) {
        return registroCalificacionBO.findAllByDocenteCursoBimestre(docenteCursoId, bimestre);
    }

    @Override
    public RegistroCalificacion findById(int registroCalificacionId) {
        return registroCalificacionBO.findById(registroCalificacionId);
    }

    @Override
    public void deleteById(int registroCalificacionId) {
        registroCalificacionBO.deleteById(registroCalificacionId);
    }

    @Override
    public byte[] generatePdf(List<Object[]> registros) {
        return registroCalificacionBO.generatePdf(registros);
    }

    @Override
    public Workbook generateExcel(List<Object[]> registros) {
        return registroCalificacionBO.generateExcel(registros);
    }

    @Override
    public List<Object[]> findDocenteCursoByEstudianteId(int estudianteId) {
        return registroCalificacionBO.findDocenteCursoByEstudianteId(estudianteId);
    }

    @Override
    public List<RegistroCalificacion> findAllByDcoenteCursoAndEstudiante(int docenteCursoId, int estudianteId) {
        return registroCalificacionBO.findAllByDcoenteCursoAndEstudiante(docenteCursoId, estudianteId);
    }
    
}
