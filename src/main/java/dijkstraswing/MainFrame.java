/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstraswing;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import utils.EdgeCollector;
import utils.FileNavigator;
import utils.MyOutputStream;
import utils.NodeCollector;

/**
 *
 * @author Andras Sarro <>
 */
public final class MainFrame extends javax.swing.JFrame {

    private int index = 0;
    private final String TITLE = "Dijkstra algoritmus";
    private final int SAVE_OPTION = 1;
    private final int LOAD_OPTION = 2;
    private MyOutputStream mOS = null;

    public MainFrame() {
        initComponents();
        this.setTitle(TITLE);
        this.setSize(800, 600);
        setLocationRelativeTo(this);
        btnNodeAdd.setEnabled(false);
        btnSave.setEnabled(false);
        mOS = new MyOutputStream(taUzenet);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNodeAdd = new javax.swing.JButton();
        btnelRajzol = new javax.swing.JButton();
        canvas1 = new dijkstraswing.Canvas();
        jScrollPane1 = new javax.swing.JScrollPane();
        taUzenet = new javax.swing.JTextArea();
        btnReady = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNodeAdd.setText("Node felvétele");
        btnNodeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNodeAddActionPerformed(evt);
            }
        });

        btnelRajzol.setText("Él felvétele");
        btnelRajzol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelRajzolActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        taUzenet.setEditable(false);
        taUzenet.setColumns(20);
        taUzenet.setRows(24);
        taUzenet.setTabSize(24);
        taUzenet.setPreferredSize(new java.awt.Dimension(104, 160));
        jScrollPane1.setViewportView(taUzenet);

        javax.swing.GroupLayout canvas1Layout = new javax.swing.GroupLayout(canvas1);
        canvas1.setLayout(canvas1Layout);
        canvas1Layout.setHorizontalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
        canvas1Layout.setVerticalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, canvas1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnReady.setText("Kész!");
        btnReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadyActionPerformed(evt);
            }
        });

        btnSave.setText("Mentés");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnLoad.setText("Betöltés");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnClear.setText("Töröl");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnNew.setText("Új gráf");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNodeAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnelRajzol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReady, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnNodeAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnelRajzol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnReady)
                        .addGap(63, 63, 63)
                        .addComponent(btnClear))
                    .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNodeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNodeAddActionPerformed
        JButton gomb = (JButton) evt.getSource();
        gomb.setEnabled(false);
        canvas1.setNodeAddButtonActive(false);
        btnelRajzol.setEnabled(true);
        canvas1.setIndex(index);


    }//GEN-LAST:event_btnNodeAddActionPerformed

    private void btnelRajzolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelRajzolActionPerformed
        JButton gomb = (JButton) evt.getSource();
        gomb.setEnabled(false);
        btnNodeAdd.setEnabled(true);
        canvas1.setNodeAddButtonActive(true);
        index = canvas1.getIndex();
        canvas1.setElso(true);
    }//GEN-LAST:event_btnelRajzolActionPerformed

    private void btnReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadyActionPerformed
        String[] options = {"Igen", "Nem"};
        int confirm = JOptionPane.showOptionDialog(this, "Biztosan készen van?", "Megerősítés", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (confirm == JOptionPane.YES_OPTION) {
            btnelRajzol.setEnabled(false);
            btnNodeAdd.setEnabled(false);
            btnLoad.setEnabled(false);
            canvas1.setStart(true);
            btnSave.setEnabled(true);
            mOS.start();
            JOptionPane.showMessageDialog(this, "Kattints a kiindulási csomópontra a kezdéshez!", "Start", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnReadyActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        FileNavigator fn = new FileNavigator(SAVE_OPTION);
    }//GEN-LAST:event_btnSaveActionPerformed


    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        btnelRajzol.setEnabled(false);
        btnNodeAdd.setEnabled(false);
        canvas1.setStart(true);
        FileNavigator fn = new FileNavigator(LOAD_OPTION);
        mOS.start();
        JOptionPane.showMessageDialog(this, "Kattints a kiindulási csomópontra a kezdéshez!", "Start", JOptionPane.INFORMATION_MESSAGE);
        canvas1.repaint();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        mOS.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        NodeCollector.getNodes().clear();
        EdgeCollector.getGRAFELEK().clear();
        btnNodeAdd.setEnabled(true);
        canvas1.setStart(false);
        index = 0;
        canvas1.repaint();
    }//GEN-LAST:event_btnNewActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNodeAdd;
    private javax.swing.JButton btnReady;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnelRajzol;
    private dijkstraswing.Canvas canvas1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taUzenet;
    // End of variables declaration//GEN-END:variables

}
