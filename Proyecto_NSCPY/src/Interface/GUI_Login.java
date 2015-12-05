package Interface.Entrada;

import conexion.ConexionMySQL;
import Interface.Usuarios.GUI_PanelDirector;
import javax.swing.JOptionPane;

/**
 * GUI de Entrada al sistema
 * @author Christian
 */
public class GUI_Login extends javax.swing.JFrame {
    ConexionMySQL myConect;
    
    /**
     * Inicializacion del Jframe
     * @param conect parametros de la inicializacion del servidor mySQL
     */
    public GUI_Login(ConexionMySQL conect) {
        initComponents();
        this.setLocationRelativeTo(null);
        myConect = conect;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPwd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();
        bAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login NSCPY");
        setResizable(false);

        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("¿Olvido su nombre de usuario o contraseña?");

        tfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Sistema de Informacion de la Institucion Educativa ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("I.E. 40102 \"Nuestra Señora del Carmen Patrona de Yura\"");

        bSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bAceptar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(0, 45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(tfPwd)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        String user;
        String pwd;
        String key;
        int type;
        
        myConect.start();
        user = tfUsuario.getText();
        pwd = "";
        for(char in : tfPwd.getPassword()){
            pwd += in;
        }
        key = myConect.queryOneEleMySQL("usuario", "UsuLog", "UsuLog='" + user + "' AND " + "UsuPwd='"+pwd + "';");
        if(!key.equals("")){
            type = Integer.parseInt(myConect.queryOneEleMySQL("usuario", "UsuTipCod", "UsuLog='" + user + "' AND " + "UsuPwd='"+pwd + "';"));
            switch(type){
                case DIRECTOR:
                    new GUI_PanelDirector(myConect,key).setVisible(true);
                    this.dispose();
                    break;
                case PROFESOR:
                    
                    break;
                case ALUMNO:
                    break;
                    
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Autentificacion, vuelva a intentarlo");
        }
               
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    //variables staticas
    public static final int DIRECTOR = 1;
    public static final int PROFESOR = 2;
    public static final int ALUMNO = 3;

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField tfPwd;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
