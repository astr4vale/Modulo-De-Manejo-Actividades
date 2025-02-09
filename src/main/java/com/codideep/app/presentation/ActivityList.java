package com.codideep.app.presentation;

import com.codideep.app.business.BusinessActivity;
import com.codideep.app.datatransfer.DtoActivity;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ActivityList extends javax.swing.JInternalFrame {

    private final BusinessActivity businessActivity;
    private DefaultTableModel tableModel;
    private int currentPage = 1;
    private int rowsPerPage = 5;
    private int totalRecords = 0;

    public ActivityList() {
        initComponents();
        this.businessActivity = new BusinessActivity();
        initializeComponents();
        addEventListeners();
        // Configurar codificación
        tablaActividades.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    private void initializeComponents() {
        // Configurar el modelo de la tabla
        String[] columns = {"ID", "Nombre", "Fecha Inicio", "Fecha Fin", "Estado"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaActividades.setModel(tableModel);
        System.out.println("Modelo de tabla asignado: " + (tablaActividades.getModel() != null));

        // Verificar dimensiones y visibilidad
        System.out.println("Dimensiones de la tabla: " + tablaActividades.getSize());
        System.out.println("¿Es visible?: " + tablaActividades.isVisible());
        System.out.println("¿Está habilitada?: " + tablaActividades.isEnabled());

        // Ajustar dimensiones
        tablaActividades.setPreferredSize(new Dimension(800, 400));
        tablaActividades.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Asegurar que la tabla tenga espacio
        jScrollPane1.setPreferredSize(new Dimension(800, 400));
        jScrollPane1.setViewportView(tablaActividades);

        // Configurar el renderizador de fechas
        tablaActividades.getColumnModel().getColumn(2).setCellRenderer(new DateRenderer());
        tablaActividades.getColumnModel().getColumn(3).setCellRenderer(new DateRenderer());


        // Obtener el total de registros y cargar primera página
        try {
            totalRecords = businessActivity.getDataPageQuantity("");
            loadPage(currentPage);
            updatePaginationControls();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar actividades: " + ex.getMessage());
        }
    }

    private void addEventListeners() {
        System.out.println("Configurando manejador de eventos para el botón de búsqueda");
        btnBuscar.addActionListener(e -> {
            System.out.println("Botón de búsqueda presionado");
            try {
                currentPage = 1;
                totalRecords = businessActivity.getDataPageQuantity(txtBuscar.getText());
                System.out.println("Búsqueda por: " + txtBuscar.getText());
                loadPage(currentPage);
                updatePaginationControls();
            } catch (SQLException ex) {
                System.out.println("Error al buscar actividades: " + ex.getMessage());
            }
        });
    }

    private void updatePaginationControls() {
        int totalPages = (int) Math.ceil((double) totalRecords / rowsPerPage);
        btnAnterior.setEnabled(currentPage > 1);
        btnSiguiente.setEnabled(currentPage < totalPages);
        txtContadorPagina.setText(String.format("%d/%d", currentPage, totalPages));
    }


    private void loadPage(int page) {
        try {
            System.out.println("Cargando página " + page);
            tableModel.setRowCount(0);
            List<DtoActivity> activities = businessActivity.getDataPage("", page, rowsPerPage);

            System.out.println("Número de actividades encontradas: " + activities.size());

            for (DtoActivity activity : activities) {
                Object[] row = {
                    activity.getIdActivity(),
                    activity.getName(),
                    activity.getBeginDate(),
                    activity.getEndDate(),
                    activity.isStatus() ? "Activo" : "Inactivo"
                };
                tableModel.addRow(row);
                System.out.println("Agregando actividad: " + activity.getName());

                // Verificar que los datos se agregaron
                System.out.println("Número de filas en el modelo: " + tableModel.getRowCount());
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar página: " + ex.getMessage());
        }
    }

    private class DateRenderer extends DefaultTableCellRenderer {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Date) {
                value = dateFormat.format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaActividades = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        txtContadorPagina = new javax.swing.JTextField();

        tablaActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaActividades);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        txtContadorPagina.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(txtContadorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAnterior)
                    .addComponent(txtContadorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            currentPage = 1;
            totalRecords = businessActivity.getDataPageQuantity(txtBuscar.getText());
            tableModel.setRowCount(0); // Limpiar tabla
            loadPage(currentPage);
            tableModel.fireTableDataChanged(); // Notificar cambios
            updatePaginationControls();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar actividades: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int totalPages = (int) Math.ceil((double) totalRecords / rowsPerPage);
        if (currentPage < totalPages) {
            currentPage++;
            loadPage(currentPage);
            updatePaginationControls();
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (currentPage > 1) {
            currentPage--;
            loadPage(currentPage);
            updatePaginationControls();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaActividades;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContadorPagina;
    // End of variables declaration//GEN-END:variables
}
