package gui.panels;

import bibliogest.Libro;
import bibliogest.PDFGenerator;
import bibliogest.dao.LibroDAO;
import static bibliogest.validator.TextValidator.normalizarTexto;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * Clase que gestiona la interfaz gráfica para la gestión de libros. Incluye
 * funcionalidades para añadir, actualizar, eliminar, buscar y generar informes
 * de libros.
 *
 * @author ajesusau
 */
public class GestionLibros extends javax.swing.JPanel {

    /**
     * Constructor del panel de gestión de libros. Inicializa los componentes
     * gráficos y carga los datos iniciales en la tabla.
     */
    public GestionLibros() {
        initComponents();
        cargarTablaLibros();
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
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        txtFechaPublicacion = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarLibro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLibros = new javax.swing.JTable();
        btnBuscarLibro = new javax.swing.JButton();
        btnActualizarLibros = new javax.swing.JButton();
        btnGenerarInforme = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 66));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Título");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtTitulo.setToolTipText("");
        txtTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTitulo.setDropMode(javax.swing.DropMode.INSERT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 199;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        jPanel1.add(txtTitulo, gridBagConstraints);

        jLabel2.setText("Autor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        jPanel1.add(txtAutor, gridBagConstraints);

        jLabel3.setText("ISBM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        try {
            txtISBN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        jPanel1.add(txtISBN, gridBagConstraints);

        jLabel4.setText("Fecha de Publicación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 0, 0);
        jPanel1.add(jLabel5, gridBagConstraints);

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "disponible", "prestado" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 20, 7);
        jPanel1.add(comboEstado, gridBagConstraints);

        txtFechaPublicacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        jPanel1.add(txtFechaPublicacion, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel6.setText("Buscar:");

        tbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Autor", "ISBN", "Fecha de Publicación", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLibros);
        if (tbLibros.getColumnModel().getColumnCount() > 0) {
            tbLibros.getColumnModel().getColumn(0).setMinWidth(80);
            tbLibros.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbLibros.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        btnBuscarLibro.setText("Buscar");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        btnActualizarLibros.setText("Actualizar Lista");
        btnActualizarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarLibrosActionPerformed(evt);
            }
        });

        btnGenerarInforme.setText("Generar Informe");
        btnGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarInforme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizarLibros))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro)
                    .addComponent(btnActualizarLibros)
                    .addComponent(btnGenerarInforme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setMinimumSize(new java.awt.Dimension(900, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 40));
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
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Añadir". Inserta un nuevo libro en
     * la base de datos con los datos proporcionados.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String isbn = txtISBN.getText().trim();
        LocalDate fechaPublicacion = obtenerFechaDesdeTexto();
        String estado = (String) comboEstado.getSelectedItem();
        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || fechaPublicacion == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos correctamente.");
            return;
        }
        Libro nuevoLibro = new Libro(titulo, autor, isbn, fechaPublicacion, estado);
        LibroDAO libroDAO = new LibroDAO();
        try {
            libroDAO.addLibro(nuevoLibro);
            cargarTablaLibros();
            JOptionPane.showMessageDialog(this, "Libro añadido correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al añadir el libro: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar". Actualiza los datos de
     * un libro seleccionado en la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int selectedRow = tbLibros.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String idString = tbLibros.getValueAt(selectedRow, 0).toString();
                int id = Integer.parseInt(idString);
                String titulo = txtTitulo.getText().trim();
                String autor = txtAutor.getText().trim();
                String isbn = txtISBN.getText().trim();
                String fechaTexto = txtFechaPublicacion.getText().trim();
                String estado = (String) comboEstado.getSelectedItem();
                if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || fechaTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos correctamente.");
                    return;
                }
                LocalDate fechaPublicacion = LocalDate.parse(fechaTexto);
                Libro libroActualizado = new Libro(id, titulo, autor, isbn, fechaPublicacion, estado);
                LibroDAO libroDAO = new LibroDAO();
                try {
                    libroDAO.updateLibro(libroActualizado);
                    cargarTablaLibros();
                    JOptionPane.showMessageDialog(this, "Libro actualizado correctamente.");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el libro: " + e.getMessage());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage());
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error al obtener el ID del libro. Por favor, revise los datos.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Eliminar". Elimina un libro
     * seleccionado de la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tbLibros.getSelectedRow();
        if (selectedRow != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de que desea eliminar este libro?",
                    "Confirmación de eliminación",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(tbLibros.getValueAt(selectedRow, 0).toString());
                    LibroDAO libroDAO = new LibroDAO();
                    libroDAO.deleteLibro(id);
                    cargarTablaLibros();
                    JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el libro: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar Libros". Recarga la
     * tabla con los datos actuales desde la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLibrosActionPerformed
        cargarTablaLibros();
    }//GEN-LAST:event_btnActualizarLibrosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Buscar Libro". Busca libros en la
     * base de datos basándose en el texto ingresado en el campo de búsqueda.
     * Normaliza el texto ingresado y realiza la comparación con los datos de la
     * base de datos. Si no se encuentran resultados, muestra un mensaje
     * informativo.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        String textoBusqueda = txtBuscarLibro.getText().trim();
        if (textoBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un término para buscar.");
            cargarTablaLibros();
            return;
        }
        String textoNormalizado = normalizarTexto(textoBusqueda);
        LibroDAO libroDAO = new LibroDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
        modelo.setRowCount(0);
        try {
            for (Libro libro : libroDAO.getLibros()) {
                String tituloNormalizado = normalizarTexto(libro.getTitulo());
                String autorNormalizado = normalizarTexto(libro.getAutor());
                String isbn = libro.getIsbn();
                if (tituloNormalizado.contains(textoNormalizado)
                        || autorNormalizado.contains(textoNormalizado)
                        || isbn.equalsIgnoreCase(textoBusqueda)) {
                    modelo.addRow(new Object[]{
                        libro.getIdLibro(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getIsbn(),
                        libro.getFechaPublicacion(),
                        libro.getEstado()
                    });
                }
            }
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron libros que coincidan con la búsqueda.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    /**
     * Maneja el evento de clic en una fila de la tabla de libros. Carga los
     * datos de la fila seleccionada en los campos correspondientes del
     * formulario.
     *
     * @param evt Evento de clic generado por el ratón.
     */
    private void tbLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLibrosMouseClicked
        int selectedRow = tbLibros.getSelectedRow();
        if (selectedRow != -1) {
            txtTitulo.setText(tbLibros.getValueAt(selectedRow, 1).toString());
            txtAutor.setText(tbLibros.getValueAt(selectedRow, 2).toString());
            txtISBN.setText(tbLibros.getValueAt(selectedRow, 3).toString());
            txtFechaPublicacion.setText(tbLibros.getValueAt(selectedRow, 4).toString());
            comboEstado.setSelectedItem(tbLibros.getValueAt(selectedRow, 5).toString());
        }
    }//GEN-LAST:event_tbLibrosMouseClicked
    
    /**
     * Maneja el evento de clic en el botón "Generar Informe". Genera un archivo
     * PDF con los datos de todos los libros en la base de datos. Muestra un
     * mensaje informativo al finalizar o en caso de error.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarInformeActionPerformed
        LibroDAO libroDAO = new LibroDAO();
        var libros = libroDAO.getLibros();
        try {
            PDFGenerator.generarInformeLibros("informe_libros.pdf", libros);
            JOptionPane.showMessageDialog(this, "Informe generado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el informe: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGenerarInformeActionPerformed

    /**
     * Carga los datos de los libros desde la base de datos y los muestra en la
     * tabla. Borra los datos existentes en la tabla antes de cargar los nuevos.
     */
    private void cargarTablaLibros() {
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
        modelo.setRowCount(0);
        LibroDAO libroDAO = new LibroDAO();
        for (Libro libro : libroDAO.getLibros()) {
            String fechaFormateada = libro.getFechaPublicacion().toString();
            modelo.addRow(new Object[]{
                libro.getIdLibro(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                fechaFormateada,
                libro.getEstado()
            });
        }
    }

    /**
     * Convierte una cadena de texto en formato "yyyy-MM-dd" a un objeto
     * LocalDate.
     *
     * @param fechaTexto Fecha en formato de texto.
     * @return Objeto LocalDate correspondiente.
     */
    private LocalDate obtenerFechaDesdeTexto() {
        String fechaTexto = txtFechaPublicacion.getText().trim();
        try {
            return LocalDate.parse(fechaTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd.");
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarLibros;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarInforme;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscarLibro;
    private javax.swing.JFormattedTextField txtFechaPublicacion;
    private javax.swing.JFormattedTextField txtISBN;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
