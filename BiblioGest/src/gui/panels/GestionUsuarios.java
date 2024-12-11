package gui.panels;

import bibliogest.Usuario;
import bibliogest.dao.UsuarioDAO;
import bibliogest.validator.TextValidator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * Clase que gestiona la interfaz gráfica para la administración de usuarios.
 * Permite añadir, actualizar, eliminar y buscar usuarios registrados.
 *
 * @author ajesusau
 */
public class GestionUsuarios extends javax.swing.JPanel {

    /**
     * Constructor del panel de gestión de Usuarios. Inicializa los componentes
     * gráficos y carga los datos iniciales en la tabla.
     */
    public GestionUsuarios() {
        initComponents();
        cargarTablaUsuarios();
    }

    /**
     * Inicializa los componentes gráficos del panel. Este método es generado
     * automáticamente por el editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTipoUsuario = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarUsuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnActualizarUsuarios = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(900, 40));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(95, 40));
        btnEliminar.setMinimumSize(new java.awt.Dimension(95, 40));
        btnEliminar.setPreferredSize(new java.awt.Dimension(95, 40));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 225, 0, 75);
        jPanel2.add(btnEliminar, gridBagConstraints);

        btnActualizar.setText("Actualizar");
        btnActualizar.setMaximumSize(new java.awt.Dimension(95, 40));
        btnActualizar.setMinimumSize(new java.awt.Dimension(95, 40));
        btnActualizar.setPreferredSize(new java.awt.Dimension(95, 40));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 225, 0, 0);
        jPanel2.add(btnActualizar, gridBagConstraints);

        btnAnadir.setText("Añadir");
        btnAnadir.setMaximumSize(new java.awt.Dimension(95, 45));
        btnAnadir.setMinimumSize(new java.awt.Dimension(95, 45));
        btnAnadir.setPreferredSize(new java.awt.Dimension(95, 40));
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 90, 0, 0);
        jPanel2.add(btnAnadir, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 66));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nombre de Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtNombreUsuario.setToolTipText("");
        txtNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreUsuario.setDropMode(javax.swing.DropMode.INSERT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 199;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        jPanel1.add(txtNombreUsuario, gridBagConstraints);

        jLabel2.setText("Email:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        jPanel1.add(txtEmail, gridBagConstraints);

        jLabel5.setText("Tipo de Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 12, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        comboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "usuario" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 20, 0);
        jPanel1.add(comboTipoUsuario, gridBagConstraints);

        jLabel7.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 6);
        jPanel1.add(txtContrasena, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel6.setText("Buscar:");

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnActualizarUsuarios.setText("Actualizar Lista");
        btnActualizarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuariosActionPerformed(evt);
            }
        });

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Nombre", "Email", "Tipo de Usuario", "Fecha de Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbUsuarios);
        if (tbUsuarios.getColumnModel().getColumnCount() > 0) {
            tbUsuarios.getColumnModel().getColumn(0).setMinWidth(80);
            tbUsuarios.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbUsuarios.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(btnActualizarUsuarios)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(btnActualizarUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Eliminar". Elimina un usuario
     * seleccionado de la tabla y la base de datos. Verifica posibles
     * restricciones, como préstamos asociados al usuario.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tbUsuarios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla para eliminar.", "Selección Vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idUsuario = Integer.parseInt(tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 0).toString());
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar este usuario?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.deleteUsuario(idUsuario);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                cargarTablaUsuarios();
            } catch (SQLException e) {
                if (e.getMessage().contains("foreign key constraint")) {
                    JOptionPane.showMessageDialog(this,
                            "No se puede eliminar el usuario porque tiene préstamos asociados.",
                            "Error al Eliminar",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Error al eliminar usuario: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar". Actualiza los datos de
     * un usuario seleccionado con la información proporcionada en los campos.
     * Verifica el formato de correo electrónico y evita duplicados en la base
     * de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (tbUsuarios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla para actualizar.", "Selección Vacía", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idUsuario = Integer.parseInt(tbUsuarios.getValueAt(tbUsuarios.getSelectedRow(), 0).toString());
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String email = txtEmail.getText().trim();
        String tipoUsuario = comboTipoUsuario.getSelectedItem().toString();
        String nuevaContrasena = new String(txtContrasena.getText()).trim();
        if (nombreUsuario.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!TextValidator.isEmailValido(email)) {
            JOptionPane.showMessageDialog(this, "El formato del correo no es válido. Intente nuevamente.", "Correo Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            String contrasenaFinal = nuevaContrasena.isEmpty()
                    ? usuarioDAO.getUsuarioById(idUsuario).getContrasena()
                    : nuevaContrasena;
            Usuario usuarioActualizado = new Usuario(idUsuario, nombreUsuario, contrasenaFinal, email, tipoUsuario, null);
            usuarioDAO.updateUsuario(usuarioActualizado);
            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
            cargarTablaUsuarios(); // Recargar la tabla
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                if (e.getMessage().contains("usuario")) {
                    JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Intente con otro.", "Usuario Duplicado", JOptionPane.ERROR_MESSAGE);
                } else if (e.getMessage().contains("email")) {
                    JOptionPane.showMessageDialog(this, "El correo electrónico ya está registrado. Intente con otro.", "Correo Duplicado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Añadir". Crea un nuevo usuario en
     * la base de datos con la información proporcionada. Valida los campos
     * obligatorios y genera una contraseña predeterminada basada en el nombre
     * de usuario.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String email = txtEmail.getText().trim();
        String tipoUsuario = comboTipoUsuario.getSelectedItem().toString();
        if (nombreUsuario.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!TextValidator.isEmailValido(email)) {
            JOptionPane.showMessageDialog(this, "El formato del correo no es válido. Intente nuevamente.", "Correo Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String contrasena = nombreUsuario;
        txtContrasena.setText(contrasena);
        try {
            Usuario nuevoUsuario = new Usuario(0, nombreUsuario, contrasena, email, tipoUsuario, null);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.addUsuario(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario añadido correctamente.");
            cargarTablaUsuarios();
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                if (e.getMessage().contains("usuario")) {
                    JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Intente con otro.", "Usuario Duplicado", JOptionPane.ERROR_MESSAGE);
                } else if (e.getMessage().contains("email")) {
                    JOptionPane.showMessageDialog(this, "El correo electrónico ya está registrado. Intente con otro.", "Correo Duplicado", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al añadir usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    /**
     * Maneja el evento de clic en el botón "Buscar". Filtra los usuarios en la
     * tabla según el término ingresado en el campo de búsqueda. Normaliza el
     * texto para realizar comparaciones más precisas.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        String textoBusqueda = txtBuscarUsuario.getText().trim();
        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un término para buscar.");
            cargarTablaUsuarios();
            return;
        }
        String textoNormalizado = TextValidator.normalizarTexto(textoBusqueda);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        try {
            for (Usuario usuario : usuarioDAO.getUsuarios()) {
                String nombreUsuarioNormalizado = TextValidator.normalizarTexto(usuario.getUsuario());
                String emailNormalizado = TextValidator.normalizarTexto(usuario.getEmail());
                String idUsuario = String.valueOf(usuario.getIdUsuario());
                String tipoUsuario = usuario.getTipoUsuario();
                String fechaRegistro = usuario.getFechaRegistro() != null
                        ? usuario.getFechaRegistro().toLocalDate().toString()
                        : "";
                if (nombreUsuarioNormalizado.contains(textoNormalizado)
                        || emailNormalizado.contains(textoNormalizado)
                        || idUsuario.equalsIgnoreCase(textoBusqueda)) {
                    modelo.addRow(new Object[]{
                        usuario.getIdUsuario(),
                        usuario.getUsuario(),
                        usuario.getEmail(),
                        tipoUsuario,
                        fechaRegistro
                    });
                }
            }
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios que coincidan con la búsqueda.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar Lista". Recarga la tabla
     * con todos los usuarios registrados en la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuariosActionPerformed
        cargarTablaUsuarios();
    }//GEN-LAST:event_btnActualizarUsuariosActionPerformed

    /**
     * Maneja el evento de clic en una fila de la tabla de usuarios. Carga la
     * información del usuario seleccionado en los campos correspondientes.
     *
     * @param evt Evento de clic generado por el ratón.
     */
    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        int filaSeleccionada = tbUsuarios.getSelectedRow();
        if (filaSeleccionada != -1) {
            txtNombreUsuario.setText(tbUsuarios.getValueAt(filaSeleccionada, 1).toString());
            txtEmail.setText(tbUsuarios.getValueAt(filaSeleccionada, 2).toString());
            comboTipoUsuario.setSelectedItem(tbUsuarios.getValueAt(filaSeleccionada, 3).toString());
            txtContrasena.setText("");
        }

    }//GEN-LAST:event_tbUsuariosMouseClicked

    /**
     * Carga los datos de los usuarios desde la base de datos y los muestra en
     * la tabla. Borra los datos existentes en la tabla antes de cargar los
     * nuevos.
     */
    private void cargarTablaUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        try {
            for (Usuario usuario : usuarioDAO.getUsuarios()) {
                String fechaRegistro = usuario.getFechaRegistro() != null
                        ? usuario.getFechaRegistro().toLocalDate().toString()
                        : "";
                modelo.addRow(new Object[]{
                    usuario.getIdUsuario(),
                    usuario.getUsuario(),
                    usuario.getEmail(),
                    usuario.getTipoUsuario(),
                    fechaRegistro
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los usuarios: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarUsuarios;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JTextField txtBuscarUsuario;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
