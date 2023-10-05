/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.view.localdaaula;

import br.com.dao.LocalDaAulaDAO;
import br.com.dao.jdbc.LocalDaAulaJDBC;
import br.com.data.LocalDaAula;

/**
 *
 * @author Lucas
 */
public class VIEWEditarLocalDaAula extends javax.swing.JFrame {

    LocalDaAula local = new LocalDaAula();
    LocalDaAulaDAO localDeAulaEditado = new LocalDaAulaJDBC();

    /**
     * Creates new form VIEWEditar
     */
    public VIEWEditarLocalDaAula(LocalDaAula l) {
        initComponents();
        this.setLocationRelativeTo(null);
        initJTextFiels(l);
    }

    public void initJTextFiels(LocalDaAula l) {
        local = l;
        txtLocalDaAula.setText(l.getLocalDaAula());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLocalDaAula = new javax.swing.JTextField();
        lblMatricula = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();

        setName("Editar Professor"); // NOI18N
        setResizable(false);

        lblMatricula.setText("Local da aula");

        btnEditar.setText("Enviar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMatricula)
                        .addComponent(txtLocalDaAula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lblMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalDaAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        local.setLocalDaAula(txtLocalDaAula.getText());
        localDeAulaEditado.update(local);
        this.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JTextField txtLocalDaAula;
    // End of variables declaration//GEN-END:variables
}
