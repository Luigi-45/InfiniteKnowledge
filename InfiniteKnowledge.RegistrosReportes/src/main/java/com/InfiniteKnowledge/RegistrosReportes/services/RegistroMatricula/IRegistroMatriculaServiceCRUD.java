package com.InfiniteKnowledge.RegistrosReportes.services.RegistroMatricula;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;

public interface IRegistroMatriculaServiceCRUD {
    public RegistroMatricula save(RegistroMatricula registroMatricula);
    public List<RegistroMatricula> findAllByGradoSeccion(int gradoSeccionId);
    public RegistroMatricula findByEstudianteId(int estudianteId);
    public RegistroMatricula findById(int registroMatriculaId);
    public byte[] generatePdf(List<Object[]> registros);
    public Workbook generateExcel(List<Object[]> registros);
    public void deleteById(int registroMatriculaId);
}
