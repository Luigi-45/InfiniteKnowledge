/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Connection.UConnection;
import static DataAccessLayer.UsuarioDAO.bitacora;
import DataTransferObject.AuxiliarAcademico;
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
public class AuxiliarAcademicoDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.AuxiliarAcademicoDAO", "bitacoraAuxiliarAcademico.txt", Level.FINE,false,false);
    
    public void insertar(AuxiliarAcademico auxiliar) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_insertar(?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, auxiliar.getDni());
            stat.setString(2, auxiliar.getNombre());
            stat.setString(3, auxiliar.getApellidoPaterno());
            stat.setString(4, auxiliar.getApellidoMaterno());
            stat.setDate(5, new java.sql.Date(auxiliar.getFechaNacimiento().getTime()));
            stat.setInt(6, auxiliar.getnDocentesACargo());
            stat.setString(7, auxiliar.getGenero());
            stat.setString(8, auxiliar.getNumeroTelefonico());
            stat.setString(9, auxiliar.getGradoAcademico());
            
            bitacora.info("Registro de Auxiliar Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al auxiliar académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al auxiliar academico");
            }
            if(e.getMessage().contains("idx_auxiliar_academico_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_auxiliar_academico_numero_telefonico")){
                bitacora.severe("E-003: El numero telefonico ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: El numero telefonico ingresado ya existe en la base de datos");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public ArrayList<AuxiliarAcademico> listar() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        ArrayList<AuxiliarAcademico> auxiliaresListados = new  ArrayList<AuxiliarAcademico>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_listar()";
            stat=con.prepareCall(proc);
            
            bitacora.info("Listado de Auxiliar Académico");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                AuxiliarAcademico auxiliar=new AuxiliarAcademico();
                auxiliar.setIdMiembro(rs.getInt("auxiliar_academico_id"));
                auxiliar.setDni(rs.getString("dni"));
                auxiliar.setNombre(rs.getString("nombre"));
                auxiliar.setApellidoPaterno(rs.getString("apellido_paterno"));
                auxiliar.setApellidoMaterno(rs.getString("apellido_materno"));
                auxiliar.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                auxiliar.setnDocentesACargo(rs.getString("n_docentes_a_cargo"));
                auxiliar.setGenero(rs.getString("genero"));
                auxiliar.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                auxiliar.setGradoAcademico(rs.getString("grado_academico"));
                auxiliar.setNombreCompleto(rs.getString("nombre_completo"));
                
                auxiliaresListados.add(auxiliar);
            }
            
          
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return auxiliaresListados;
    }
    
    public AuxiliarAcademico buscarPorDNI(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        AuxiliarAcademico auxiliar=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_buscar_por_dni(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Búsqueda de Auxiliar Académico por DNI");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                auxiliar=new AuxiliarAcademico();
                auxiliar.setIdMiembro(rs.getInt("auxiliar_academico_id"));
                auxiliar.setDni(rs.getString("dni"));
                auxiliar.setNombre(rs.getString("nombre"));
                auxiliar.setApellidoPaterno(rs.getString("apellido_paterno"));
                auxiliar.setApellidoMaterno(rs.getString("apellido_materno"));
                auxiliar.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                auxiliar.setnDocentesACargo(rs.getString("n_docentes_a_cargo"));
                auxiliar.setGenero(rs.getString("genero"));
                auxiliar.setNumeroTelefonico(rs.getString("numero_telefonico"));  
                auxiliar.setGradoAcademico(rs.getString("grado_academico"));
                auxiliar.setNombreCompleto(rs.getString("nombre_completo"));
            }
           
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return auxiliar;
    }
    
    
    
    public AuxiliarAcademico buscarDatosParaEmail(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        AuxiliarAcademico auxiliar=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_buscar_datos_para_email(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Búsqueda de datos de Auxiliar Académico para Email");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                auxiliar=new AuxiliarAcademico();
                auxiliar.setIdMiembro(rs.getInt("auxiliar_academico_id"));
                auxiliar.setDni(rs.getString("dni"));
                auxiliar.setNombreCompleto(rs.getString("nombre_completo"));
            }
          
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return auxiliar;
    }
    
    
    
    public void eliminar(int auxiliarAcademicoId) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_eliminar(?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, auxiliarAcademicoId);
            
            bitacora.info("Eliminación de Auxiliar Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-004");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-004")){
                bitacora.severe("E-004: No se pudo eliminar al auxiliar académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-004: No se pudo eliminar al auxiliar académico");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void actualizar (AuxiliarAcademico auxiliar) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_auxiliar_academico_actualizar(?,?,?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, auxiliar.getIdMiembro());
            stat.setString(2, auxiliar.getDni());
            stat.setString(3, auxiliar.getNombre());
            stat.setString(4, auxiliar.getApellidoPaterno());
            stat.setString(5, auxiliar.getApellidoMaterno());
            stat.setDate(6, new java.sql.Date(auxiliar.getFechaNacimiento().getTime()));
            stat.setInt(7, auxiliar.getnDocentesACargo());
            stat.setString(8, auxiliar.getGenero());
            stat.setString(9, auxiliar.getNumeroTelefonico());
            stat.setString(10, auxiliar.getGradoAcademico());
            
            bitacora.info("Actualización de Auxiliar Académico");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-005");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-005")){
                bitacora.severe("E-005: No se pudo actualizar al auxiliar académico");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-005: No se pudo actualizar al auxiliar académico");
            }
            
            if(e.getMessage().contains("idx_auxiliar_academico_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_auxiliar_academico_numero_telefonico")){
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
