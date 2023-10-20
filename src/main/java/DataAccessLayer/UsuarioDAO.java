/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import Connection.UConnection;
import DataTransferObject.Usuario;
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
public class UsuarioDAO {
    
    static Logger bitacora = Bitacora.getBitacora("DataAccessLayer.UsuarioDAO", "bitacoraUsuario.txt", Level.FINE,false,false);
    
    public void insertar(Usuario usuario) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_usuario_insertar(?,?,?,?)";
            
            stat=con.prepareCall(proc);
            
            stat.setString(1, usuario.getDni());
            stat.setString(2, usuario.getCorreoElectronico());
            stat.setString(3, usuario.getContraseniaSV());
            stat.setInt(4, usuario.getRol());
            
            
            bitacora.info("Registro de usuario");
            int datos_afectados=stat.executeUpdate();
            
            if(datos_afectados<=0){
                throw new Exception("E-001");
            }
            
            
        } catch (Exception e) {
            if(e.getMessage().contains("E-001")){
                bitacora.severe("E-001: No se pudo registar al usuario");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-001: No se pudo registar al usuario");
            }
            if(e.getMessage().contains("idx_usuario_correo_electronico")){
                bitacora.severe("E-002: El correo electronico ingresado ya existe en la base de datos");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-002: El correo electronico ingresado ya existe en la base de datos");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(stat!=null)stat.close();
        } 
    }
    
    public Usuario realizarInicioDeSesion(String correo) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        Usuario usuario=null;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_usuario_realizar_inicio_de_sesión(?)";
            stat=con.prepareCall(proc);
            stat.setString(1, correo);
            
            bitacora.info("Inicio de Sesión");
            
            rs=stat.executeQuery();
            
            while (rs.next()) {
                usuario=new Usuario();
                usuario.setUsuarioId(rs.getInt("usuario_id"));
                usuario.setDni(rs.getString("dni"));
                usuario.setCorreoElectronico(correo);
                usuario.setContraseniaSV(rs.getString("contrasenia"));
                usuario.setRol(String.valueOf(rs.getInt("rol")));
            }
      
            if(usuario==null){
                throw new Exception("E-003");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("E-003")){
                bitacora.severe("E-003: No se pudo encontrar al usuario");
                bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
                throw new Exception("E-003: No se pudo encontrar al usuario");
            }
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        } 
        return usuario;

    }
    
    public int contarUsuariosRol(int rol) throws Exception{
        
        Connection con=null;
        CallableStatement stat=null;
        ResultSet rs=null;
        int numero=0;
        
        try {
            con=UConnection.getConnection();
            String proc="call sp_usuario_contar_usuarios_por_rol(?)";
            stat=con.prepareCall(proc);
            stat.setInt(1, rol);
            rs=stat.executeQuery();
            
            while (rs.next()) { 
                numero=rs.getInt("cantidad");
            }
          
        } catch (Exception e) {
            bitacora.severe("Error crítico. Comuníquese con el administrador del Sistema");
            throw new Exception("Error crítico. Comuníquese con el administrador del Sistema");
            
        }finally{
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
        }
        return numero;
    }
}