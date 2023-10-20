package com.InfiniteKnowledge.RegistrosReportes.domain.RegistroCalificacion;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroCalificacion;
import com.InfiniteKnowledge.RegistrosReportes.repositories.IRegistroCalificacionRepository;
import com.InfiniteKnowledge.RegistrosReportes.repositories.feignclients.IDocenteCursoFeignClient;
import com.InfiniteKnowledge.RegistrosReportes.util.exceptions.ResourceNotFoundException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.ByteArrayOutputStream;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Component
public class RegistroCalificacionBO implements IRegistroCalificacionBOCRUD{

    @Autowired
    private IRegistroCalificacionRepository registroCalificacionRepository;
    
    private final IDocenteCursoFeignClient docenteCursoFeignClient;

    public RegistroCalificacionBO(IDocenteCursoFeignClient docenteCursoFeignClient) {
        this.docenteCursoFeignClient = docenteCursoFeignClient;
    }

    @Override
    @Transactional
    public void save(List<RegistroCalificacion> registroCalificacion) {
        for(RegistroCalificacion rc:registroCalificacion){
            registroCalificacionRepository.save(rc);
        }
    }
    
    @Override
    public List<RegistroCalificacion> findAllByDocenteCursoBimestre(int docenteCursoId, int bimestre) {
        return registroCalificacionRepository.findAllByGradoSeccion(docenteCursoId, bimestre);
    }

    @Override
    public RegistroCalificacion findById(int registroCalificacionId) {
        return registroCalificacionRepository.findById(registroCalificacionId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el registro de calificación con el id: "+registroCalificacionId));
    }

    @Override
    public void deleteById(int registroCalificacionId) {
        registroCalificacionRepository.deleteById(registroCalificacionId);
    }

    @Override
    public byte[] generatePdf(List<Object[]> registros) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        
        PageSize pageSize = new PageSize(PageSize.A4).rotate();
        Document document = new Document(pdf, pageSize);
        
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);

        try {
            addTableHeader(table);
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }

        addTableData(table, registros);
        document.add(table);

        document.close();
        return baos.toByteArray();
    }
    
    private void addTableHeader(Table table) throws IOException {
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
        Cell cell = new Cell().add(new Paragraph("Id").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Estudiante").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Docente-Curso").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Calif. 1").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Calif. 2").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Calif. 3").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Calif. 4").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Promedio").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Bimestre").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
    }
    
    private void addTableData(Table table, List<Object[]> registros) {
        for(Object[] o:registros){
            for(int i=0;i<o.length-2;i++){
               table.addCell(String.valueOf(o[i]));
            }
            
            table.addCell(String.valueOf((Double.parseDouble(String.valueOf(o[3])) + 
                    Double.parseDouble(String.valueOf(o[4])) + Double.parseDouble(String.valueOf(o[5])) + Double.parseDouble(String.valueOf(o[6])))/4));
            
            table.addCell(String.valueOf(o[8]));
        }
    }

    @Override
    public Workbook generateExcel(List<Object[]> registros) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("RegistroCalificacion"+String.valueOf(registros.get(0)[2])+
                String.valueOf(registros.get(0)[8]));
        
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        
        org.apache.poi.ss.usermodel.Cell cell = null;
        
        Row excelRow = sheet.createRow(0);
        cell = excelRow.createCell(0);
        cell.setCellValue("Id");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(1);
        cell.setCellValue("Estudiante");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(2);
        cell.setCellValue("Docente-Curso");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(3);
        cell.setCellValue("Calif. 1");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(4);
        cell.setCellValue("Calif. 2");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(5);
        cell.setCellValue("Calif. 3");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(6);
        cell.setCellValue("Calif. 4");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(7);
        cell.setCellValue("Promedio");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(8);
        cell.setCellValue("Bimestre");
        cell.setCellStyle(style);
        
        int rowNum = 1;
        for (Object[] row : registros) {
            excelRow = sheet.createRow(rowNum++);
            int colNum = 0;
            
            for(int i=0;i<row.length-2;i++){
                cell = excelRow.createCell(colNum++);
                if (row[i] instanceof String) {
                    cell.setCellValue((String) row[i]);
                } else if (row[i] instanceof Integer) {
                    cell.setCellValue((Integer) row[i]);
                }
            }
            
            cell = excelRow.createCell(colNum++);
            cell.setCellValue((Double.parseDouble(String.valueOf(row[3])) + 
                    Double.parseDouble(String.valueOf(row[4])) + Double.parseDouble(String.valueOf(row[5])) + Double.parseDouble(String.valueOf(row[6])))/4);
            
            cell = excelRow.createCell(colNum++);
            cell.setCellValue(String.valueOf(row[8]));
        }
        
        return workbook;
    }

    @Override
    public List<Object[]> findDocenteCursoByEstudianteId(int estudianteId) {
        List<Integer> listaId = this.registroCalificacionRepository.findDocenteCursoIdByEstudianteId(estudianteId);
        List<Object[]> nombres = docenteCursoFeignClient.findNames();
        
        List<Object[]> docentesCurso = new ArrayList<>();
        
        for(Integer i:listaId){
            nombres.forEach(object -> {
                if(Integer.parseInt(String.valueOf(object[0])) == i){
                    docentesCurso.add(object);
                }
            });
        }
        
        return docentesCurso;
    }

    @Override
    public List<RegistroCalificacion> findAllByDcoenteCursoAndEstudiante(int docenteCursoId, int estudianteId) {
        return this.registroCalificacionRepository.findAllByDcoenteCursoAndEstudiante(docenteCursoId, estudianteId);
    }
}
