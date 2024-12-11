package gui.panels;

import bibliogest.Libro;
import bibliogest.dao.LibroDAO;
import static bibliogest.validator.TextValidator.normalizarTexto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que gestiona la consulta y visualización de los libros en un panel.
 * Permite buscar libros por texto y actualizar la tabla con los datos actuales
 * de la base de datos.
 *
 * @author ajesusau
 */
public class ConsultaLibros extends javax.swing.JPanel {

    /**
     * Constructor del panel de consulta de libros. Inicializa los componentes
     * gráficos y carga la tabla con los datos iniciales.
     */
    public ConsultaLibros() {
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

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarLibro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLibros = new javax.swing.JTable();
        btnBuscarLibro = new javax.swing.JButton();
        btnActualizarLibros = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(new java.awt.BorderLayout());

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
        jScrollPane1.setViewportView(tbLibros);
        if (tbLibros.getColumnModel().getColumnCount() > 0) {
            tbLibros.getColumnModel().getColumn(0).setMinWidth(80);
            tbLibros.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbLibros.getColumnModel().getColumn(0).setMaxWidth(80);
            tbLibros.getColumnModel().getColumn(5).setResizable(false);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarLibros)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarLibro)
                        .addComponent(btnActualizarLibros)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Buscar Libro". Filtra los libros en
     * la tabla basándose en el texto ingresado en el campo de búsqueda.
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
     * Maneja el evento de clic en el botón "Actualizar Libros". Recarga la
     * tabla con los datos actuales de la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLibrosActionPerformed
        cargarTablaLibros();
    }//GEN-LAST:event_btnActualizarLibrosActionPerformed

    /**
     * Carga los datos de los libros desde la base de datos y los muestra en la
     * tabla. Borra los datos existentes en la tabla antes de cargar los nuevos.
     */
    private void cargarTablaLibros() {
        DefaultTableModel modelo = (DefaultTableModel) tbLibros.getModel();
        modelo.setRowCount(0);
        LibroDAO libroDAO = new LibroDAO();
        for (Libro libro : libroDAO.getLibros()) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarLibros;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTextField txtBuscarLibro;
    // End of variables declaration//GEN-END:variables
}
