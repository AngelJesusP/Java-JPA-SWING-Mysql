package vista;

import DAO.EmpleadoDAO;
import entity.Empleado;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author angel
 */
public class Principal extends javax.swing.JFrame {

    private EmpleadoDAO empleadoDAO;
    private DefaultTableModel model;
    private final String titulos[] = {"CEDULA", "NOMBRE", "APELLIDO", "SUELDO", "FECHA CONTRATACION"};

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(this);

        /* Centramos los Header del JTable */
        TableCellRenderer rendererFromHeader = this.JtablaEmpleados.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        this.setResizable(false);
        this.empleadoDAO = new EmpleadoDAO();
        this.setListarInformacionEmpleado();
    }

    public void setListarInformacionEmpleado() {
        List<Empleado> lista = this.empleadoDAO.getListarEmpleado();
        this.model = new DefaultTableModel(null, titulos);

        Object datos[] = new Object[5];
        for (Empleado item : lista) {
            datos[0] = item.getCedula();
            datos[1] = item.getNombre();
            datos[2] = item.getApellido();
            datos[3] = item.getSueldo();
            datos[4] = item.getFechaContratacion();
            this.model.addRow(datos);
        }
        this.JtablaEmpleados.setModel(model);
    }

    public void setBuscarEmpleado() {
        this.model = new DefaultTableModel(null, titulos);
        int cedulaId = Integer.parseInt(this.txtCedula.getText());
        Empleado empelado = this.empleadoDAO.getBuscarEmpleado(cedulaId);
        Object datos[] = new Object[5];
        datos[0] = empelado.getCedula();
        datos[1] = empelado.getNombre();
        datos[2] = empelado.getApellido();
        datos[3] = empelado.getSueldo();
        datos[4] = empelado.getFechaContratacion();
        this.model.addRow(datos);

        this.JtablaEmpleados.setModel(model);
    }

    private void setAgregar_o_Actualizar(boolean entrada) {
        try {
            int cedula = Integer.parseInt(this.txtCedula.getText());
            String nombre = this.txtNombre.getText();
            String apellido = this.txtApellido.getText();
            double sueldo = Double.parseDouble(this.txtSueldo.getText());

            if (entrada) {
                boolean respuesta = this.empleadoDAO.setAgregarEmpleado(cedula, nombre, apellido, sueldo);
                if (respuesta) {
                    JOptionPane.showMessageDialog(null, "Registro realizado con exito !!",
                            "EXITO", JOptionPane.INFORMATION_MESSAGE);
                    this.setListarInformacionEmpleado();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar la informacion",
                            "Infomracion", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                boolean respuesta = this.empleadoDAO.setActualizarEmpleado(cedula, nombre, apellido, sueldo);
                this.setListarInformacionEmpleado();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, Ingrese bien los campos !!",
                    "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setActualizar() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtablaEmpleados = new javax.swing.JTable();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtSueldo = new javax.swing.JTextField();
        btnAccion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JcomboBoxCrud = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        JtablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE", "APELLIDO", "SUELDO", "FECHA CONTRATACION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JtablaEmpleados.setRowHeight(22);
        JtablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtablaEmpleados);

        txtCedula.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N

        txtSueldo.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N

        btnAccion.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        btnAccion.setText("Realizar Acción");
        btnAccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAccionMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Pagul", 2, 18)); // NOI18N
        jLabel1.setText("* Ingrese el nombre del empleado:");

        jLabel2.setFont(new java.awt.Font("Pagul", 2, 18)); // NOI18N
        jLabel2.setText("* Ingrese la cedula del empleado:");

        jLabel3.setFont(new java.awt.Font("Pagul", 2, 18)); // NOI18N
        jLabel3.setText("* Ingrese el apellido del empleado:");

        jLabel4.setFont(new java.awt.Font("Pagul", 2, 18)); // NOI18N
        jLabel4.setText("* Ingrese la sueldo:");

        JcomboBoxCrud.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        JcomboBoxCrud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrar", "Actualizar", "Eliminar", "Buscar" }));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 3, 14)); // NOI18N
        jLabel5.setText("JPA Swing - CRUD Mysql ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtSueldo)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JcomboBoxCrud, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JcomboBoxCrud, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccionMouseClicked

        String accion = this.JcomboBoxCrud.getSelectedItem().toString();

        switch (accion) {
            case "Registrar":
                this.setAgregar_o_Actualizar(true);
                break;
            case "Actualizar":
                this.setAgregar_o_Actualizar(false);
                break;
            case "Eliminar":
                int cedula = Integer.parseInt(this.txtCedula.getText());
                this.empleadoDAO.setEliminarEmpleado(cedula);
                this.setListarInformacionEmpleado();
                break;
            case "Buscar":
                this.setBuscarEmpleado();
                break;
        }
    }//GEN-LAST:event_btnAccionMouseClicked

    private void JtablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtablaEmpleadosMouseClicked

        int fila = this.JtablaEmpleados.getSelectedRow();
        String cedula = this.JtablaEmpleados.getValueAt(fila, 0).toString();
        String nombre = this.JtablaEmpleados.getValueAt(fila, 1).toString();
        String apellido = this.JtablaEmpleados.getValueAt(fila, 2).toString();
        String sueldo = this.JtablaEmpleados.getValueAt(fila, 3).toString();

        this.txtCedula.setText(cedula);
        this.txtNombre.setText(nombre);
        this.txtApellido.setText(apellido);
        this.txtSueldo.setText(sueldo);

    }//GEN-LAST:event_JtablaEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcomboBoxCrud;
    private javax.swing.JTable JtablaEmpleados;
    private javax.swing.JButton btnAccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
