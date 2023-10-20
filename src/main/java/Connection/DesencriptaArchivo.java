/*
 * Descargado de www.javawebmas.blogspot.com
 * Clase que desencripta los datos de conexión almacenados en archivo de texto
 * utilizando el algoritmo DES.
 */

package Connection;
//import com.conexion.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;
//import sun.misc.BASE64Decoder;
//import java.util.Base64;
import javax.swing.JOptionPane;

/**
 *
 * @author Abimael
 */
public class DesencriptaArchivo {
    private String servidor = "";
    private int puerto;
    private String bd = "";
    private String usuario = "";
    private String contrasena = "";
    //Nombre del archivo que contiene los datos de conexión.
    private String nombreArchivo = "\\src\\main\\resources\\NOMBREDESISTEMA1.INI";

    public String getServidor() {
        return this.servidor;
    }

    public int getPuerto() {
        return this.puerto;
    }

    public String getBd() {
        return this.bd;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    /**
     * Lee y desencripta los datos de conexión a la base de datos que se encuentran
     * en un archivo de texto.
     */
    public void desencriptaDatos() {
        Cipher cifrador = null;

        /* PASO 1: Crear e inicializar clave */
        String semilla = "dhjlaSG";

        // Generamos una clave secreta.
        SecretKeySpec desKey = new SecretKeySpec(new String((semilla.trim().concat("62364770")).substring(0, 8))
                .getBytes(), "DES");
        //System.out.println("CLAVE:" + new String(desKey.getEncoded()) + "\n");

        try {
            /* PASO 2: Crear cifrador */
            cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Algoritmo DES
            // Modo : ECB (Electronic Code Book)
            // Relleno : PKCS5Padding

            /* PASO 3: Poner cifrador en modo DESCIFRADO */
            cifrador.init(Cipher.DECRYPT_MODE, desKey);

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        } catch (NoSuchPaddingException noSuchPaddingException) {
        } catch (InvalidKeyException invalidKeyException) {
        }

        /* PASO 4: Leer archivo en el cual estan guardados los datos de conexión. */
        File f = new File(System.getProperty("user.dir") + nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String fila, cadena;
            String cadenaDesencriptada[] = new String[6];

            int i=0;
            while((fila = br.readLine()) != null) {
                //Si el caracter "=" esta en alguna posición de la cadena leida entra al IF.
                if(fila.indexOf("=") != -1) {
                    int inicio = fila.indexOf("=");
                    int t_cadena = fila.length();
                    //Toma sólo los datos encriptados de la cadena.
                    cadena = fila.substring(inicio+1, t_cadena);
                   // byte cadenaDesencriptadaBytes[] = new BASE64Decoder().decodeBuffer(cadena);
                    byte cadenaDesencriptadaBytes[] = Base64.getDecoder().decode(cadena);
                    cadenaDesencriptada[i] = new String(cifrador.doFinal(cadenaDesencriptadaBytes));
                }
                i++;
            }

            //Se comienza a leer el arreglo apartir de 1 y no de 0 porque la primera
            //linea del archivo es un comentario "[CONFIGURACION]".
            this.servidor = cadenaDesencriptada[1];
            this.puerto = Integer.parseInt(cadenaDesencriptada[2]);
            this.bd = cadenaDesencriptada[3];
            this.usuario = cadenaDesencriptada[4];
            this.contrasena = cadenaDesencriptada[5];
            
            
//            System.out.println(this.servidor);
//            System.out.println(this.puerto);
//            System.out.println(this.bd);
//            System.out.println(this.usuario);
//            System.out.println(this.contrasena);
            
            
            br.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de archivo .INI", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
