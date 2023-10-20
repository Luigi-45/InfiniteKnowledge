/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.CursoDAO;
import DataTransferObject.Curso;
import java.util.ArrayList;

/**
 *
 * @author ASRock™ Gaming k4
 */
public class CursoBO {
    
    public void insertar(Curso curso)throws Exception{
        
        try {
            CursoDAO cursoDAO=new CursoDAO();
            cursoDAO.insertar(curso);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void insertarParaDocente(int docenteId, int cursoId)throws Exception{
        
        try {
            CursoDAO cursoDAO=new CursoDAO();
            cursoDAO.insertarParaDocente(docenteId,cursoId);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<Curso> buscarPorNombre(String nombre)throws Exception{
        
        try {
            ArrayList<Curso> cursos=new ArrayList<>();
            CursoDAO cursoDAO=new CursoDAO();
            cursos=cursoDAO.buscarPorNombre(nombre);
            return cursos;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Curso buscarPorNombreExacto(String nombre)throws Exception{
        
        try {
            Curso curso=new Curso();
            CursoDAO cursoDAO=new CursoDAO();
            curso=cursoDAO.buscarPorNombreExacto(nombre);
            return curso;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<Curso> listar() throws Exception{
        try {
           ArrayList<Curso> cursos=new ArrayList<>();
            CursoDAO cursoDAO=new CursoDAO(); 
            cursos=cursoDAO.listar();
            return cursos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Curso> listarCursosParaDocente(String dni) throws Exception{
        try {
           ArrayList<Curso> cursos=new ArrayList<>();
            CursoDAO cursoDAO=new CursoDAO(); 
            cursos=cursoDAO.listarCursosParaDocente(dni);
            return cursos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Curso> listarNombresPorDniEstudiante(String dni) throws Exception{
        try {
           ArrayList<Curso> cursos=new ArrayList<>();
            CursoDAO cursoDAO=new CursoDAO(); 
            cursos=cursoDAO.listarNombresPorDniEstudiante(dni);
            return cursos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int id)throws Exception{
        
        try {
            CursoDAO cursoDAO=new CursoDAO();
            cursoDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void actualizar(Curso curso)throws Exception{
        
        try {
            CursoDAO cursoDAO=new CursoDAO();
            cursoDAO.actualizar(curso);
        } catch (Exception e) {
            throw e;
        }    
    }
    
}
