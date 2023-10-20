/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author walter
 */

public class UConnection{
    
 private static Connection con=null;    
 
 //=================================================================
    public static Connection getConnection() throws Exception{
        
        DesencriptaArchivo des = new DesencriptaArchivo();        
        des.desencriptaDatos();        
    
        try {            
            if(con==null){          
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());           
                String url="jdbc:mysql://" + des.getServidor() + ":" + des.getPuerto() + "/" + des.getBd();
                String pwd=des.getContrasena();
                String usr=des.getUsuario();         
                con=DriverManager.getConnection(url,usr,pwd);            
            }            
            return con;            
        } catch (Exception e) {           
            throw e;            
        }    
    
    }
            
}
//=================================================================
  class MiShDwnHook extends Thread
  {
    public void run(){    
        try {
            Connection con=UConnection.getConnection();
            con.close();
        } catch (Exception e) {            
            throw new RuntimeException(e);            
        }
    }
 //=================================================================   

}

