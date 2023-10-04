/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.views.horario;

import br.com.view.professor.*;
import Atxy2k.CustomTextField.RestrictedTextField;
import br.com.dao.HorarioDAO;
import br.com.dao.jdbc.HorarioJDBC;
import br.com.dao.ProfessorDAO;
import br.com.dao.jdbc.ProfessorJDBC;
import br.com.data.Horario;
import br.com.data.Professor;

/**
 *
 * @author Lucas
 */
public final class VIEWInsereHorario extends javax.swing.JFrame {

    /**
     * Creates new form VIEWInsere
     */
    public VIEWInsereHorario() {
        initComponents();
        this.setLocationRelativeTo(null);

        RestrictedTextField validaHorario = new RestrictedTextField(txtHorario);
        validaHorario.setLimit(15);
        validaHorario.setAcceptSpace(true);
    }

    public void buttonVisible() {
        btnInserir.setVisible(true);
    }

    public void buttonInvisible() {
        btnInserir.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHorario = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();

        setResizable(false);

        lblHorario.setText("Horário");

        txtHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorarioActionPerformed(evt);
            }
        });
        txtHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHorarioKeyReleased(evt);
            }
        });

        btnInserir.setText("Enviar");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHorario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnInserir)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnInserir)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHorarioActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        Horario horario = new Horario();
        HorarioDAO horarioInserido = new HorarioJDBC();

        horario.setDescricaoHorario(txtHorario.getText());
        horarioInserido.create(horario);
        this.setVisible(false);

    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtHorarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorarioKeyReleased
    }//GEN-LAST:event_txtHorarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JTextField txtHorario;
    // End of variables declaration//GEN-END:variables
}
