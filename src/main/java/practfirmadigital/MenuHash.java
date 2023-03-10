/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practfirmadigital;

import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author pakma
 */
public class MenuHash extends javax.swing.JFrame {

    /**
     * Creates new form MenuHash
     */String rutaMensaje;
    String nombreMensaje;
    String rutaLlave;
    String rutaGuardado;
    public MenuHash() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelArchivo = new javax.swing.JButton();
        RutaBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SelArchivo.setText("Seleccionar archivo");
        SelArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelArchivoActionPerformed(evt);
            }
        });

        RutaBtn.setText("...");
        RutaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Ruta de guardado");

        jButton3.setText("Generar Hash");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(SelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RutaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(SelArchivo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RutaBtn)
                    .addComponent(jLabel1))
                .addGap(50, 50, 50)
                .addComponent(jButton3)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelArchivoActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("."));
        selector.showOpenDialog(this);
        try {
            rutaMensaje = selector.getSelectedFile().getAbsolutePath();
            nombreMensaje = selector.getSelectedFile().getName();

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una ruta");
        }

        if (rutaMensaje != null) {
            System.out.println(rutaMensaje);
            System.out.println(nombreMensaje);
            SelArchivo.setText(rutaMensaje);
        }
    }//GEN-LAST:event_SelArchivoActionPerformed

    private void RutaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaBtnActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("."));
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        selector.showOpenDialog(this);
        try {
            rutaGuardado = selector.getSelectedFile().getAbsolutePath();

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado una ruta");
        }

        if (rutaGuardado != null) {
            System.out.println(rutaGuardado);
            RutaBtn.setText(rutaGuardado);
        }
    }//GEN-LAST:event_RutaBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            File archivo = new File(rutaMensaje);
            byte[] archivoByte = Files.readAllBytes(archivo.toPath());
            System.out.println(getHash(archivoByte,"SHA-256"));
            File mensaje = new File(rutaMensaje);
            nombreMensaje = nombreMensaje.replace(".txt", "");
            File fSalida = new File(rutaGuardado + File.separator + nombreMensaje + "_Firma.txt");
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuHash().setVisible(true);
            }
        });
    }
    public static String getHash(byte[] inputBytes,String algorithm){
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            BigInteger ResumenNumero = new BigInteger(1,digestedBytes);
            hashValue = ResumenNumero.toString(16);
        } catch (Exception e) {
        }
        return hashValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RutaBtn;
    private javax.swing.JButton SelArchivo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
