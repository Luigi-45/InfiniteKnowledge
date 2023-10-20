/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.DocenteDAO;
import DataTransferObject.Docente;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0312
 */
public class DocenteBO {
    
    public void insertar(Docente docente)throws Exception{
        
        try {
            DocenteDAO docenteDAO=new DocenteDAO();
            docenteDAO.insertar(docente);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Docente buscarPorDNI(String dni)throws Exception{
        
        try {
            Docente docente=new Docente();
            DocenteDAO docenteDAO=new DocenteDAO();
            docente=docenteDAO.buscarPorDNI(dni);
            return docente;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<Docente> buscar_por_nombre_completo(String cadena)throws Exception{
        
        try {
            ArrayList<Docente> docentes=new ArrayList<>();
            DocenteDAO docenteDAO=new DocenteDAO();
            docentes=docenteDAO.buscar_por_nombre_completo(cadena);
            return docentes;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Docente buscarDatosParaEmail(int id)throws Exception{
        
        try {
            Docente docente=new Docente();
            DocenteDAO docenteDAO=new DocenteDAO();
            docente=docenteDAO.buscarDatosParaEmail(id);
            return docente;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void eliminar(int id)throws Exception{
        
        try {
            DocenteDAO docenteDAO=new DocenteDAO();
            docenteDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void actualizar(Docente docente)throws Exception{
        
        try {
            DocenteDAO docenteDAO=new DocenteDAO();
            docenteDAO.actualizar(docente);
        } catch (Exception e) {
            throw e;
        }    
    }
    
}
