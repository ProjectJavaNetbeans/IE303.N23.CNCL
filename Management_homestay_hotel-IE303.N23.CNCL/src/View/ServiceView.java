/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Model.Service;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hồ Thống
 */
public class ServiceView extends javax.swing.JFrame {

    /**
     * Creates new form ServiceView
     */
    public ServiceView() {
        initComponents();
        frame = new JFrame("Service Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public String getSvId() {
        return svIDText.getText();
    }
    public String getSvName() {
        return svNameText.getText();
    }
    
    public String getSvPrice() {
        return svPriceText.getText();
    }
    
    public void addBtnListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }
    public void delBtnListener(ActionListener listener) {
        btnDel.addActionListener(listener);
    }
    public void updBtnListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }
    public void bookingViewBtnListener(ActionListener listener) {
        btnBooking.addActionListener(listener);
    }public void roomViewBtnListener(ActionListener listener) {
        btnRoom.addActionListener(listener);
    }
    public void CusViewBtnListener(ActionListener listener) {
        btnCus.addActionListener(listener);
    }
    public void serviceViewBtnListener(ActionListener listener) {
        btnSv.addActionListener(listener);
    }
    public void billViewBtnListener(ActionListener listener) {
        btnBill.addActionListener(listener);
    }
    public void logoutViewBtnListener(ActionListener listener) {
        btnLogout.addActionListener(listener);
    }
    
     public String[][] dataTransfer(List<Service> services){
        int i =0 ;
        String data[][] = new String[services.size()][3];
        for(Service sv : services){
            data[i][0] = String.valueOf(sv.getSvId());
            data[i][1] = sv.getSvName();
            data[i][2] = String.valueOf(sv.getSvPrice());
            i++;
        }
        return data;
     }
    
    public void displayService(List<Service> svs) {
        String[][] data = dataTransfer(svs);
        String[] column = {"Service ID", "Name", "Prices"};
        DefaultTableModel dataModel = new DefaultTableModel(data, column);
        tbSV.setModel(dataModel);
        frame.setVisible(true);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBooking = new javax.swing.JButton();
        btnRoom = new javax.swing.JButton();
        btnCus = new javax.swing.JButton();
        btnSv = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        svPriceText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSV = new javax.swing.JTable();
        svNameText = new javax.swing.JTextField();
        svIDText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/icon home.png"))); // NOI18N
        btnBooking.setText("jButton5");
        btnBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingActionPerformed(evt);
            }
        });
        getContentPane().add(btnBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 70, 70));

        btnRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/icon room.png"))); // NOI18N
        btnRoom.setText("jButton5");
        btnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 80, 70));

        btnCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/image 7.png"))); // NOI18N
        btnCus.setText("jButton5");
        btnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusActionPerformed(evt);
            }
        });
        getContentPane().add(btnCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 80, 70));

        btnSv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/image 4.png"))); // NOI18N
        btnSv.setText("jButton5");
        btnSv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSvActionPerformed(evt);
            }
        });
        getContentPane().add(btnSv, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 80, -1));

        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/image 8.png"))); // NOI18N
        btnBill.setText("jButton5");
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 80, -1));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/image 3.png"))); // NOI18N
        btnLogout.setText("jButton5");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 80, 70));

        btnReload.setBackground(new java.awt.Color(236, 200, 108));
        btnReload.setForeground(new java.awt.Color(51, 51, 51));
        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        getContentPane().add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 620, 80, 50));

        btnAdd.setBackground(new java.awt.Color(111, 236, 108));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 60, 60));

        btnDel.setBackground(new java.awt.Color(236, 108, 108));
        btnDel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 90, 60));

        btnUpdate.setBackground(new java.awt.Color(236, 200, 108));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, 80, 60));

        svPriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svPriceTextActionPerformed(evt);
            }
        });
        getContentPane().add(svPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 210, 40));

        tbSV.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSV);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 500, 300));

        svNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svNameTextActionPerformed(evt);
            }
        });
        getContentPane().add(svNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 210, 40));

        svIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svIDTextActionPerformed(evt);
            }
        });
        getContentPane().add(svIDText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/Service.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingActionPerformed
        // TODO add your handling code here:
        if (bookingViewBtnListener != null) {
            bookingViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnBookingActionPerformed

    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomActionPerformed
        // TODO add your handling code here:
        if (roomViewBtnListener != null) {
            roomViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnRoomActionPerformed

    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusActionPerformed
        // TODO add your handling code here:
        if (CusViewBtnListener != null) {
            CusViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnCusActionPerformed

    private void btnSvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSvActionPerformed
        // TODO add your handling code here:
        if (serviceViewBtnListener != null) {
            serviceViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnSvActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        // TODO add your handling code here:
        if (billViewBtnListener != null) {
            billViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnBillActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        if (logoutViewBtnListener != null) {
            logoutViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (addBtnListener != null) {
            addBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        if (delBtnListener != null) {
            delBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (updBtnListener != null) {
            updBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void svPriceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svPriceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svPriceTextActionPerformed

    private void svNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svNameTextActionPerformed

    private void svIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svIDTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_svIDTextActionPerformed

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
            java.util.logging.Logger.getLogger(ServiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceView().setVisible(true);
            }
        });
    }
    private JFrame frame;
    private ActionListener addBtnListener;
    private ActionListener delBtnListener;
    private ActionListener updBtnListener;
    private ActionListener bookingViewBtnListener;
    private ActionListener roomViewBtnListener;
    private ActionListener CusViewBtnListener;
    private ActionListener serviceViewBtnListener;
    private ActionListener billViewBtnListener;
    private ActionListener logoutViewBtnListener;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnCus;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnRoom;
    private javax.swing.JButton btnSv;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField svIDText;
    private javax.swing.JTextField svNameText;
    private javax.swing.JTextField svPriceText;
    private javax.swing.JTable tbSV;
    // End of variables declaration//GEN-END:variables
}
