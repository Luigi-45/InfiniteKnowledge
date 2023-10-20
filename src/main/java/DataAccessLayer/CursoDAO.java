/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.UConnection;
import static DataAccessLayer.AuxiliarAcademicoDAO.bitacora;
import DataTransferObject.Curso;
import Utilities.Bitacora.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASRock™ Gaming 
 */
public class CursoDAO {
 
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.CursoDAO", "bitacoraCurso.txt", Level.FINE,false,false);
    
    public void insertar(Curso curso) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_insertar(?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, curso.getNombre());
            stat.setInt(2, curso.getnHoras());
            stat.setString(3, curso.getEnfoqueCurso());
     
            bitacora.info("Registro de Curso");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al curso");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al curso");
            }
            
            if(e.getMessage().contains("idx_curso_nombre")){
                bitacora.severe("E-002: El nombre del curso ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El nombre del curso ingresado ya existe en la base de datos");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public void insertarParaDocente(int docenteId, int cursoId) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_curso_insertar(?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, docenteId);
            stat.setInt(2, cursoId);
     
            bitacora.info("Registro de Curso para Docente");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-003");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-003")){
                bitacora.severe("E-003: No se pudo registar al curso para el docente");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: No se pudo registar al curso para el docente");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
     
     public ArrayList<Curso> buscarPorNombre(String nombre) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Curso curso=null;
        ArrayList<Curso> cursos = new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_buscar_por_nombre(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, nombre);
            
            bitacora.info("Búsqueda de cursos por nombre");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                curso=new Curso();
                curso.setCursoId(rs.getInt("curso_id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setnHoras(rs.getString("n_horas_por_semana"));
                curso.setEnfoqueCurso(rs.getString("enfoque"));
                cursos.add(curso);
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return cursos;

    }
     
    public Curso buscarPorNombreExacto(String nombre) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Curso curso=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_buscar_por_nombre_exacto(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, nombre);
            
            bitacora.info("Búsqueda de cursos por nombre exacto");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                curso=new Curso();
                curso.setCursoId(rs.getInt("curso_id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setnHoras(rs.getString("n_horas_por_semana"));
                curso.setEnfoqueCurso(rs.getString("enfoque"));
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return curso;

    } 
     
     public ArrayList<Curso> listar() throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Curso curso=null;
        ArrayList<Curso> cursos=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_listar()";
            stat=con.prepareCall(proc);
            
            bitacora.info("Listado de cursos");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                curso=new Curso();
                curso.setCursoId(rs.getInt("curso_id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setnHoras(rs.getString("n_horas_por_semana"));
                curso.setEnfoqueCurso(rs.getString("enfoque"));
                cursos.add(curso);
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return cursos;
    }
     
     public ArrayList<Curso> listarCursosParaDocente(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Curso curso=null;
        
        ArrayList<Integer> cursosId = new ArrayList<>();
        ArrayList<Curso> cursos=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_docente_curso_listar_para_docente(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Listado de cursos para docente");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                cursosId.add(rs.getInt("curso_id")); 
            }
            
            for(int i:cursosId){
                proc="call sp_curso_buscar_por_id(?)";
                stat=con.prepareCall(proc);
                stat.setInt(1, i);
                rs=stat.executeQuery();
                
                while (rs.next()) {
                    curso=new Curso();
                    curso.setCursoId(rs.getInt("curso_id"));
                    curso.setNombre(rs.getString("nombre"));
                    curso.setnHoras(rs.getString("n_horas_por_semana"));
                    curso.setEnfoqueCurso(rs.getString("enfoque"));
                    cursos.add(curso);
                }
            }
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return cursos;
    } 
     
     public ArrayList<Curso> listarNombresPorDniEstudiante(String dni) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Curso curso=null;
        ArrayList<Curso> cursos=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_listar_nombres_por_dni_estudiante(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, dni);
            
            bitacora.info("Listado de cursos por DNI de Estudiante");
            rs=stat.executeQuery();
            
            while (rs.next()) {
                curso=new Curso();
                curso.setCursoId(rs.getInt("curso_id"));
                curso.setNombre(rs.getString("nombre"));
                cursos.add(curso);
            }
           
      
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return cursos;
    }
     
    public void eliminar(int id) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_eliminar(?)";
            
            stat=con.prepareCall(proc);
            stat.setInt(1, id);
            
            bitacora.info("Eliminación de curso");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-004");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-004")){
                bitacora.severe("E-004: No se pudo eliminar al curso");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-004: No se pudo eliminar al curso");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
     
     public void actualizar(Curso curso) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_curso_actualizar(?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setInt(1, curso.getCursoId());
            stat.setString(2, curso.getNombre());
            stat.setInt(3, curso.getnHoras());
            stat.setString(4, curso.getEnfoqueCurso());
            
            
            bitacora.info("Actualización de curso");
            int datos_afectados=stat.executeUpdate();
            if(datos_afectados<=0){
                throw new Exception("E-005");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-005")){
                bitacora.severe("E-005: No se pudo actualizar al curso");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-005: No se pudo actualizar al curso");
            }
            
            if(e.getMessage().contains("idx_curso_nombre")){
                bitacora.severe("E-002: El nombre del curso ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El nombre del curso ingresado ya existe en la base de datos");
            }
            
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
}
