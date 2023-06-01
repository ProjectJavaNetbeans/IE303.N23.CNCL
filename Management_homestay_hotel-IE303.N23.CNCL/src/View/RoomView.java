/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.ActionListener;
import Model.Room;
import Controller.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 *
 * @author Hồ Thống
 */
public class RoomView extends javax.swing.JFrame {

    /**
     * Creates new form Room_View
     */
    public RoomView() {
        initComponents();
        frame = new JFrame("Room Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String getRoomID() {
        return textID.getText();
    }
    public String getRoomName() {
        return textName.getText();
    }
    
    public String getRoomType() {
        return textType.getText();
    }
    
    public String getRoomRates() {
        return textRates.getText();
    }
    
    public String getHTID() {
        return textHTID.getText();
    }
    
    public String getStatus(){
        return String.valueOf(checkStatus.isSelected());
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
    }
    public void roomViewBtnListener(ActionListener listener) {
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
    
    public String[][] dataTransfer(List<Room> rooms){
        int i =0 ;
        String data[][] = new String[rooms.size()][6];
        for(Room room : rooms){
            data[i][0] = String.valueOf(room.getRoomId());
            data[i][1] = room.getRoomName();
            data[i][2] = room.getRoomType();
            data[i][3] = String.valueOf(room.getRoomRates());
            data[i][4] = String.valueOf(room.getHtID());
            data[i][5] = String.valueOf(room.isRoomStatus());
            i++;
        }
        return data;
    }
        public void displayRoom(List<Room> rooms) {
        String[][] data = dataTransfer(rooms);
        String[] column = {"Room ID", "Name", "Type", "Rates", "Ht ID", "Status"};
        DefaultTableModel dataModel = new DefaultTableModel(data, column);
        roomtb.setModel(dataModel);
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
        textID = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        textType = new javax.swing.JTextField();
        textRates = new javax.swing.JTextField();
        textHTID = new javax.swing.JTextField();
        checkStatus = new javax.swing.JCheckBox();
        btnReload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomtb = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

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

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });
        getContentPane().add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 210, 30));

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });
        getContentPane().add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 210, 30));

        textType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTypeActionPerformed(evt);
            }
        });
        getContentPane().add(textType, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 210, 30));

        textRates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRatesActionPerformed(evt);
            }
        });
        getContentPane().add(textRates, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 210, 40));

        textHTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHTIDActionPerformed(evt);
            }
        });
        getContentPane().add(textHTID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 210, 30));

        checkStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkStatus.setText("Available");
        checkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatusActionPerformed(evt);
            }
        });
        getContentPane().add(checkStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 110, -1));

        btnReload.setBackground(new java.awt.Color(236, 200, 108));
        btnReload.setForeground(new java.awt.Color(51, 51, 51));
        btnReload.setText("Reload");
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });
        getContentPane().add(btnReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 80, 50));

        btnUpdate.setBackground(new java.awt.Color(236, 200, 108));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 80, 60));

        btnDel.setBackground(new java.awt.Color(236, 108, 108));
        btnDel.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 90, 60));

        btnAdd.setBackground(new java.awt.Color(111, 236, 108));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 60, 60));

        roomtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room ID", "Name", "Type", "Rates", "ht ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(roomtb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 500, 380));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/figma/Room (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textIDActionPerformed

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textNameActionPerformed

    private void textTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTypeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textTypeActionPerformed

    private void textRatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRatesActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textRatesActionPerformed

    private void textHTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHTIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHTIDActionPerformed

    private void checkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkStatusActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (updBtnListener != null) {
            updBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        if (delBtnListener != null) {
            delBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (addBtnListener != null) {
            addBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(RoomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomView().setVisible(true);
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
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomtb;
    private javax.swing.JTextField textHTID;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textRates;
    private javax.swing.JTextField textType;
    // End of variables declaration//GEN-END:variables
}