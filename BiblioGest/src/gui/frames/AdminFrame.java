package gui.frames;

import gui.panels.GestionLibros;
import gui.panels.GestionPrestamos;
import gui.panels.GestionUsuarios;
import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de administración. Permite
 * gestionar préstamos, libros y usuarios a través de una interfaz gráfica.
 *
 * @author ajesusau
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Constructor de la ventana de administración. Inicializa los componentes
     * de la interfaz gráfica.
     */
    public AdminFrame() {
        initComponents();
        setTitle("BiblioGest - Sistema de Gestión de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Inicializa los componentes gráficos de la interfaz. Este método es
     * generado automáticamente por el editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnLibros = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        btnLibros.setText("Gestión de Libros");
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });
        jPanel1.add(btnLibros);

        btnPrestamos.setText("Gestión de Préstamos");
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrestamos);

        btnUsuarios.setText("Gestión de Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Préstamos".
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        JFrame gestionPrestamosPanel = new JFrame("Gestión de Préstamos");
        gestionPrestamosPanel.setContentPane(new GestionPrestamos());
        gestionPrestamosPanel.setSize(1000, 800);
        gestionPrestamosPanel.setLocationRelativeTo(this);
        gestionPrestamosPanel.setVisible(true);
    }//GEN-LAST:event_btnPrestamosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Libros".
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed
        JFrame gestionLibrosPanel = new JFrame("Gestión de Libros");
        gestionLibrosPanel.setContentPane(new GestionLibros());
        gestionLibrosPanel.setSize(1000, 800);
        gestionLibrosPanel.setLocationRelativeTo(this);
        gestionLibrosPanel.setVisible(true);
    }//GEN-LAST:event_btnLibrosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Usuarios".
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        JFrame gestionUsuariosPanel = new JFrame("Gestión de Usuarios");
        gestionUsuariosPanel.setContentPane(new GestionUsuarios());
        gestionUsuariosPanel.setSize(1000, 800);
        gestionUsuariosPanel.setLocationRelativeTo(this);
        gestionUsuariosPanel.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    /**
     * Método principal que lanza la ventana principal para los administradores.
     *
     * @param args Argumentos de línea de comandos.
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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
