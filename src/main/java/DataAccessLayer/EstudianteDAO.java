/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;
import Connection.UConnection;
import static DataAccessLayer.DocenteDAO.bitacora;
import DataTransferObject.Estudiante;
import Utilities.Bitacora.Bitacora;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASRock™ Gaming k4
 */
public class EstudianteDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.EstudianteDAO", "bitacoraEstudiante.txt", Level.FINE,false,false);
    
    public void insertar(Estudiante estudiante) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_insertar(?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, estudiante.getDni());
            stat.setString(2, estudiante.getNombre());
            stat.setString(3, estudiante.getApellidoPaterno());
            stat.setString(4, estudiante.getApellidoMaterno());
            stat.setDate(5, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
            stat.setString(6, estudiante.getGenero());
            stat.setString(7, estudiante.getNumeroTelefonico());
            
            bitacora.info("Registro de Estudiante");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al Estudiante");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al Estudiante");
            }
            if(e.getMessage().contains("idx_estudiante_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_estudiante_numero_telefonico")){
                bitacora.severe("E-003: El numero telefonico ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: El numero telefonico ingresado ya existe en la base de datos");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public Estudiante buscar_por_dni(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Estudiante estudiante=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_buscar_por_dni(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Búsqueda de Estudiante por DNI");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                estudiante=new Estudiante();
                estudiante.setIdMiembro(rs.getInt("estudiante_id"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidoPaterno(rs.getString("apellido_paterno"));
                estudiante.setApellidoMaterno(rs.getString("apellido_materno"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                estudiante.setGenero(rs.getString("genero"));
                estudiante.setNumeroTelefonico(rs.getString("numero_telefonico"));     
                estudiante.setNombreCompleto(rs.getString("nombre_completo"));
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return estudiante;
    }
    
     public ArrayList<Estudiante> buscar_por_nombre_completo(String nombreCompleto) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Estudiante estudiante=null;
        ArrayList<Estudiante> estudiantes=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_buscar_por_nombre_completo(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, nombreCompleto);
            
            bitacora.info("Búsqueda de Estudiante por Nombre Completo");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                estudiante=new Estudiante();
                estudiante.setIdMiembro(rs.getInt("estudiante_id"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setNombreCompleto(rs.getString("nombre_completo"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                estudiante.setGenero(rs.getString("genero"));
                estudiante.setNumeroTelefonico(rs.getString("numero_telefonico")); 
                estudiantes.add(estudiante);
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return estudiantes;
    }
    
    public ArrayList<Estudiante> listarParaDocente(String dniDocente) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Estudiante estudiante=null;
        ArrayList<Estudiante> estudiantes=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_listar_para_docente(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dniDocente);
            
            bitacora.info("Listado de Estudiante para Docente");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                estudiante=new Estudiante();
                estudiante.setIdMiembro(rs.getInt("estudiante_id"));
                estudiante.setDni(rs.getString("dni"));
                estudiante.setNombreCompleto(rs.getString("nombre_completo"));
                estudiante.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                estudiante.setGenero(rs.getString("genero"));
                estudiante.setNumeroTelefonico(rs.getString("numero_telefonico")); 
                estudiantes.add(estudiante);
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return estudiantes;
    }
    
    public void eliminar(int id) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_eliminar(?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, id);
            
            bitacora.info("Eliminación de Estudiante");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-004");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-004")){
                bitacora.severe("E-004: No se eliminó ningún Estudiante");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-004: No se eliminó ningún Estudiante");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void actualizar(Estudiante estudiante) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_estudiante_actualizar(?,?,?,?,?,?,?,?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, estudiante.getIdMiembro());
            stat.setString(2, estudiante.getDni());
            stat.setString(3, estudiante.getNombre());
            stat.setString(4, estudiante.getApellidoPaterno());
            stat.setString(5, estudiante.getApellidoMaterno());
            stat.setDate(6, new java.sql.Date(estudiante.getFechaNacimiento().getTime()));
            stat.setString(7, estudiante.getGenero());
            stat.setString(8, estudiante.getNumeroTelefonico());
            
            bitacora.info("Actualización de Estudiante");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-005");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-005")){
                bitacora.severe("E-005: No se pudo actualizar al Estudiante");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-005: No se pudo actualizar al Estudiante");
            }
            if(e.getMessage().contains("idx_estudiante_dni")){
                bitacora.severe("E-002: El DNI ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El DNI ingresado ya existe en la base de datos");
            }
            if(e.getMessage().contains("idx_estudiante_numero_telefonico")){
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
