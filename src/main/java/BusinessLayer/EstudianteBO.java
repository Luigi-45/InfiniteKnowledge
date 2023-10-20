/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.EstudianteDAO;
import DataTransferObject.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0312
 */
public class EstudianteBO {
    
    public void insertar(Estudiante estudiante)throws Exception{
        
        try {
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudianteDAO.insertar(estudiante);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Estudiante buscar_por_dni(String dni)throws Exception{
        
        try {
            Estudiante estudiante=new Estudiante();
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudiante=estudianteDAO.buscar_por_dni(dni);
            return estudiante;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<Estudiante> buscar_por_nombre_completo(String cadena)throws Exception{
        
        try {
            ArrayList<Estudiante> estudiantes=new ArrayList<>();
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudiantes=estudianteDAO.buscar_por_nombre_completo(cadena);
            return estudiantes;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<Estudiante> listarParaDocente(String dni)throws Exception{
        
        try {
            ArrayList<Estudiante> estudiantes=new ArrayList<>();
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudiantes=estudianteDAO.listarParaDocente(dni);
            return estudiantes;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void eliminar(int id)throws Exception{
        
        try {
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudianteDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void actualizar(Estudiante estudiante)throws Exception{
        
        try {
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudianteDAO.actualizar(estudiante);
        } catch (Exception e) {
            throw e;
        }    
    }
}
