/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Usuario;

import BusinessLayer.DirectorAcademicoBO;
import BusinessLayer.UsuarioBO;
import DataTransferObject.DirectorAcademico;
import DataTransferObject.Usuario;
import Utilities.BCRYPT.BCryptManagement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Formulario_Director extends javax.swing.JFrame {

    private String codigoMinedu;
    
    public Formulario_Director() {
        initComponents();
        this.codigoMinedu = "e@Di^K81664I";
        cerrar();
    }
    
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void WindowClosing(WindowEvent e){
                    new Seleccion_Rol_Registro().setVisible(true);
                    System.exit(0);
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtDNI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellidoPaterno = new javax.swing.JTextField();
        jtxtApellidoMaterno = new javax.swing.JTextField();
        jtxtNumeroTelefonico = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jtxtCorreoElectronico = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcbGradoAcademico = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jtxtAniosLabor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtxtCodigoMINEDU = new javax.swing.JTextField();
        jcaFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jpContrasenia = new javax.swing.JPasswordField();
        jpContraseniaR = new javax.swing.JPasswordField();

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", " " }));
        jComboBox3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar Director Academico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Colegio_mayor_coar_logo (1) (3).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Colegio de Alto Rendimiento");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Repetir Contraseña :");

        jtxtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDNIKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("DNI :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nombre :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Apellido Paterno :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Apellido Materno :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Número Telefonico :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Género :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Correo Electrónico :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Contraseña :");

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });

        jtxtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidoPaternoKeyTyped(evt);
            }
        });

        jtxtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtApellidoMaternoKeyTyped(evt);
            }
        });

        jtxtNumeroTelefonico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNumeroTelefonicoKeyTyped(evt);
            }
        });

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        jcbGenero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jcbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGeneroActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setMnemonic('r');
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtxtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCorreoElectronicoKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Grado Académico :");

        jcbGradoAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licenciado", "Magister", "Doctor" }));
        jcbGradoAcademico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Años de labor :");

        jtxtAniosLabor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtAniosLaborKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Código MINEDU:");

        jtxtCodigoMINEDU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCodigoMINEDUKeyTyped(evt);
            }
        });

        jpContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpContraseniaKeyTyped(evt);
            }
        });

        jpContraseniaR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpContraseniaRKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(56, 56, 56)
                            .addComponent(jtxtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtNumeroTelefonico, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtxtAniosLabor, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jcbGradoAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcaFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel16)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtCodigoMINEDU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(137, 137, 137)
                                .addComponent(jtxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(43, 43, 43)
                            .addComponent(jpContraseniaR, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtCorreoElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jpContrasenia))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtxtCodigoMINEDU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jcaFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtNumeroTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jtxtAniosLabor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jcbGradoAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpContraseniaR, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            UsuarioBO usuarioBO = new UsuarioBO();
            DirectorAcademicoBO directorAcademicoBO = new DirectorAcademicoBO();
             
            if(this.jtxtCodigoMINEDU.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error, ingrese el código del MINEDU");
            }
            else if(this.jtxtCodigoMINEDU.getText().length()!=12){
                JOptionPane.showMessageDialog(null, "Error, el código del MINEDU ingresado no posee la cantidad de caracteres adecuada");
            }
            else if(!this.jtxtCodigoMINEDU.getText().equals(this.codigoMinedu)){
                JOptionPane.showMessageDialog(null, "Error, el código del MINEDU ingresado no es correcto");
            }
            else if(this.jtxtDNI.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error, ingrese el DNI del Director Académico");
            }
            else if(this.jtxtDNI.getText().length()!=8){
                JOptionPane.showMessageDialog(null, "Error, el DNI del Director Académico ingresado no posee la cantidad de caracteres adecuada (8)");
            }
            else if(this.jtxtNombre.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Error, ingrese el nombre del Director Académioo");
            }
            else if(this.jtxtApellidoPaterno.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Error, ingrese el apellido paterno del Director Académioo");
            }
            else if(this.jtxtApellidoMaterno.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Error, ingrese el apellido materno del Director Académioo");
            }
            else if(this.jcaFechaNacimiento.getDate()==null){
                JOptionPane.showMessageDialog(null, "Error, ingrese la fecha de nacimiento del Director Académioo");
            }
            else if(this.jtxtNumeroTelefonico.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error, ingrese el número telefónico del Director Académico");
            }
            else if(this.jtxtNumeroTelefonico.getText().length()!=9){
                JOptionPane.showMessageDialog(null, "Error, el número telefónico del Director Académico ingresado no posee la cantidad de caracteres adecuada (9)");
            }
            else if(this.jtxtAniosLabor.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error, ingrese los años de labor del Director Académico");
            }
            else if(this.jtxtCorreoElectronico.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error, ingrese el correo electrónico del Director Académico");
            }
            else if(this.jpContrasenia.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Error, ingrese la contraseña del Director Académico");
            }
            else if(this.jpContraseniaR.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Error, ingrese la verificación de la contraseña del Director Académico");
            }
            else if(!this.jpContrasenia.getText().equals(this.jpContraseniaR.getText())){
                JOptionPane.showMessageDialog(null, "Error, las contraseñas no coinciden");
            }
            else if(usuarioBO.contarUsuariosRol(1)>0){
                JOptionPane.showMessageDialog(null, "Error, ya existe un Director Académico registrado");
            }
            else{
                DirectorAcademico directorAcademico = new DirectorAcademico(0,this.jtxtDNI.getText(),this.jtxtNombre.getText(),this.jtxtApellidoPaterno.getText(), 
                this.jtxtApellidoMaterno.getText(),this.jcaFechaNacimiento.getDate(),this.jtxtNumeroTelefonico.getText(),(String) this.jcbGenero.getSelectedItem(),
                this.jtxtAniosLabor.getText(),(String) this.jcbGradoAcademico.getSelectedItem());

                Usuario usuario = new Usuario(0,this.jtxtDNI.getText(),this.jtxtCorreoElectronico.getText(),this.jpContrasenia.getText(),"1");

                usuario.setContraseniaSV(BCryptManagement.encriptarContrasenia(usuario.getContrasenia()));
                usuarioBO.insertar(usuario);
                
                directorAcademicoBO.insertar(directorAcademico);

                JOptionPane.showMessageDialog(null, "Director Académico registrado satisfactoriamente");
                
                new Inicio_de_Sesion().setVisible(true);
                this.dispose();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGeneroActionPerformed

    private void jtxtCodigoMINEDUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoMINEDUKeyTyped
        if(this.jtxtCodigoMINEDU.getText().length()==12) evt.consume();
    }//GEN-LAST:event_jtxtCodigoMINEDUKeyTyped

    private void jtxtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDNIKeyTyped
        char caracter = evt.getKeyChar(); 
        if(((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtDNI.getText().length()==8) evt.consume();
    }//GEN-LAST:event_jtxtDNIKeyTyped

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        char caracter = evt.getKeyChar(); 
        if(!((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtNombre.getText().length()==50) evt.consume();
    }//GEN-LAST:event_jtxtNombreKeyTyped

    private void jtxtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoPaternoKeyTyped
        char caracter = evt.getKeyChar(); 
        if(!((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtApellidoPaterno.getText().length()==50) evt.consume();
    }//GEN-LAST:event_jtxtApellidoPaternoKeyTyped

    private void jtxtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtApellidoMaternoKeyTyped
        char caracter = evt.getKeyChar(); 
        if(!((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtApellidoMaterno.getText().length()==50) evt.consume();
    }//GEN-LAST:event_jtxtApellidoMaternoKeyTyped

    private void jtxtNumeroTelefonicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNumeroTelefonicoKeyTyped
        char caracter = evt.getKeyChar(); 
        if(((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtNumeroTelefonico.getText().length()==9) evt.consume();
    }//GEN-LAST:event_jtxtNumeroTelefonicoKeyTyped

    private void jtxtAniosLaborKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAniosLaborKeyTyped
        char caracter = evt.getKeyChar(); 
        if(((caracter<'0')||(caracter>'9')) && ((caracter!='\b') || (caracter!='\t'))){
            evt.consume();
        }
        if(this.jtxtAniosLabor.getText().length()==2) evt.consume();
    }//GEN-LAST:event_jtxtAniosLaborKeyTyped

    private void jtxtCorreoElectronicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCorreoElectronicoKeyTyped
        if(this.jtxtCorreoElectronico.getText().length()==100) evt.consume();
    }//GEN-LAST:event_jtxtCorreoElectronicoKeyTyped

    private void jpContraseniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpContraseniaKeyTyped
        if(this.jpContrasenia.getPassword().length==50) evt.consume();
    }//GEN-LAST:event_jpContraseniaKeyTyped

    private void jpContraseniaRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpContraseniaRKeyTyped
        if(this.jpContraseniaR.getPassword().length==50) evt.consume();
    }//GEN-LAST:event_jpContraseniaRKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated

    }//GEN-LAST:event_formWindowDeactivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario_Director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_Director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_Director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_Director.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_Director().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser jcaFechaNacimiento;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbGradoAcademico;
    private javax.swing.JPasswordField jpContrasenia;
    private javax.swing.JPasswordField jpContraseniaR;
    private javax.swing.JTextField jtxtAniosLabor;
    private javax.swing.JTextField jtxtApellidoMaterno;
    private javax.swing.JTextField jtxtApellidoPaterno;
    private javax.swing.JTextField jtxtCodigoMINEDU;
    private javax.swing.JTextField jtxtCorreoElectronico;
    private javax.swing.JTextField jtxtDNI;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNumeroTelefonico;
    // End of variables declaration//GEN-END:variables
}
