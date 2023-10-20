/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.UConnection;
import static DataAccessLayer.CursoDAO.bitacora;
import DataTransferObject.DirectorAcademico;
import Utilities.Bitacora.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASRock™ Gaming k4
 */
public class DirectorAcademicoDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.DirectorAcademicoDAO", "bitacoraDirectorAcademico.txt", Level.FINE,false,false);
    
    public void insertar(DirectorAcademico director) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_insertar(?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, director.getDni());
            stat.setString(2, director.getNombre());
            stat.setString(3, director.getApellidoPaterno());
            stat.setString(4, director.getApellidoMaterno());
            stat.setDate(5, new java.sql.Date(director.getFechaNacimiento().getTime()));
            stat.setInt(6, director.getAniosLabor());
            stat.setString(7, director.getGenero());
            stat.setString(8, director.getNumeroTelefonico());
            stat.setString(9, director.getGradoAcademico());
            
            bitacora.info("Registro de Director Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al Director Académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al Director Académico");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public DirectorAcademico buscarPorId() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        DirectorAcademico director=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_buscar_por_id()";
            stat=con.prepareCall(proc);
            
            bitacora.info("Búsqueda de Director Académico");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                director=new DirectorAcademico();
                director.setIdMiembro(rs.getInt("director_academico_id"));
                director.setDni(rs.getString("dni"));
                director.setNombre(rs.getString("nombre"));
                director.setApellidoPaterno(rs.getString("apellido_paterno"));
                director.setApellidoMaterno(rs.getString("apellido_materno"));
                director.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                director.setAniosLabor(rs.getString("anios_labor"));
                director.setGenero(rs.getString("genero"));
                director.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                director.setGradoAcademico(rs.getString("grado_academico"));
                director.setNombreCompleto(rs.getString("nombre_completo"));
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return director;
    }
    
    public DirectorAcademico buscarPorDNI(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        DirectorAcademico director=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_buscar_por_dni(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Búsqueda de Director Académico por DNI");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                director=new DirectorAcademico();
                director.setIdMiembro(rs.getInt("director_academico_id"));
                director.setDni(rs.getString("dni"));
                director.setNombre(rs.getString("nombre"));
                director.setApellidoPaterno(rs.getString("apellido_paterno"));
                director.setApellidoMaterno(rs.getString("apellido_materno"));
                director.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                director.setAniosLabor(rs.getString("anios_labor"));
                director.setGenero(rs.getString("genero"));
                director.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                director.setGradoAcademico(rs.getString("grado_academico"));
                director.setNombreCompleto(rs.getString("nombre_completo"));
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return director;
    }
    
    
    
    public DirectorAcademico buscarDatosParaEmail() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        DirectorAcademico director=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_buscar_datos_para_email()";
            stat=con.prepareCall(proc);
            
            bitacora.info("Búsqueda de datos de Director Académico para Correo Electrónico");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                director=new DirectorAcademico();
                director.setIdMiembro(rs.getInt("director_academico_id"));
                director.setDni(rs.getString("dni"));
                director.setNombreCompleto(rs.getString("nombre_completo"));
                
            }
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return director;
    }
    
    public String buscar_nombre_completo() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        String NombreCompleto="";
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_buscar_nombre_completo()";
            stat=con.prepareCall(proc);
            
            bitacora.info("Búsqueda de nombre completo de  Director Académico");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                NombreCompleto=rs.getString("nombre_completo");      
            }
           
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return NombreCompleto;
    }
    
    public void eliminar() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_eliminar()";
            
            stat=con.prepareCall(proc);
            
            bitacora.info("Eliminación de Director Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-002");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-002")){
                bitacora.severe("E-002: No se pudo eliminar al Director Académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: No se pudo eliminar al Director Académico");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void actualizar (DirectorAcademico director) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_director_academico_actualizar(?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, director.getDni());
            stat.setString(2, director.getNombre());
            stat.setString(3, director.getApellidoPaterno());
            stat.setString(4, director.getApellidoMaterno());
            stat.setDate(5, new java.sql.Date(director.getFechaNacimiento().getTime()));
            stat.setInt(6, director.getAniosLabor());
            stat.setString(7, director.getGenero());
            stat.setString(8, director.getNumeroTelefonico());
            stat.setString(9, director.getGradoAcademico());
            
            bitacora.info("Actualización de Director Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<0){
                throw new Exception("E-003");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-003")){
                bitacora.severe("E-003: No se pudo actualizar al Director Académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: No se pudo actualizar al Director Académico");
            }

            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
}
