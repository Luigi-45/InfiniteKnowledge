/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.DirectorAcademicoDAO;
import DataTransferObject.DirectorAcademico;

/**
 *
 * @author LAB-USR-HUAN-A0312
 */
public class DirectorAcademicoBO {
    
    public void insertar(DirectorAcademico director)throws Exception{
        
        try {
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();
            directorDAO.insertar(director);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public DirectorAcademico buscarPorId()throws Exception{
        
        try {
            DirectorAcademico director=new DirectorAcademico();
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();;
            director=directorDAO.buscarPorId();
            return director;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public DirectorAcademico buscarPorDNI(String dni)throws Exception{
        
        try {
            DirectorAcademico director=new DirectorAcademico();
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();;
            director=directorDAO.buscarPorDNI(dni);
            return director;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public DirectorAcademico buscarDatosParaEmail()throws Exception{
        
        try {
            DirectorAcademico director=new DirectorAcademico();
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();;
            director=directorDAO.buscarDatosParaEmail();
            return director;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public String buscar_nombre_completo()throws Exception{
        
        try {
            String nombre;
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();;
            nombre=directorDAO.buscar_nombre_completo();
            return nombre;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void eliminar()throws Exception{
        
        try {
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();
            directorDAO.eliminar();
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void actualizar(DirectorAcademico director)throws Exception{
        
        try {
            DirectorAcademicoDAO directorDAO=new DirectorAcademicoDAO();
            directorDAO.actualizar(director);
        } catch (Exception e) {
            throw e;
        }    
    }
    
}
