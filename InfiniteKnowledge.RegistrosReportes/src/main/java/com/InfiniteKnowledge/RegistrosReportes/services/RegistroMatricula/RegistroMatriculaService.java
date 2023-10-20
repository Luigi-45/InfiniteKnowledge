package com.InfiniteKnowledge.RegistrosReportes.services.RegistroMatricula;

import com.InfiniteKnowledge.RegistrosReportes.domain.RegistroMatricula.IRegistroMatriculaBOCRUD;
import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroMatriculaService implements IRegistroMatriculaServiceCRUD{
    
    @Autowired
    private IRegistroMatriculaBOCRUD registroMatriculaBO;

    @Override
    public RegistroMatricula save(RegistroMatricula registroMatricula) {
        return registroMatriculaBO.save(registroMatricula);
    }

    @Override
    public List<RegistroMatricula> findAllByGradoSeccion(int gradoSeccionId) {
        return registroMatriculaBO.findAllByGradoSeccion(gradoSeccionId);
    }

    @Override
    public RegistroMatricula findById(int registroMatriculaId) {
        return registroMatriculaBO.findById(registroMatriculaId);
    }

    @Override
    public void deleteById(int registroMatriculaId) {
        registroMatriculaBO.deleteById(registroMatriculaId);
    }

    @Override
    public RegistroMatricula findByEstudianteId(int estudianteId) {
        return registroMatriculaBO.findByEstudianteId(estudianteId);
    }

    @Override
    public byte[] generatePdf(List<Object[]> registros) {
        return registroMatriculaBO.generatePdf(registros);
    }

    @Override
    public Workbook generateExcel(List<Object[]> registros) {
        return registroMatriculaBO.generateExcel(registros);
    }
    
}
