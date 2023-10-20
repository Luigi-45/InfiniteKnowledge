package Utilities.Bitacora;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class Bitacora {
    
    public static Logger getBitacora(){
        return Logger.getGlobal();
    }
    
    public static Logger getBitacora(String paquete, String nombreArcBitacora, Level nivel, boolean delegar){
        return getBitacora(paquete,nombreArcBitacora,nivel,delegar,false);
    }
    
    public static Logger getBitacora(String paquete, String nombreArcBitacora, Level nivel, boolean delegar, boolean enXML){
        Logger bitacora = null;
        bitacora = Logger.getLogger(paquete);
        
        try{
            FileHandler handler = new FileHandler(nombreArcBitacora);
            Formatter formateador = enXML ? new XMLFormatter() : new SimpleFormatter();
            handler.setFormatter(formateador);
            bitacora.addHandler(handler);
        }
        catch(IOException e){
            bitacora = Logger.getGlobal();
            bitacora.severe("Error en la creación de la bitácora" + e.getMessage());
            return bitacora;
        }
        
        bitacora.setLevel(nivel);
        bitacora.setUseParentHandlers(delegar);
        return bitacora;
    }
}
