/*
 * GenerarIni.java
 * Descargado de www.javawebmas.blogspot.com
 * Created on 21/05/2011, 11:58:33 PM
 */

package Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Abimael
 */
public class GenerarIni extends javax.swing.JFrame {

    

    
    
    
    /** Creates new form GenerarIni */
    public GenerarIni() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        txtBd = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnProbar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GENERAR ARCHIVO INI ENCRIPTADO");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de conexión"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Servidor:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 27, -1, -1));

        jLabel2.setText("Base de Datos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 61, -1, -1));

        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 93, -1, -1));

        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 124, -1, -1));

        txtServidor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtServidorKeyPressed(evt);
            }
        });
        jPanel1.add(txtServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 27, 202, -1));

        txtBd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBdKeyPressed(evt);
            }
        });
        jPanel1.add(txtBd, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 58, 202, -1));

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 90, 202, -1));

        jLabel5.setText("Puerto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 30, -1, -1));

        txtPuerto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPuertoKeyPressed(evt);
            }
        });
        jPanel1.add(txtPuerto, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 27, 47, -1));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 121, 202, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar);
        btnAceptar.setBounds(340, 10, 101, 30);

        btnProbar.setMnemonic('P');
        btnProbar.setText("Probar");
        btnProbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbarActionPerformed(evt);
            }
        });
        jPanel2.add(btnProbar);
        btnProbar.setBounds(220, 10, 101, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(490, 293));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Si todos los cuadros de texto estan correctamente capturados entra al if.
        if(validaFormulario()) {
            /* Creando objeto para encriptar los datos capturados en el formulario. */
            EncriptaArchivo encrip = new EncriptaArchivo();
            encrip.setServidor(txtServidor.getText());
            encrip.setPuerto(Integer.parseInt(txtPuerto.getText()));
            encrip.setBd(txtBd.getText());
            encrip.setUsuario(txtUsuario.getText());
            encrip.setContrasena(txtContrasena.getPassword());
            encrip.encriptaDatos();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnProbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbarActionPerformed
        //Si todos los cuadros de texto estan correctamente capturados entra al if.
        DesencriptaArchivo da = new DesencriptaArchivo();
        da.desencriptaDatos();
        this.txtServidor.setText(da.getServidor());
        this.txtPuerto.setText(String.valueOf(da.getPuerto()));
        this.txtBd.setText(da.getBd());
        this.txtUsuario.setText(da.getUsuario());
        this.txtContrasena.setText(da.getContrasena());
    }//GEN-LAST:event_btnProbarActionPerformed

    private void txtServidorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServidorKeyPressed
        if(evt.getKeyCode() == '\n')
            txtPuerto.requestFocus();
    }//GEN-LAST:event_txtServidorKeyPressed

    private void txtPuertoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertoKeyPressed
        if(evt.getKeyCode() == '\n')
            txtBd.requestFocus();
    }//GEN-LAST:event_txtPuertoKeyPressed

    private void txtBdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBdKeyPressed
        if(evt.getKeyCode() == '\n')
            txtUsuario.requestFocus();
    }//GEN-LAST:event_txtBdKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if(evt.getKeyCode() == '\n')
            txtContrasena.requestFocus();
    }//GEN-LAST:event_txtUsuarioKeyPressed

    /* Validando el texto introducido en el formulario GeneraIni. */
    private boolean validaFormulario() {
        if(txtServidor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Escriba el nombre del Host o la dirección IP de la instancia del servidor MySql.");
            txtServidor.requestFocus();
            return false;

        } else if(txtPuerto.getText().equals("") || !(txtPuerto.getText().matches("[0-9]*"))) {
            JOptionPane.showMessageDialog(this, "Escriba el número del puerto . Solo puede contener números.");
            txtPuerto.requestFocus();
            return false;

        } else if(txtBd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Escriba el nombre de la Base de datos para la instancia MySql.");
            txtBd.requestFocus();
            return false;

        } else if(txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Escriba el nombre del usuario MySql.");
            txtUsuario.requestFocus();
            return false;

        } else if(new String(txtContrasena.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Escriba la contraseña del usuario MySql.");           
            txtContrasena.requestFocus();
            return false;
        }
        return true;
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
                //Cambiando la apariencia de la aplicación a plataforma Windows.
                System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                new GenerarIni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnProbar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBd;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtServidor;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
