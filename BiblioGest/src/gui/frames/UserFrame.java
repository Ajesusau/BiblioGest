package gui.frames;

import bibliogest.Usuario;
import gui.panels.ConsultaLibros;
import gui.panels.PerfilUsuario;
import javax.swing.JFrame;

/**
 * Clase que gestiona la interfaz gráfica para los usuarios. Permite consultar
 * libros y acceder al perfil del usuario.
 *
 * @author ajesusau
 */
public class UserFrame extends javax.swing.JFrame {

    private final Usuario usuarioLogeado;

    /**
     * Constructor de la ventana principal para los usuarios. Inicializa los
     * componentes gráficos y configura al usuario autenticado.
     *
     * @param usuarioLogeado Usuario actualmente autenticado.
     */
    public UserFrame(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
        initComponents();
        setTitle("BiblioGest - Panel de Usuario");
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

        jPanel1 = new javax.swing.JPanel();
        btnLibros = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        btnLibros.setText("Buscar Libros");
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });
        jPanel1.add(btnLibros);

        btnPerfil.setText("Perfil de Usuario");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnPerfil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Libros". Navega a la interfaz de
     * consulta de libros.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed
        JFrame ConsultaLibrosPanel = new JFrame("Buscador de Libros");
        ConsultaLibrosPanel.setContentPane(new ConsultaLibros());
        ConsultaLibrosPanel.setSize(1000, 800);
        ConsultaLibrosPanel.setLocationRelativeTo(this);
        ConsultaLibrosPanel.setVisible(true);
    }//GEN-LAST:event_btnLibrosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Perfil". Navega a la interfaz de
     * gestión del perfil del usuario.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        PerfilUsuario perfilUsuario = new PerfilUsuario(usuarioLogeado);
        JFrame perfilFrame = new JFrame("Perfil de Usuario");
        perfilFrame.setContentPane(perfilUsuario);
        perfilFrame.setSize(1000, 800);
        perfilFrame.setLocationRelativeTo(this);
        perfilFrame.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    /**
     * Método principal que lanza la ventana principal para los usuarios.
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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
