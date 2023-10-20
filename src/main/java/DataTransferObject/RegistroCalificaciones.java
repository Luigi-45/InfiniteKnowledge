package DataTransferObject;

import Utilities.Validator.ValidatorRegistro;
import Utilities.Validator.ValidatorTipoDatos;
import java.util.Date;

public class RegistroCalificaciones extends Registro{
    
    private String estadoAprobacion;
    private String bimestre;
    private int calif1;
    private int calif2;
    private int calif3;
    private int calif4;
    private int promedio;
    
    private String calif1S;
    private String calif2S;
    private String calif3S;
    private String calif4S;
    private String promedioS;

    public RegistroCalificaciones() {
        
    }
    
    public RegistroCalificaciones(String docenteId, String estudianteId, String cursoId, String salonClases, String bimestre) throws Exception{
        this.setDocenteId(docenteId);
        this.setEstudianteId(estudianteId);
        this.setCursoId(cursoId);
        this.setSalonClases(salonClases);
        this.setBimestre(bimestre);
    }

    public RegistroCalificaciones(String docenteId, String estudianteId, String cursoId, String salonClases,  Date fechaEmision, String estadoAprobacion,
            String calif1, String calif2, String calif3, String calif4, String promedio, String bimestre) throws Exception {
        super(docenteId, estudianteId, cursoId, salonClases, fechaEmision);
        this.setEstadoAprobacion(estadoAprobacion);
        this.setCalif1(calif1);
        this.setCalif2(calif2);
        this.setCalif3(calif3);
        this.setCalif4(calif4);
        this.setPromedio(promedio);
        this.setBimestre(bimestre);
    }

    public String getEstadoAprobacion() {
        return estadoAprobacion;
    }

    public void setEstadoAprobacion(String estadoAprobacion) {
        this.estadoAprobacion = estadoAprobacion;
    }

    public int getCalif1() {
        return calif1;
    }

    public void setCalif1(String calif1) throws Exception {
        if((calif1!=null)&&(!calif1.isEmpty())){
            if(!ValidatorTipoDatos.isInteger(calif1)){
                throw new Exception("El campo calificación 1 del Registro de Asistencias no es un número");
            }
            else{
                if(!ValidatorRegistro.isValorAsistencia(Integer.parseInt(calif1))){
                    throw new Exception("El campo calificación 1 del Registro de Asistencias no posee un formato adecuado");
                }
            }
        }
        
        this.calif1 = Integer.parseInt(calif1);
    }

    public int getCalif2() {
        return calif2;
    }

    public void setCalif2(String calif2) throws Exception {
        if((calif2!=null)&&(!calif2.isEmpty())){
            if(!ValidatorTipoDatos.isInteger(calif2)){
                throw new Exception("El campo calificación 2 del Registro de Asistencias no es un número");
            }
            else{
                if(!ValidatorRegistro.isValorAsistencia(Integer.parseInt(calif2))){
                    throw new Exception("El campo calificación 2 del Registro de Asistencias no posee un formato adecuado");
                }
            }
        }
        
        this.calif2 = Integer.parseInt(calif2);
    }

    public int getCalif3() {
        return calif3;
    }

    public void setCalif3(String calif3) throws Exception {
        if((calif3!=null)&&(!calif3.isEmpty())){
            if(!ValidatorTipoDatos.isInteger(calif3)){
                throw new Exception("El campo calificación 3 del Registro de Asistencias no es un número");
            }
            else{
                if(!ValidatorRegistro.isValorAsistencia(Integer.parseInt(calif3))){
                    throw new Exception("El campo calificación 3 del Registro de Asistencias no posee un formato adecuado");
                }
            }
        }
        
        this.calif3 = Integer.parseInt(calif3);
    }

    public int getCalif4() {
        return calif4;
    }

    public void setCalif4(String calif4) throws Exception{
        if((calif4!=null)&&(!calif4.isEmpty())){
            if(!ValidatorTipoDatos.isInteger(calif4)){
                throw new Exception("El campo calificación 4 del Registro de Asistencias no es un número");
            }
            else{
                if(!ValidatorRegistro.isValorAsistencia(Integer.parseInt(calif4))){
                    throw new Exception("El campo calificación 4 del Registro de Asistencias no posee un formato adecuado");
                }
            }
        }
        
        this.calif4 = Integer.parseInt(calif4);
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        
        this.promedio = Integer.parseInt(promedio);
    }

    public String getCalif1S() {
        return calif1S;
    }

    public void setCalif1S(String calif1S) {
        this.calif1S = calif1S;
    }

    public String getCalif2S() {
        return calif2S;
    }

    public void setCalif2S(String calif2S) {
        this.calif2S = calif2S;
    }

    public String getCalif3S() {
        return calif3S;
    }

    public void setCalif3S(String calif3S) {
        this.calif3S = calif3S;
    }

    public String getCalif4S() {
        return calif4S;
    }

    public void setCalif4S(String calif4S) {
        this.calif4S = calif4S;
    }

    public String getPromedioS() {
        return promedioS;
    }

    public void setPromedioS(String promedioS) {
        this.promedioS = promedioS;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }
}