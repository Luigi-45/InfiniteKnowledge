/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.UConnection;
import DataTransferObject.Docente;
import Utilities.Bitacora.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASRock™ Gaming k4
 */
public class DocenteDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.DocenteDAO", "bitacoraDocente.txt", Level.FINE,false,false);
    
    public void insertar(Docente docente) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_insertar(?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, docente.getDni());
            stat.setString(2, docente.getNombre());
            stat.setString(3, docente.getApellidoPaterno());
            stat.setString(4, docente.getApellidoMaterno());
            stat.setDate(5, new java.sql.Date(docente.getFechaNacimiento().getTime()));
            stat.setString(6, docente.getGenero());
            stat.setString(7, docente.getNumeroTelefonico());
            stat.setString(8, docente.getGradoAcademico());
            stat.setString(9, docente.getEspecialidadAcademica());
            
            bitacora.info("Registro de Docente");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al Docente");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al Docente");
            }
            
            if(e.getMessage().contains("idx_docente_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_docente_numero_telefonico")){
                bitacora.severe("E-003: El numero telefonico ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: El numero telefonico ingresado ya existe en la base de datos");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public Docente buscarPorDNI(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Docente docente=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_buscar_por_dni(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Búsqueda de Docente por DNI");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                docente=new Docente();
                docente.setIdMiembro(rs.getInt("docente_id"));
                docente.setDni(rs.getString("dni"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellidoPaterno(rs.getString("apellido_paterno"));
                docente.setApellidoMaterno(rs.getString("apellido_materno"));
                docente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                docente.setGenero(rs.getString("genero"));
                docente.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                docente.setGradoAcademico(rs.getString("grado_academico"));
                docente.setEspecialidadAcademica(rs.getString("especialidad_academica"));
                docente.setNombreCompleto(rs.getString("nombre_completo"));
            }
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return docente;
    }
    
    public ArrayList<Docente> buscar_por_nombre_completo(String nombreCompleto) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Docente docente=null;
        ArrayList<Docente> docentes=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="CALL sp_docente_buscar_por_nombre_completo(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, nombreCompleto);
            
            bitacora.info("Búsqueda de Docente por Nombre Completo");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                docente=new Docente();
                docente.setIdMiembro(rs.getInt("docente_id"));
                docente.setDni(rs.getString("dni"));
                docente.setNombreCompleto(rs.getString("nombre_completo"));
                docente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                docente.setGenero(rs.getString("genero"));
                docente.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                docente.setGradoAcademico(rs.getString("grado_academico"));
                docente.setEspecialidadAcademica(rs.getString("especialidad_academica")); 
                docentes.add(docente);
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return docentes;
    }
    
    public Docente buscarDatosParaEmail(int id) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Docente docente=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_buscar_datos_para_email(?)";
            stat=con.prepareCall(proc);
            stat.setInt(1, id);
            
            bitacora.info("Búsqueda de datos de Docente para Correo Electrónico");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                docente=new Docente();
                docente.setIdMiembro(rs.getInt("docente_id"));
                docente.setDni(rs.getString("dni"));
                docente.setNombreCompleto(rs.getString("nombre_completo"));
                
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return docente;
    }
    
    public void eliminar(int id) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_eliminar(?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, id);
            
            bitacora.info("Eliminación de Docente");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-004");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-004")){
                bitacora.severe("E-004: No se eliminó ningún docente");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-004: No se eliminó ningún docente");
            }
           
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void actualizar (Docente docente) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_actualizar(?,?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, docente.getIdMiembro());
            stat.setString(2, docente.getDni());
            stat.setString(3, docente.getNombre());
            stat.setString(4, docente.getApellidoPaterno());
            stat.setString(5, docente.getApellidoMaterno());
            stat.setDate(6, new java.sql.Date(docente.getFechaNacimiento().getTime()));
            stat.setString(7, docente.getGenero());
            stat.setString(8, docente.getNumeroTelefonico());
            stat.setString(9, docente.getGradoAcademico());
            stat.setString(10, docente.getEspecialidadAcademica());
            
            bitacora.info("Actualización de Docente");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<0){
                throw new Exception("E-005");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-005")){
                bitacora.severe("E-005: No se pudo actualizar al Docente");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-005: No se pudo actualizar al Docente");
            }
            
            if(e.getMessage().contains("idx_docente_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_docente_numero_telefonico")){
                bitacora.severe("E-003: El numero telefonico ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: El numero telefonico ingresado ya existe en la base de datos");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
}
