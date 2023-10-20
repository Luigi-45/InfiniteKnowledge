package com.InfiniteKnowledge.RegistrosReportes.services.RegistroCalificacion;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;

public interface IRegistroCalificacionServiceCRUD {
    public void save(List<RegistroCalificacion> registroCalificacion);
    public List<RegistroCalificacion> findAllByDocenteCursoBimestre(int docenteCursoId, int bimestre);
    public List<Object[]> findDocenteCursoByEstudianteId(int estudianteId);
    public List<RegistroCalificacion> findAllByDcoenteCursoAndEstudiante(int docenteCursoId, int estudianteId);
    public byte[] generatePdf(List<Object[]> registros);
    public Workbook generateExcel(List<Object[]> registros);
    public RegistroCalificacion findById(int registroCalificacionId);
    public void deleteById(int registroCalificacionId);
}
