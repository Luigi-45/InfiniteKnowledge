/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.AuxiliarAcademicoDAO;
import DataTransferObject.AuxiliarAcademico;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0312
 */
public class AuxiliarAcademicoBO {
    
    public void insertar(AuxiliarAcademico auxiliar)throws Exception{
        
        try {
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliarDAO.insertar(auxiliar);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public AuxiliarAcademico buscarPorDNI(String dni)throws Exception{
        
        try {
            AuxiliarAcademico auxiliar=new AuxiliarAcademico();
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliar=auxiliarDAO.buscarPorDNI(dni);
            return auxiliar;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public AuxiliarAcademico buscarDatosParaEmail(String dni)throws Exception{
        
        try {
            AuxiliarAcademico auxiliar=new AuxiliarAcademico();
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliar=auxiliarDAO.buscarPorDNI(dni);
            return auxiliar;
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void eliminar(int id)throws Exception{
        
        try {
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliarDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public void actualizar(AuxiliarAcademico auxiliar)throws Exception{
        
        try {
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliarDAO.actualizar(auxiliar);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public ArrayList<AuxiliarAcademico> listar()throws Exception{
        
        try {
            ArrayList<AuxiliarAcademico> auxiliares=new ArrayList<>();
            AuxiliarAcademicoDAO auxiliarDAO=new AuxiliarAcademicoDAO();
            auxiliares=auxiliarDAO.listar();
            return auxiliares;
        } catch (Exception e) {
            throw e;
        }    
    }
    
}
