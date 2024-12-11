package gui.panels;

import bibliogest.Libro;
import bibliogest.Prestamo;
import bibliogest.Usuario;
import bibliogest.dao.LibroDAO;
import bibliogest.dao.PrestamoDAO;
import bibliogest.dao.UsuarioDAO;
import bibliogest.validator.TextValidator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la interfaz gráfica del perfil de usuario. Permite
 * visualizar y actualizar la información personal del usuario logeado, así como
 * gestionar y buscar los préstamos asociados.
 *
 * @author ajesusau
 */
public class PerfilUsuario extends javax.swing.JPanel {

    private final Usuario usuarioLogeado;

    /**
     * Constructor del panel de perfil de Usuario. Inicializa los componentes
     * gráficos y carga los datos iniciales en la tabla.
     *
     * @param usuarioLogeado Usuario logeado en la ventana Login.
     */
    public PerfilUsuario(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
        if (this.usuarioLogeado == null) {
            throw new IllegalArgumentException("El usuario logeado no puede ser null");
        }
        initComponents();
        cargarDatosUsuario();
        cargarTablaPrestamos();
    }

    /**
     * Inicializa los componentes gráficos del panel. Este método es generado
     * automáticamente por el editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPrestamos = new javax.swing.JTable();
        btnActualizarPrestamos = new javax.swing.JButton();
        btnBuscarPrestamo = new javax.swing.JButton();
        txtBuscarPrestamo = new javax.swing.JTextField();
        txtBuscarLibro3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nombre de Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 33, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtNombreUsuario.setToolTipText("");
        txtNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreUsuario.setDropMode(javax.swing.DropMode.INSERT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 199;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 1, 0);
        jPanel1.add(txtNombreUsuario, gridBagConstraints);

        jLabel2.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 18, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 1, 0);
        jPanel1.add(txtEmail, gridBagConstraints);

        jLabel5.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 18, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        txtContrasena.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 6, 0, 0);
        jPanel1.add(txtContrasena, gridBagConstraints);

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 18, 1, 46);
        jPanel1.add(btnGuardar, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tbPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Préstamo", "Libro", "Fecha Préstamo", "Fecha Devolución", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbPrestamos);
        if (tbPrestamos.getColumnModel().getColumnCount() > 0) {
            tbPrestamos.getColumnModel().getColumn(0).setMinWidth(80);
            tbPrestamos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbPrestamos.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        btnActualizarPrestamos.setText("Actualizar Lista");
        btnActualizarPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPrestamosActionPerformed(evt);
            }
        });

        btnBuscarPrestamo.setText("Buscar");
        btnBuscarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPrestamoActionPerformed(evt);
            }
        });

        txtBuscarLibro3.setText("Buscar Prestamo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscarLibro3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscarPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(btnActualizarPrestamos))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarLibro3))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarPrestamo)
                        .addComponent(btnActualizarPrestamos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Actualizar Lista". Recarga la tabla
     * con los préstamos actuales del usuario logeado.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrestamosActionPerformed
        cargarTablaPrestamos();
    }//GEN-LAST:event_btnActualizarPrestamosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Buscar". Filtra los préstamos del
     * usuario logeado según el término ingresado. Realiza comparaciones con el
     * título del libro o el ID del préstamo.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnBuscarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPrestamoActionPerformed
        String textoBusqueda = txtBuscarPrestamo.getText().trim();
        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un término para buscar.");
            cargarTablaPrestamos();
            return;
        }
        String textoNormalizado = TextValidator.normalizarTexto(textoBusqueda);
        DefaultTableModel modelo = (DefaultTableModel) tbPrestamos.getModel();
        modelo.setRowCount(0);
        for (Prestamo prestamo : prestamosDelUsuario) {
            if (prestamo.getUsuarioId() != usuarioLogeado.getIdUsuario()) {
                continue;
            }
            LibroDAO libroDAO = new LibroDAO();
            String tituloLibro = TextValidator.normalizarTexto(libroDAO.getLibroById(prestamo.getLibroId()).getTitulo());
            String idPrestamo = String.valueOf(prestamo.getIdPrestamo());
            if (tituloLibro.contains(textoNormalizado) || idPrestamo.equals(textoBusqueda)) {
                modelo.addRow(new Object[]{
                    prestamo.getIdPrestamo(),
                    libroDAO.getLibroById(prestamo.getLibroId()).getTitulo(),
                    prestamo.getFechaPrestamo(),
                    prestamo.getFechaDevolucion(),
                    prestamo.getEstado()
                });
            }
        }
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No se encontraron préstamos que coincidan con la búsqueda.");
        }
    }//GEN-LAST:event_btnBuscarPrestamoActionPerformed

    /**
     * Maneja el evento de clic en el botón "Guardar Cambios". Actualiza la
     * información personal del usuario logeado con los datos ingresados. Valida
     * los campos obligatorios y el formato del correo electrónico.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nuevoNombreUsuario = txtNombreUsuario.getText().trim();
        String nuevoEmail = txtEmail.getText().trim();
        String nuevaContrasena = new String(txtContrasena.getPassword()).trim();
        if (nuevoNombreUsuario.isEmpty() || nuevoEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!TextValidator.isEmailValido(nuevoEmail)) {
            JOptionPane.showMessageDialog(this, "El formato del Email no es válido.", "Email Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea guardar los cambios?", "Confirmar Cambios",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                System.out.println("Usuario Logeado: " + usuarioLogeado);
                String contrasenaFinal = nuevaContrasena.isEmpty()
                        ? usuarioLogeado.getContrasena()
                        : nuevaContrasena;
                Usuario usuarioActualizado = new Usuario(
                        usuarioLogeado.getIdUsuario(),
                        nuevoNombreUsuario,
                        contrasenaFinal,
                        nuevoEmail,
                        usuarioLogeado.getTipoUsuario(),
                        usuarioLogeado.getFechaRegistro()
                );
                usuarioDAO.updateUsuario(usuarioActualizado);
                usuarioLogeado.setUsuario(nuevoNombreUsuario);
                usuarioLogeado.setEmail(nuevoEmail);
                if (!nuevaContrasena.isEmpty()) {
                    usuarioLogeado.setContrasena(contrasenaFinal);
                }

                JOptionPane.showMessageDialog(this, "Los cambios se han guardado correctamente.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Carga la información personal del usuario logeado en los campos
     * correspondientes.
     */
    private void cargarDatosUsuario() {
        txtNombreUsuario.setText(usuarioLogeado.getUsuario());
        txtEmail.setText(usuarioLogeado.getEmail());
    }

    private List<Prestamo> prestamosDelUsuario = new ArrayList<>();

    /**
     * Carga los datos de los préstamos del usuario logeado y los muestra en la
     * tabla. Borra los datos existentes en la tabla antes de cargar los nuevos.
     */
    private void cargarTablaPrestamos() {
        if (this.usuarioLogeado == null) {
            throw new IllegalStateException("El usuario logeado no está inicializado.");
        }
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        prestamosDelUsuario = prestamoDAO.getPrestamosByUsuarioId(usuarioLogeado.getIdUsuario());
        DefaultTableModel modelo = (DefaultTableModel) tbPrestamos.getModel();
        modelo.setRowCount(0);
        for (Prestamo prestamo : prestamosDelUsuario) {
            modelo.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                new LibroDAO().getLibroById(prestamo.getLibroId()).getTitulo(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion(),
                prestamo.getEstado()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPrestamos;
    private javax.swing.JButton btnBuscarPrestamo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPrestamos;
    private javax.swing.JLabel txtBuscarLibro3;
    private javax.swing.JTextField txtBuscarPrestamo;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
