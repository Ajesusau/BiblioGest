package gui.panels;

import bibliogest.Alertas.AlertManager;
import bibliogest.Libro;
import bibliogest.PDFGenerator;
import bibliogest.Prestamo;
import bibliogest.Usuario;
import bibliogest.dao.LibroDAO;
import bibliogest.dao.PrestamoDAO;
import bibliogest.dao.UsuarioDAO;
import static bibliogest.validator.TextValidator.normalizarTexto;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

/**
 * Clase que gestiona la interfaz gráfica para la gestión de préstamos. Permite
 * realizar operaciones CRUD para préstamos y administrar la relación entre
 * usuarios y libros.
 *
 * @author ajesusau
 */
public class GestionPrestamos extends javax.swing.JPanel {

    /**
     * Constructor del panel de gestión de Prestamos. Inicializa los componentes
     * gráficos y carga los datos iniciales en la tabla.
     */
    public GestionPrestamos() {
        initComponents();
        cargarTablaLibros();
        cargarTablaUsuarios();
        cargarTablaPrestamos();
        mostrarAlertas();
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
        txtIdPrestamo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtIdLibro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTituloLibro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFechaPrestamo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaDevolucion = new javax.swing.JTextField();
        comboBox1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLibros = new javax.swing.JTable();
        btnActualizarLibros = new javax.swing.JButton();
        btnBuscarLibro = new javax.swing.JButton();
        txtBuscarLibro = new javax.swing.JTextField();
        txtBuscarField = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPrestamos = new javax.swing.JTable();
        btnActualizarPrestamos = new javax.swing.JButton();
        btnBuscarPrestamo = new javax.swing.JButton();
        txtBuscarPrestamo = new javax.swing.JTextField();
        txtBuscarLibro3 = new javax.swing.JLabel();
        btnGenerarInforme = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnActualizarUsuarios = new javax.swing.JButton();
        btnBuscarUsuario = new javax.swing.JButton();
        txtBuscarUsuario = new javax.swing.JTextField();
        txtBuscarLibro4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnDevolver = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnProrrogar = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("ID Prestamo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 0, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtIdPrestamo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel1.add(txtIdPrestamo, gridBagConstraints);

        jLabel2.setText("ID Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 30, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtIdUsuario.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel1.add(txtIdUsuario, gridBagConstraints);

        jLabel3.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        txtNombreUsuario.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 87;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 21, 0);
        jPanel1.add(txtNombreUsuario, gridBagConstraints);

        txtIdLibro.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel1.add(txtIdLibro, gridBagConstraints);

        jLabel6.setText("ID Libro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 30, 0, 0);
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel8.setText("Libro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 3, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        txtTituloLibro.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 173;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 21, 0);
        jPanel1.add(txtTituloLibro, gridBagConstraints);

        jLabel9.setText("Fecha Prestamo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        txtFechaPrestamo.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 21, 0);
        jPanel1.add(txtFechaPrestamo, gridBagConstraints);

        jLabel10.setText("Fecha Devolucion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 29;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(jLabel10, gridBagConstraints);

        txtFechaDevolucion.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 30;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 21, 0);
        jPanel1.add(txtFechaDevolucion, gridBagConstraints);

        comboBox1.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 31;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(comboBox1, gridBagConstraints);

        txtEstado.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 21, 21);
        jPanel1.add(txtEstado, gridBagConstraints);

        tbLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Libro", "Título", "Autor", "ISBN", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnActualizarLibros.setText("Actualizar Lista");
        btnActualizarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarLibrosActionPerformed(evt);
            }
        });

        btnBuscarLibro.setText("Buscar");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        txtBuscarField.setText("Buscar Libro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBuscarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarLibros))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscarField))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarLibro)
                        .addComponent(btnActualizarLibros)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
        );

        tbPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Préstamo", "ID Usuario", "ID Libro", "Usuario", "Libro", "Fecha Préstamo", "Fecha Devolución", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPrestamosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPrestamos);
        if (tbPrestamos.getColumnModel().getColumnCount() > 0) {
            tbPrestamos.getColumnModel().getColumn(0).setMinWidth(80);
            tbPrestamos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbPrestamos.getColumnModel().getColumn(0).setMaxWidth(80);
            tbPrestamos.getColumnModel().getColumn(1).setMinWidth(0);
            tbPrestamos.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbPrestamos.getColumnModel().getColumn(1).setMaxWidth(0);
            tbPrestamos.getColumnModel().getColumn(2).setMinWidth(0);
            tbPrestamos.getColumnModel().getColumn(2).setPreferredWidth(0);
            tbPrestamos.getColumnModel().getColumn(2).setMaxWidth(0);
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
                .addContainerGap()
                .addComponent(txtBuscarLibro3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBuscarPrestamo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarInforme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizarPrestamos))
            .addComponent(jScrollPane2)
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
                        .addComponent(btnActualizarPrestamos)
                        .addComponent(btnGenerarInforme)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
        );

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Nombre", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        btnActualizarUsuarios.setText("Actualizar Lista");
        btnActualizarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuariosActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        txtBuscarLibro4.setText("Buscar Usuario:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarLibro4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBuscarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarUsuarios))
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarLibro4)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(btnActualizarUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
        );

        jPanel5.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 40));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnDevolver.setText("Devolver");
        btnDevolver.setMaximumSize(new java.awt.Dimension(95, 40));
        btnDevolver.setMinimumSize(new java.awt.Dimension(95, 40));
        btnDevolver.setPreferredSize(new java.awt.Dimension(95, 40));
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 113, 0, 0);
        jPanel5.add(btnDevolver, gridBagConstraints);

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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 113, 0, 85);
        jPanel5.add(btnEliminar, gridBagConstraints);

        btnProrrogar.setText("Prorroga");
        btnProrrogar.setMaximumSize(new java.awt.Dimension(95, 40));
        btnProrrogar.setMinimumSize(new java.awt.Dimension(95, 40));
        btnProrrogar.setPreferredSize(new java.awt.Dimension(95, 40));
        btnProrrogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProrrogarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 114, 0, 0);
        jPanel5.add(btnProrrogar, gridBagConstraints);

        btnPrestar.setText("Prestar");
        btnPrestar.setMaximumSize(new java.awt.Dimension(95, 40));
        btnPrestar.setMinimumSize(new java.awt.Dimension(95, 40));
        btnPrestar.setPreferredSize(new java.awt.Dimension(95, 40));
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 95, 0, 0);
        jPanel5.add(btnPrestar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Prorrogar". Extiende la fecha de
     * devolución de un préstamo seleccionado.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnProrrogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProrrogarActionPerformed
        int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());
        LocalDate fechaDevolucion = LocalDate.parse(txtFechaDevolucion.getText()).plusDays(15);
        if (fechaDevolucion.isAfter(LocalDate.parse(txtFechaPrestamo.getText()).plusDays(30))) {
            JOptionPane.showMessageDialog(this, "No se puede prorrogar más de 30 días.");
            return;
        }
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        try {
            prestamoDAO.updateFechaDevolucion(idPrestamo, fechaDevolucion);
            JOptionPane.showMessageDialog(this, "Prórroga aplicada con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la fecha de devolución: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        cargarTablaPrestamos();
    }//GEN-LAST:event_btnProrrogarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar Préstamos". Recarga la
     * tabla con los datos actuales desde la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPrestamosActionPerformed
        cargarTablaPrestamos();
    }//GEN-LAST:event_btnActualizarPrestamosActionPerformed

    /**
     * Maneja el evento de clic en una fila de la tabla de libros. Carga los
     * datos del libro seleccionado en los campos correspondientes del
     * formulario.
     *
     * @param evt Evento de clic generado por el ratón.
     */
    private void tbLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLibrosMouseClicked
        int filaSeleccionada = tbLibros.getSelectedRow();
        if (filaSeleccionada != -1) {
            txtIdLibro.setText(tbLibros.getValueAt(filaSeleccionada, 0).toString());
            txtTituloLibro.setText(tbLibros.getValueAt(filaSeleccionada, 1).toString());
        }
    }//GEN-LAST:event_tbLibrosMouseClicked

    /**
     * Maneja el evento de clic en una fila de la tabla de usuarios. Carga los
     * datos del usuario seleccionado en los campos correspondientes del
     * formulario.
     *
     * @param evt Evento de clic generado por el ratón.
     */
    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        int filaSeleccionada = tbUsuarios.getSelectedRow();
        if (filaSeleccionada != -1) {
            txtIdUsuario.setText(tbUsuarios.getValueAt(filaSeleccionada, 0).toString());
            txtNombreUsuario.setText(tbUsuarios.getValueAt(filaSeleccionada, 1).toString());
        }
    }//GEN-LAST:event_tbUsuariosMouseClicked

    /**
     * Maneja el evento de clic en una fila de la tabla de préstamos. Muestra
     * los detalles del préstamo seleccionado en los campos correspondientes.
     *
     * @param evt Evento de clic generado por el ratón.
     */
    private void tbPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPrestamosMouseClicked
        int filaSeleccionada = tbPrestamos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) tbPrestamos.getModel();
            String idPrestamo = modelo.getValueAt(filaSeleccionada, 0).toString();
            String idUsuario = modelo.getValueAt(filaSeleccionada, 1).toString();
            String idLibro = modelo.getValueAt(filaSeleccionada, 2).toString();
            String nombreUsuario = modelo.getValueAt(filaSeleccionada, 3).toString();
            String tituloLibro = modelo.getValueAt(filaSeleccionada, 4).toString();
            String fechaPrestamo = modelo.getValueAt(filaSeleccionada, 5).toString();
            String fechaDevolucion = modelo.getValueAt(filaSeleccionada, 6).toString();
            String estado = modelo.getValueAt(filaSeleccionada, 7).toString();
            txtIdPrestamo.setText(idPrestamo);
            txtIdUsuario.setText(idUsuario);
            txtIdLibro.setText(idLibro);
            txtNombreUsuario.setText(nombreUsuario);
            txtTituloLibro.setText(tituloLibro);
            txtFechaPrestamo.setText(fechaPrestamo);
            txtFechaDevolucion.setText(fechaDevolucion);
            txtEstado.setText(estado);
        }
    }//GEN-LAST:event_tbPrestamosMouseClicked

    /**
     * Maneja el evento de clic en el botón "Prestar". Crea un nuevo préstamo
     * validando las restricciones (máximo 3 préstamos por usuario, libro
     * disponible).
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        int idUsuario = Integer.parseInt(txtIdUsuario.getText());
        int idLibro = Integer.parseInt(txtIdLibro.getText());
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        LibroDAO libroDAO = new LibroDAO();
        int prestamosActivos = prestamoDAO.contarPrestamosActivos(idUsuario);
        if (prestamosActivos >= 3) {
            JOptionPane.showMessageDialog(this, "El usuario ya tiene 3 préstamos activos. No puede realizar más.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!libroDAO.isLibroDisponible(idLibro)) {
            JOptionPane.showMessageDialog(this, "El libro ya está prestado. No puede ser prestado nuevamente.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            prestamoDAO.addPrestamo(new Prestamo(0, idUsuario, idLibro, LocalDate.now(), LocalDate.now().plusDays(15), "pendiente"));
            libroDAO.actualizarEstadoLibro(idLibro, "prestado");
            JOptionPane.showMessageDialog(this, "Préstamo registrado con éxito.");
            cargarTablaPrestamos();
            cargarTablaLibros();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el préstamo: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPrestarActionPerformed

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
     * Maneja el evento de clic en el botón "Buscar Usuario". Filtra los
     * usuarios en la tabla basándose en el texto ingresado en el campo de
     * búsqueda.
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
        String textoNormalizado = normalizarTexto(textoBusqueda);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        try {
            for (Usuario usuario : usuarioDAO.getUsuarios()) {
                String nombreUsuarioNormalizado = normalizarTexto(usuario.getUsuario());
                String emailNormalizado = normalizarTexto(usuario.getEmail());
                String idUsuario = String.valueOf(usuario.getIdUsuario());
                if (nombreUsuarioNormalizado.contains(textoNormalizado)
                        || emailNormalizado.contains(textoNormalizado)
                        || idUsuario.equalsIgnoreCase(textoBusqueda)) {
                    modelo.addRow(new Object[]{
                        usuario.getIdUsuario(),
                        usuario.getUsuario(),
                        usuario.getEmail()
                    });
                }
            }
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron usuarios que coincidan con la búsqueda.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    /**
     * Maneja el evento de clic en el botón "Buscar Préstamo". Filtra los
     * préstamos en la tabla según el texto ingresado en el campo de búsqueda.
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
        String textoNormalizado = normalizarTexto(textoBusqueda);
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LibroDAO libroDAO = new LibroDAO();
        DefaultTableModel modelo = (DefaultTableModel) tbPrestamos.getModel();
        modelo.setRowCount(0);
        try {
            for (Prestamo prestamo : prestamoDAO.getPrestamos()) {
                String nombreUsuario = usuarioDAO.getUsuario(prestamo.getUsuarioId()).getUsuario();
                String tituloLibro = libroDAO.getLibroById(prestamo.getLibroId()).getTitulo();
                String idPrestamo = String.valueOf(prestamo.getIdPrestamo());
                String nombreUsuarioNormalizado = normalizarTexto(nombreUsuario);
                String tituloLibroNormalizado = normalizarTexto(tituloLibro);
                if (idPrestamo.equalsIgnoreCase(textoBusqueda)
                        || nombreUsuarioNormalizado.contains(textoNormalizado)
                        || tituloLibroNormalizado.contains(textoNormalizado)) {
                    modelo.addRow(new Object[]{
                        prestamo.getIdPrestamo(),
                        prestamo.getUsuarioId(),
                        prestamo.getLibroId(),
                        nombreUsuario,
                        tituloLibro,
                        prestamo.getFechaPrestamo().toString(),
                        prestamo.getFechaDevolucion().toString(),
                        prestamo.getEstado()
                    });
                }
            }
            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron préstamos que coincidan con la búsqueda.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarPrestamoActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar Libros". Recarga la
     * tabla de libros con los datos actuales desde la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarLibrosActionPerformed
        cargarTablaLibros();
    }//GEN-LAST:event_btnActualizarLibrosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Actualizar Usuarios". Recarga la
     * tabla de usuarios con los datos actuales desde la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnActualizarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuariosActionPerformed
        cargarTablaUsuarios();
    }//GEN-LAST:event_btnActualizarUsuariosActionPerformed

    /**
     * Maneja el evento de clic en el botón "Devolver". Marca un préstamo como
     * devuelto y actualiza el estado del libro asociado a "disponible".
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        int filaSeleccionada = tbPrestamos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());
            int idLibro = Integer.parseInt(txtIdLibro.getText());
            try {
                PrestamoDAO prestamoDAO = new PrestamoDAO();
                LibroDAO libroDAO = new LibroDAO();
                prestamoDAO.updatePrestamoEstado(idPrestamo, "devuelto");
                libroDAO.actualizarEstadoLibro(idLibro, "disponible");
                JOptionPane.showMessageDialog(this, "El préstamo ha sido devuelto.");
                cargarTablaPrestamos();
                cargarTablaLibros();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al devolver el préstamo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un préstamo para devolver.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDevolverActionPerformed

    /**
     * Maneja el evento de clic en el botón "Eliminar". Elimina un préstamo de
     * la base de datos.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tbPrestamos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar este préstamo?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    PrestamoDAO prestamoDAO = new PrestamoDAO();
                    prestamoDAO.deletePrestamo(idPrestamo);
                    JOptionPane.showMessageDialog(this, "Préstamo eliminado correctamente.");
                    cargarTablaPrestamos(); // Refresca la tabla
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el préstamo: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un préstamo para eliminar.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Maneja el evento de clic en el botón "Generar Informe". Genera un archivo
     * PDF con los datos de los préstamos actuales.
     *
     * @param evt Evento de acción generado por el botón.
     */
    private void btnGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarInformeActionPerformed
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        var prestamos = prestamoDAO.getPrestamos();
        try {
            PDFGenerator.generarInformePrestamos("informe_prestamos.pdf", prestamos);
            JOptionPane.showMessageDialog(this, "Informe generado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el informe: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGenerarInformeActionPerformed

    /**
     * Carga los datos de los préstamos desde la base de datos y los muestra en
     * la tabla. Borra los datos existentes en la tabla antes de cargar los
     * nuevos.
     */
    private void cargarTablaPrestamos() {
        DefaultTableModel modelo = (DefaultTableModel) tbPrestamos.getModel();
        modelo.setRowCount(0);
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LibroDAO libroDAO = new LibroDAO();
        for (Prestamo prestamo : prestamoDAO.getPrestamos()) {
            String nombreUsuario = usuarioDAO.getUsuario(prestamo.getUsuarioId()).getUsuario();
            String tituloLibro = libroDAO.getLibroById(prestamo.getLibroId()).getTitulo();
            modelo.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                prestamo.getUsuarioId(),
                prestamo.getLibroId(),
                nombreUsuario,
                tituloLibro,
                prestamo.getFechaPrestamo().toString(),
                prestamo.getFechaDevolucion().toString(),
                prestamo.getEstado()
            });
        }
    }

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
                libro.getEstado()
            });
        }
    }

    /**
     * Carga los datos de los usuarios desde la base de datos y los muestra en
     * la tabla. Borra los datos existentes en la tabla antes de cargar los
     * nuevos.
     */
    private void cargarTablaUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) tbUsuarios.getModel();
        modelo.setRowCount(0);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        for (Usuario usuario : usuarioDAO.getUsuarios()) {
            modelo.addRow(new Object[]{
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getEmail()
            });
        }
    }

    /**
     * Muestra alertas relacionadas con los préstamos próximos a vencer o
     * vencidos. Limpia las alertas después de mostrarlas.
     */
    private void mostrarAlertas() {
        List<String> alertas = AlertManager.getAlerts();
        if (!alertas.isEmpty()) {
            String mensaje = String.join("\n", alertas);
            JOptionPane.showMessageDialog(this, mensaje, "Alertas de Préstamos", JOptionPane.WARNING_MESSAGE);
            AlertManager.limpiarAlertas(); // Limpiar las alertas después de mostrarlas
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarLibros;
    private javax.swing.JButton btnActualizarPrestamos;
    private javax.swing.JButton btnActualizarUsuarios;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnBuscarPrestamo;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarInforme;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnProrrogar;
    private javax.swing.JLabel comboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbLibros;
    private javax.swing.JTable tbPrestamos;
    private javax.swing.JTable tbUsuarios;
    private javax.swing.JLabel txtBuscarField;
    private javax.swing.JTextField txtBuscarLibro;
    private javax.swing.JLabel txtBuscarLibro3;
    private javax.swing.JLabel txtBuscarLibro4;
    private javax.swing.JTextField txtBuscarPrestamo;
    private javax.swing.JTextField txtBuscarUsuario;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaDevolucion;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtIdLibro;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTituloLibro;
    // End of variables declaration//GEN-END:variables
}
