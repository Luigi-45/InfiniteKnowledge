package com.InfiniteKnowledge.RegistrosReportes.domain.RegistroMatricula;

import com.InfiniteKnowledge.RegistrosReportes.entities.RegistroMatricula;
import com.InfiniteKnowledge.RegistrosReportes.repositories.IRegistroMatriculaRepository;
import com.InfiniteKnowledge.RegistrosReportes.util.exceptions.ResourceNotFoundException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistroMatriculaBO implements IRegistroMatriculaBOCRUD{

    @Autowired
    private IRegistroMatriculaRepository registroMatriculaRepository;
    
    @Override
    public RegistroMatricula save(RegistroMatricula registroMatricula) {
        return registroMatriculaRepository.save(registroMatricula);
    }

    @Override
    public RegistroMatricula findById(int registroMatriculaId) {
        return registroMatriculaRepository.findById(registroMatriculaId)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el registro de matrícula con el id: "+registroMatriculaId));
    }
    
    @Override
    public List<RegistroMatricula> findAllByGradoSeccion(int gradoSeccionId) {
        return registroMatriculaRepository.findAllByGradoSeccion(gradoSeccionId);
    }

    @Override
    public void deleteById(int registroMatriculaId) {
        registroMatriculaRepository.deleteById(registroMatriculaId);
    }

    @Override
    public RegistroMatricula findByEstudianteId(int estudianteId) {
        return registroMatriculaRepository.findByEstudianteId(estudianteId);
    }

    @Override
    public byte[] generatePdf(List<Object[]> registros) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        
        PageSize pageSize = new PageSize(PageSize.A4).rotate();
        Document document = new Document(pdf, pageSize);
        
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1, 1}));
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
        
        cell = new Cell().add(new Paragraph("Grado y Sección").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
        
        cell = new Cell().add(new Paragraph("Paquete").setFont(font).setFontSize(12));
        cell.setTextAlignment(TextAlignment.CENTER);
        table.addCell(cell);
    }
    
    private void addTableData(Table table, List<Object[]> registros) {
        for(Object[] o:registros){
            for(Object ob:o){
                table.addCell(String.valueOf(ob));
            }
        }
    }
    
    @Override
    public Workbook generateExcel(List<Object[]> registros) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("RegistroMatricula"+String.valueOf(registros.get(0)[2]));
        
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
        cell.setCellValue("Grado y sección");
        cell.setCellStyle(style);
        
        cell = excelRow.createCell(3);
        cell.setCellValue("Paquete");
        cell.setCellStyle(style);
        
        int rowNum = 1;
        for (Object[] row : registros) {
            excelRow = sheet.createRow(rowNum++);
            int colNum = 0;
            
            for(int i=0;i<row.length;i++){
                cell = excelRow.createCell(colNum++);
                cell.setCellValue(String.valueOf(row[i]));
            }
        }
        
        return workbook;
    }

}