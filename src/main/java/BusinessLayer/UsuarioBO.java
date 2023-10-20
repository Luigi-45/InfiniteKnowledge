/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.UsuarioDAO;
import DataTransferObject.Usuario;

/**
 *
 * @author LAB-USR-HUAN-A0312
 */
public class UsuarioBO {
 
    public void insertar(Usuario usuario)throws Exception{
        
        try {
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            usuarioDAO.insertar(usuario);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Usuario inicioDeSesion(String correo) throws Exception{
        
        try {
            Usuario usuario=new Usuario();
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            usuario=usuarioDAO.realizarInicioDeSesion(correo);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int contarUsuariosRol(int rol) throws Exception{
        
         try {
            int numero=0;
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            numero=usuarioDAO.contarUsuariosRol(rol);
            return numero;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
