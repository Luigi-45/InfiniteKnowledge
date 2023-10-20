package DataAccessLayer;

import Connection.UConnection;
import static DataAccessLayer.EstudianteDAO.bitacora;
import DataTransferObject.RegistroCalificaciones;
import Utilities.Bitacora.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroCalificacionesDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.RegistroCalificacionesDAO", "bitacoraRegistroCalificaciones.txt", Level.FINE,false,false);
    
    public void insertar(RegistroCalificaciones registro) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_insertar(?,?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, registro.getDocenteId());
            stat.setInt(2, registro.getEstudianteId());
            stat.setInt(3, registro.getCursoId());
            stat.setString(4, registro.getSalonClases());
            stat.setString(5, registro.getBimestre());
            
            if(registro.getCalif1S()==null){
                stat.setNull(6, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(6, registro.getCalif1());
            }
            
            if(registro.getCalif2S()==null){
                stat.setNull(7, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(7, registro.getCalif2());
            }
            
            if(registro.getCalif3S()==null){
                stat.setNull(8, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(8, registro.getCalif3());
            }
            
            if(registro.getCalif4S()==null){
                stat.setNull(9, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(9, registro.getCalif4());
            }
            
            if(registro.getFechaEmision() == null){
                stat.setNull(10, java.sql.Types.VARCHAR);
            }
            else{
                stat.setDate(10, new java.sql.Date(registro.getFechaEmision().getTime()));
            }

            bitacora.info("Inserción del Registro de Calificaciones");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo insertar al Registro de Calificaciones");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo insertar al Registro de Calificaciones");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void actualizar(RegistroCalificaciones registro, String bimestreCambiado) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_actualizar(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, registro.getDocenteId());
            stat.setInt(2, registro.getEstudianteId());
            stat.setInt(3, registro.getCursoId());
            stat.setString(4, registro.getSalonClases());
            stat.setString(5, registro.getBimestre());
            stat.setString(6, bimestreCambiado);
            
            if(registro.getCalif1S() == null){
                stat.setNull(7, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(7, registro.getCalif1());
            }
            
            if(registro.getCalif2S() == null){
                stat.setNull(8, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(8, registro.getCalif2());
            }
            
            if(registro.getCalif3S() == null){
                stat.setNull(9, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(9, registro.getCalif3());
            }
            
            if(registro.getCalif4S() == null){
                stat.setNull(10, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(10, registro.getCalif4());
            }
            
            if(registro.getFechaEmision() == null){
                stat.setNull(11, java.sql.Types.VARCHAR);
            }
            else{
                stat.setDate(11, new java.sql.Date(registro.getFechaEmision().getTime()));
            }
            
            if(registro.getEstadoAprobacion() == null){
                stat.setNull(12, java.sql.Types.VARCHAR);
            }
            else{
                stat.setString(12, registro.getEstadoAprobacion());
            }
            
            if(registro.getPromedioS() == null){
                stat.setNull(13, java.sql.Types.VARCHAR);
            }
            else{
                stat.setInt(13, registro.getPromedio());
            }
     
            bitacora.info("Actualización del Registro de Calificaciones");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-003");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-003")){
                bitacora.severe("E-003: No se pudo actualizar al Registro de Calificaciones");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: No se pudo actualizar al Registro de Calificaciones");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
     public ArrayList<RegistroCalificaciones> buscarPorDNIEstudiante2(String dni, int cursoId, String bimestre) throws Exception{
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        RegistroCalificaciones registroCalificaciones=null;
        ArrayList<RegistroCalificaciones> registrosCalificaciones=new ArrayList<>();

        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_buscar_por_dni_de_estudiante2(?,?,?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            stat.setInt(2, cursoId);
            stat.setString(3, bimestre);
            
            bitacora.info("Búsqueda de Registro de Calificaciones por DNI de Estudiante");
            rs=stat.executeQuery();

            while (rs.next()) {
                registroCalificaciones=new RegistroCalificaciones();
                registroCalificaciones.setEstudiante(rs.getString("estudiante"));
                registroCalificaciones.setDocente(rs.getString("docente"));
                registroCalificaciones.setCurso(rs.getString("curso"));
                registroCalificaciones.setDocenteId(String.valueOf(rs.getInt("docente_id")));
                registroCalificaciones.setEstudianteId(String.valueOf(rs.getInt("estudiante_id")));
                registroCalificaciones.setCursoId(String.valueOf(rs.getInt("curso_id")));
                registroCalificaciones.setSalonClases(rs.getString("salon_clases"));
                registroCalificaciones.setCalif1(String.valueOf(rs.getInt("calif1")));
                registroCalificaciones.setCalif2(String.valueOf(rs.getInt("calif2")));
                registroCalificaciones.setCalif3(String.valueOf(rs.getInt("calif3")));
                registroCalificaciones.setCalif4(String.valueOf(rs.getInt("calif4")));
                registroCalificaciones.setPromedio(String.valueOf(rs.getInt("promedio")));
                registroCalificaciones.setEstadoAprobacion(rs.getString("estado"));
                registroCalificaciones.setFechaEmision(rs.getDate("emision"));
                registroCalificaciones.setBimestre(rs.getString("bimestre"));
                registrosCalificaciones.add(registroCalificaciones);
            }

        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
            return registrosCalificaciones;
    }
    
    public ArrayList<RegistroCalificaciones> buscarParaDocente(String dni, int cursoId, String salonClases, String bimestre) throws Exception{
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        RegistroCalificaciones registroCalificaciones=null;
        ArrayList<RegistroCalificaciones> registrosCalificaciones=new ArrayList<>();

        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_buscar_para_docente(?,?,?,?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            stat.setInt(2, cursoId);
            stat.setString(3, salonClases);
            stat.setString(4, bimestre);
            
            bitacora.info("Búsqueda de Registros de Calificaciones para Docente");
            rs=stat.executeQuery();

            while (rs.next()) {
                registroCalificaciones=new RegistroCalificaciones();
                registroCalificaciones.setEstudiante(rs.getString("estudiante"));
                registroCalificaciones.setDocente(rs.getString("docente"));
                registroCalificaciones.setCurso(rs.getString("curso"));
                registroCalificaciones.setDocenteId(String.valueOf(rs.getInt("docente_id")));
                registroCalificaciones.setEstudianteId(String.valueOf(rs.getInt("estudiante_id")));
                registroCalificaciones.setCursoId(String.valueOf(rs.getInt("curso_id")));
                registroCalificaciones.setSalonClases(rs.getString("salon_clases"));
                registroCalificaciones.setCalif1(String.valueOf(rs.getInt("calif1")));
                registroCalificaciones.setCalif2(String.valueOf(rs.getInt("calif2")));
                registroCalificaciones.setCalif3(String.valueOf(rs.getInt("calif3")));
                registroCalificaciones.setCalif4(String.valueOf(rs.getInt("calif4")));
                registroCalificaciones.setPromedio(String.valueOf(rs.getInt("promedio")));
                registroCalificaciones.setEstadoAprobacion(rs.getString("estado"));
                registroCalificaciones.setFechaEmision(rs.getDate("emision"));
                registroCalificaciones.setBimestre(rs.getString("bimestre"));
                registrosCalificaciones.add(registroCalificaciones);
            }
            

        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
            return registrosCalificaciones;
    }
    
    public RegistroCalificaciones buscarRegistroEspecífico(int estudianteId, int docenteId, int cursoId, String bimestre) throws Exception{
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        RegistroCalificaciones registroCalificaciones=null;

        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_buscar_registro_especifico(?,?,?,?)";
            stat=con.prepareCall(proc);
            stat.setInt(1, estudianteId);
            stat.setInt(2, docenteId);
            stat.setInt(3, cursoId);
            stat.setString(4, bimestre);
            rs=stat.executeQuery();

            while (rs.next()) {
                registroCalificaciones=new RegistroCalificaciones();
                registroCalificaciones.setEstudiante(rs.getString("estudiante"));
                registroCalificaciones.setDocente(rs.getString("docente"));
                registroCalificaciones.setCurso(rs.getString("curso"));
                registroCalificaciones.setDocenteId(String.valueOf(rs.getInt("docente_id")));
                registroCalificaciones.setEstudianteId(String.valueOf(rs.getInt("estudiante_id")));
                registroCalificaciones.setCursoId(String.valueOf(rs.getInt("curso_id")));
                registroCalificaciones.setSalonClases(rs.getString("salon_clases"));
                registroCalificaciones.setCalif1(String.valueOf(rs.getInt("calif1")));
                registroCalificaciones.setCalif2(String.valueOf(rs.getInt("calif2")));
                registroCalificaciones.setCalif3(String.valueOf(rs.getInt("calif3")));
                registroCalificaciones.setCalif4(String.valueOf(rs.getInt("calif4")));
                registroCalificaciones.setPromedio(String.valueOf(rs.getInt("promedio")));
                registroCalificaciones.setEstadoAprobacion(rs.getString("estado"));
                registroCalificaciones.setFechaEmision(rs.getDate("emision"));
                registroCalificaciones.setBimestre(rs.getString("bimestre"));
            }

        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
            return registroCalificaciones;
    }
    
    public void eliminar(RegistroCalificaciones registroCalificaciones) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_registro_calificaciones_eliminar(?,?,?,?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, registroCalificaciones.getDocenteId());
            stat.setInt(2, registroCalificaciones.getEstudianteId());
            stat.setInt(3, registroCalificaciones.getCursoId());
            stat.setString(4, registroCalificaciones.getBimestre());
            
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-002");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-002")){
                bitacora.severe("E-002: No se pudo eliminar al Registro de Calificaciones");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: No se pudo eliminar al Registro de Calificaciones");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
}
