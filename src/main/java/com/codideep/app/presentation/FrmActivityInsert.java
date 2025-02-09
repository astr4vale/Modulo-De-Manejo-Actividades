
package com.codideep.app.presentation;

import com.codideep.app.business.BusinessActivity;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

public class FrmActivityInsert extends javax.swing.JInternalFrame {

    private final BusinessActivity businessActivity;
    private final DefaultComboBoxModel<String> cbxModelBeginYear;
    private final DefaultComboBoxModel<String> cbxModelEndYear;
    private final DefaultComboBoxModel<String> cbxModelBeginMonth;
    private final DefaultComboBoxModel<String> cbxModelEndMonth;
    private final DefaultComboBoxModel<String> cbxModelBeginDay;
    private final DefaultComboBoxModel<String> cbxModelEndDay;
    private final DefaultComboBoxModel<String> cbxModelBeginHour;
    private final DefaultComboBoxModel<String> cbxModelEndHour;
    private final DefaultComboBoxModel<String> cbxModelBeginMinutes;
    private final DefaultComboBoxModel<String> cbxModelEndMinutes;

    public FrmActivityInsert() {
        initComponents();

        this.businessActivity = new BusinessActivity();
        
        cbxModelBeginYear = new DefaultComboBoxModel<>();
        cbxModelEndYear = new DefaultComboBoxModel<>();
        cbxModelBeginMonth = new DefaultComboBoxModel<>();
        cbxModelEndMonth = new DefaultComboBoxModel<>();
        cbxModelBeginDay = new DefaultComboBoxModel<>();
        cbxModelEndDay = new DefaultComboBoxModel<>();
        cbxModelBeginHour = new DefaultComboBoxModel<>();
        cbxModelEndHour = new DefaultComboBoxModel<>();
        cbxModelBeginMinutes = new DefaultComboBoxModel<>();
        cbxModelEndMinutes = new DefaultComboBoxModel<>();
        
        int initYear = Calendar.getInstance().get(Calendar.YEAR);
        
        for(int i = 0; i < 3; i++) {
            cbxModelBeginYear.addElement(String.valueOf(initYear + i));
            cbxModelEndYear.addElement(String.valueOf(initYear + i));
        }
        
        cbxBeginYear.setModel(cbxModelBeginYear);
        cbxEndYear.setModel(cbxModelEndYear);
        
        for(int i = 0; i < 12; i++) {
            String tempData = String.valueOf(i + 1);
            
            cbxModelBeginMonth.addElement((tempData.length() == 1 ? "0" : "") + tempData);
            cbxModelEndMonth.addElement((tempData.length() == 1 ? "0" : "") + tempData);
        }
        
        cbxBeginMonth.setModel(cbxModelBeginMonth);
        cbxEndMonth.setModel(cbxModelEndMonth);
        
        for(int i = 0; i < 31; i++) {
            String tempData = String.valueOf(i + 1);
            
            cbxModelBeginDay.addElement((tempData.length() == 1 ? "0" : "") + tempData);
            cbxModelEndDay.addElement((tempData.length() == 1 ? "0" : "") + tempData);
        }
        
        cbxBeginDay.setModel(cbxModelBeginDay);
        cbxEndDay.setModel(cbxModelEndDay);
        
        for(int i = 0; i < 24; i++) {
            String tempData = String.valueOf(i);
            
            cbxModelBeginHour.addElement((tempData.length() == 1 ? "0" : "") + tempData);
            cbxModelEndHour.addElement((tempData.length() == 1 ? "0" : "") + tempData);
        }
        
        cbxBeginHour.setModel(cbxModelBeginHour);
        cbxEndHour.setModel(cbxModelEndHour);
        
        for(int i = 0; i < 60; i++) {
            String tempData = String.valueOf(i);
            
            cbxModelBeginMinutes.addElement((tempData.length() == 1 ? "0" : "") + tempData);
            cbxModelEndMinutes.addElement((tempData.length() == 1 ? "0" : "") + tempData);
        }
        
        cbxBeginMinute.setModel(cbxModelBeginMinutes);
        cbxEndMinute.setModel(cbxModelEndMinutes);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblTitleEnd = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblEndDay = new javax.swing.JLabel();
        lblEndMonth = new javax.swing.JLabel();
        lblEndYear = new javax.swing.JLabel();
        cbxEndDay = new javax.swing.JComboBox<>();
        cbxEndMonth = new javax.swing.JComboBox<>();
        cbxEndYear = new javax.swing.JComboBox<>();
        lblEndHour = new javax.swing.JLabel();
        cbxEndHour = new javax.swing.JComboBox<>();
        lblEndMinute = new javax.swing.JLabel();
        cbxEndMinute = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lblTitleBegin = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblBeginDay = new javax.swing.JLabel();
        lblBeginMonth = new javax.swing.JLabel();
        lblBeginYear = new javax.swing.JLabel();
        cbxBeginDay = new javax.swing.JComboBox<>();
        cbxBeginMonth = new javax.swing.JComboBox<>();
        cbxBeginYear = new javax.swing.JComboBox<>();
        lblBeginHour = new javax.swing.JLabel();
        cbxBeginHour = new javax.swing.JComboBox<>();
        lblBeginMinute = new javax.swing.JLabel();
        cbxBeginMinute = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnInsert = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("NOMBRE DE LA ACTIVIDAD");

        jPanel3.setBackground(new java.awt.Color(232, 232, 232));

        lblTitleEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleEnd.setText("FECHA Y HORA DE FIN");

        lblEndDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndDay.setText("Día");

        lblEndMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndMonth.setText("Mes");

        lblEndYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndYear.setText("Año");

        cbxEndMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEndMonthItemStateChanged(evt);
            }
        });

        lblEndHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndHour.setText("Hora");

        lblEndMinute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndMinute.setText("Minuto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxEndDay, javax.swing.GroupLayout.Alignment.LEADING, 0, 82, Short.MAX_VALUE)
                            .addComponent(lblEndDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEndMinute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEndMinute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEndMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(cbxEndMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 13, Short.MAX_VALUE)
                                        .addComponent(lblEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxEndYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndDay)
                    .addComponent(lblEndMonth)
                    .addComponent(lblEndYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEndDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEndMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEndYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndHour)
                    .addComponent(lblEndMinute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEndHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEndMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(232, 232, 232));

        lblTitleBegin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleBegin.setText("FECHA Y HORA DE INICIO");

        lblBeginDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBeginDay.setText("Día");

        lblBeginMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBeginMonth.setText("Mes");

        lblBeginYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBeginYear.setText("Año");

        cbxBeginMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBeginMonthItemStateChanged(evt);
            }
        });

        lblBeginHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBeginHour.setText("Hora");

        lblBeginMinute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBeginMinute.setText("Minuto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleBegin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxBeginDay, javax.swing.GroupLayout.Alignment.LEADING, 0, 82, Short.MAX_VALUE)
                            .addComponent(lblBeginDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBeginMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(cbxBeginMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(lblBeginYear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxBeginYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxBeginHour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBeginHour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBeginMinute, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(cbxBeginMinute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleBegin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeginDay)
                    .addComponent(lblBeginMonth)
                    .addComponent(lblBeginYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxBeginDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBeginMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBeginYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBeginHour)
                    .addComponent(lblBeginMinute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxBeginHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBeginMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnInsert.setText("Registrar datos ingresados");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsert)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            businessActivity.insert(
                txtName.getText(),
                Integer.parseInt(cbxBeginDay.getSelectedItem().toString()),
                Integer.parseInt(cbxBeginMonth.getSelectedItem().toString()),
                Integer.parseInt(cbxBeginYear.getSelectedItem().toString()),
                Integer.parseInt(cbxBeginHour.getSelectedItem().toString()),
                Integer.parseInt(cbxBeginMinute.getSelectedItem().toString()),
                Integer.parseInt(cbxEndDay.getSelectedItem().toString()),
                Integer.parseInt(cbxEndMonth.getSelectedItem().toString()),
                Integer.parseInt(cbxEndYear.getSelectedItem().toString()),
                Integer.parseInt(cbxEndHour.getSelectedItem().toString()),
                Integer.parseInt(cbxEndMinute.getSelectedItem().toString())
            );
        } catch (NumberFormatException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    private void onChangeMonth(int year, String selectedMonth, DefaultComboBoxModel dcbModel) {
        int dayQuantity = 31;
        
        String[] arrayDay30 = { "04", "06", "09", "11" };
        
        if(java.util.Arrays.asList(arrayDay30).contains(selectedMonth)) {
            dayQuantity = 30;
        }
        
        if(selectedMonth.equals("02")) {
            dayQuantity = isLeapYear(year) ? 29 : 28;
        }
        
        dcbModel.removeAllElements();
        
        for(int i = 0; i < dayQuantity; i++) {
            String tempData = String.valueOf(i + 1);
            
            dcbModel.addElement((tempData.length() == 1 ? "0" : "") + tempData);
        }
    }
            
    private void cbxBeginMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBeginMonthItemStateChanged
        this.onChangeMonth(Integer.parseInt(cbxBeginYear.getSelectedItem().toString()), cbxBeginMonth.getSelectedItem().toString(), cbxModelBeginDay);
    }//GEN-LAST:event_cbxBeginMonthItemStateChanged

    private void cbxEndMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEndMonthItemStateChanged
        this.onChangeMonth(Integer.parseInt(cbxEndYear.getSelectedItem().toString()), cbxEndMonth.getSelectedItem().toString(), cbxModelEndDay);
    }//GEN-LAST:event_cbxEndMonthItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cbxBeginDay;
    private javax.swing.JComboBox<String> cbxBeginHour;
    private javax.swing.JComboBox<String> cbxBeginMinute;
    private javax.swing.JComboBox<String> cbxBeginMonth;
    private javax.swing.JComboBox<String> cbxBeginYear;
    private javax.swing.JComboBox<String> cbxEndDay;
    private javax.swing.JComboBox<String> cbxEndHour;
    private javax.swing.JComboBox<String> cbxEndMinute;
    private javax.swing.JComboBox<String> cbxEndMonth;
    private javax.swing.JComboBox<String> cbxEndYear;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblBeginDay;
    private javax.swing.JLabel lblBeginHour;
    private javax.swing.JLabel lblBeginMinute;
    private javax.swing.JLabel lblBeginMonth;
    private javax.swing.JLabel lblBeginYear;
    private javax.swing.JLabel lblEndDay;
    private javax.swing.JLabel lblEndHour;
    private javax.swing.JLabel lblEndMinute;
    private javax.swing.JLabel lblEndMonth;
    private javax.swing.JLabel lblEndYear;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitleBegin;
    private javax.swing.JLabel lblTitleEnd;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
