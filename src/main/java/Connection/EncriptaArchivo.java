/* Clase que encripta los datos de conexión y los escribe en archivo de texto
 * utilizando el algoritmo DES.
 * Descargado de www.javawebmas.blogspot.com
 */
package Connection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
//import sun.misc.BASE64Encoder;
import java.util.Base64;
import javax.swing.*;

/**
 *
 * @author Abimael
 */
public class EncriptaArchivo {
    private String servidor = "";
    private int puerto;
    private String bd = "";
    private String usuario = "";
    private String contrasena = "";
    //Variable que guarda la ruta donde se creara el archivo conexion.ini
    private String rutaArchivo = "";
    //Nombre del archivo a crear.
    private String nombreArchivo = "\\NOMBREDESISTEMA1.INI";

    public void setServidor(String servidor) {
        this.servidor = servidor;       
    }

    public String getServidor() {
        return this.servidor;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public int getPuerto() {
        return this.puerto;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getBd() {
        return this.bd;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setContrasena(char contrasena[]) {
        this.contrasena = new String(contrasena);
    }

    public String getContrasena() {
        return this.contrasena;
    }


    public void encriptaDatos() {
        //Arreglo para almacenar las cadenas encriptadas.
        String cadenaEncriptada[] = new String[5];

        /* Crear e inicializar clave */
        String semilla = "dhjlaSG";

        // Generamos una clave secreta.
        SecretKeySpec desKey = new SecretKeySpec(new String((semilla.trim().concat("62364770")).substring(0, 8))
                .getBytes(), "DES");
        //System.out.println("CLAVE:" + new String(desKey.getEncoded()) + "\n");

        try {
            /* Crear cifrador */
            Cipher cifrador = null;
            cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Algoritmo DES
            // Modo : ECB (Electronic Code Book)
            // Relleno : PKCS5Padding

            /* Inicializar cifrador en modo CIFRADO */
            cifrador.init(Cipher.ENCRYPT_MODE, desKey);
            //Cifrando datos de conexión
            byte servidorBytes[] = cifrador.doFinal(servidor.getBytes());
            //Convirtiendo variable port a String.
            byte puertoBytes[] = cifrador.doFinal(String.valueOf(puerto).getBytes()); 
            byte bdBytes[] = cifrador.doFinal(bd.getBytes());
            byte usuarioBytes[] = cifrador.doFinal(usuario.getBytes());
            byte contrasenaBytes[] = cifrador.doFinal(contrasena.getBytes());

            /* La encriptación genera una cadena de bytes, por lo que si se almacena de esta manera
             * en un archivo o una base de datos podria ocacionarnos problemas al momento de leerla.
             * Para evitar dicho problema, utilizamos la codificación BASE64.
             */
           // BASE64Encoder base64 = new BASE64Encoder();
           
           
           
             cadenaEncriptada[0] = Base64.getEncoder().encodeToString(servidorBytes);
            cadenaEncriptada[1] = Base64.getEncoder().encodeToString(puertoBytes);
            cadenaEncriptada[2] = Base64.getEncoder().encodeToString(bdBytes);
            cadenaEncriptada[3] = Base64.getEncoder().encodeToString(usuarioBytes);
            cadenaEncriptada[4] = Base64.getEncoder().encodeToString(contrasenaBytes);
           
           
            /*cadenaEncriptada[0] = base64.encode(servidorBytes);
            cadenaEncriptada[1] = base64.encode(puertoBytes);
            cadenaEncriptada[2] = base64.encode(bdBytes);
            cadenaEncriptada[3] = base64.encode(usuarioBytes);
            cadenaEncriptada[4] = base64.encode(contrasenaBytes);*/

        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        } catch (NoSuchPaddingException noSuchPaddingException) {
        } catch (InvalidKeyException invalidKeyException) {
        } catch (IllegalBlockSizeException illegalBlockSizeException) {
        } catch (BadPaddingException badPaddingException) {
        }

        //Abriendo cuadro de dialogo para elejir la ruta donde se guardara el archivo cifrado.
        JFileChooser dlgGuardar = new JFileChooser();        
        dlgGuardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcion = dlgGuardar.showSaveDialog(null);
        if(opcion == JFileChooser.APPROVE_OPTION) {
            rutaArchivo = dlgGuardar.getSelectedFile().getPath();

            /* Creando archivo */
            try {
                FileWriter fw = new FileWriter(rutaArchivo + nombreArchivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salida = new PrintWriter(bw);

                //Escribiendo en el archivo los datos de conexión.
                salida.println("[CONFIGURACION]");
                salida.println("Server=" + cadenaEncriptada[0]);
                salida.println("Port=" + cadenaEncriptada[1]);
                salida.println("Database=" + cadenaEncriptada[2]);
                salida.println("User=" + cadenaEncriptada[3]);
                salida.println("Password=" + cadenaEncriptada[4]);
                salida.close();
                JOptionPane.showMessageDialog(null, "El archivo " + rutaArchivo+nombreArchivo +
                        " se creo correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error de entrada o salida.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }

