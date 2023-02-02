package practfirmadigital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class menuGeneracionLlaves extends javax.swing.JFrame {

    String rutaGuardado;
    
    public menuGeneracionLlaves() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonRutaGuardado = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonRutaGuardado.setText("...");
        botonRutaGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRutaGuardadoActionPerformed(evt);
            }
        });

        jButton1.setText("Generar llave");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ruta guardado:");

        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(botonRutaGuardado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRutaGuardado)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRutaGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRutaGuardadoActionPerformed
        
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("."));
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector.showOpenDialog(this);
        try{
            rutaGuardado = selector.getSelectedFile().getAbsolutePath();
            
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "No ha seleccionado una ruta");
        }
        
        if(rutaGuardado != null){
            System.out.println(rutaGuardado);
            botonRutaGuardado.setText(rutaGuardado);
        }
    }//GEN-LAST:event_botonRutaGuardadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        KeyPairGenerator generator;
        KeyPair pair;
        PrivateKey privateKey;
        PublicKey publicKey;
        
        String nombreArchivo = nombre.getText();
        
        if(nombreArchivo.equals("")){
            nombreArchivo = "Llave";
        }
        
        File fLlavePublica = new File(rutaGuardado + File.separator + nombreArchivo + "Publica.key");
        File fLlavePrivada = new File(rutaGuardado + File.separator + nombreArchivo + "Privada.key");
        
        try {
            generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
            
            try {
                FileOutputStream fos = new FileOutputStream(fLlavePublica);
                fos.write(publicKey.getEncoded());
                fos.close();
                System.out.println("Llave publica completa");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una ruta de guardado");
            } catch (IOException ex) {
                Logger.getLogger(menuGeneracionLlaves.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una ruta de guardado");
            }
            
            try {
                FileOutputStream fos = new FileOutputStream(fLlavePrivada);
                fos.write(privateKey.getEncoded());
                fos.close();
                System.out.println("Llave privada completa");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una ruta de guardado");
            } catch (IOException ex) {
                Logger.getLogger(menuGeneracionLlaves.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(menuGeneracionLlaves.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuGeneracionLlaves.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuGeneracionLlaves.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuGeneracionLlaves.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuGeneracionLlaves.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuGeneracionLlaves().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRutaGuardado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
