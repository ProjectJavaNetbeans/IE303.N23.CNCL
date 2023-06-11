/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Model.*;
import Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nhattruong
 */
public class BillView extends javax.swing.JFrame {

    /**
     * Creates new form BillView
     */
    public BillView() {
        initComponents();
        frame = new JFrame("Bill Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public String getBillId() {
        return billIdTF.getText();
    }
    
    public String getCusId() {
        return cusIdTF.getText();
    }
    
    public String getRoomId() {
        return roomIdTF.getText();
    }

    public String getSvId() {
        return svIdTF.getText();
    }

    public String getCusIdSearch() {
        return cusIdSearchTF.getText();
    }
    
    public boolean getPaidStatus() {
        return false;
    }
        
    public void setCusId(String cusId) {
        cusIdTF.setText(cusId);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bookingViewBtn = new javax.swing.JButton();
        roomViewBtn = new javax.swing.JButton();
        customerViewBtn = new javax.swing.JButton();
        serviceViewBtn = new javax.swing.JButton();
        billViewBtn = new javax.swing.JButton();
        logoutViewBtn = new javax.swing.JButton();
        cusIdSearchTF = new javax.swing.JTextField();
        svIdTF = new javax.swing.JTextField();
        cusIdTF = new javax.swing.JTextField();
        delBillBtn = new javax.swing.JButton();
        updBillBtn = new javax.swing.JButton();
        printBillBtn = new javax.swing.JButton();
        addBillBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        billIdTF = new javax.swing.JTextField();
        cusIdLable = new javax.swing.JLabel();
        roomIdTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillTable = new javax.swing.JTable();
        upstatistic = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookingViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon booking.png"))); // NOI18N
        bookingViewBtn.setBorder(null);
        bookingViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(bookingViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 4, -1, -1));

        roomViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon room.png"))); // NOI18N
        roomViewBtn.setBorder(null);
        roomViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(roomViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 4, -1, -1));

        customerViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon customer.png"))); // NOI18N
        customerViewBtn.setBorder(null);
        customerViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(customerViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 4, -1, -1));

        serviceViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon service.png"))); // NOI18N
        serviceViewBtn.setBorder(null);
        serviceViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(serviceViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 4, -1, -1));

        billViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon bill.png"))); // NOI18N
        billViewBtn.setBorder(null);
        billViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(billViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 4, -1, -1));

        logoutViewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/icon logout.png"))); // NOI18N
        logoutViewBtn.setBorder(null);
        logoutViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutViewBtnActionPerformed(evt);
            }
        });
        jPanel1.add(logoutViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 4, -1, -1));

        cusIdSearchTF.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(cusIdSearchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 697, 120, 25));

        svIdTF.setBorder(null);
        jPanel1.add(svIdTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 360, 30));

        cusIdTF.setBorder(null);
        jPanel1.add(cusIdTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 360, 30));

        delBillBtn.setBackground(new java.awt.Color(236, 108, 108));
        delBillBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delBillBtn.setText("Delete");
        delBillBtn.setBorder(null);
        delBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBillBtnActionPerformed(evt);
            }
        });
        jPanel1.add(delBillBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 325, 130, 30));

        updBillBtn.setBackground(new java.awt.Color(236, 200, 108));
        updBillBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updBillBtn.setText("Update");
        updBillBtn.setBorder(null);
        updBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updBillBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updBillBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 140, 20));

        printBillBtn.setBackground(new java.awt.Color(236, 200, 108));
        printBillBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBillBtn.setText("Calculate");
        printBillBtn.setBorder(null);
        printBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillBtnActionPerformed(evt);
            }
        });
        jPanel1.add(printBillBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 697, 83, 20));

        addBillBtn.setBackground(new java.awt.Color(111, 236, 108));
        addBillBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBillBtn.setText("Add");
        addBillBtn.setBorder(null);
        addBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBillBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBillBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 255, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Bill ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 205, -1, -1));
        jPanel1.add(billIdTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 200, 100, -1));

        cusIdLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cusIdLable.setText("Customer ID:");
        jPanel1.add(cusIdLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, -1, -1));

        roomIdTF.setBorder(null);
        jPanel1.add(roomIdTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 360, 30));

        BillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill ID", "Customer ID", "Room ID", "Service ID", "Create date", "Total Amount", "Paid Status"
            }
        ));
        jScrollPane1.setViewportView(BillTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 780, 140));

        upstatistic.setBackground(new java.awt.Color(236, 200, 108));
        upstatistic.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        upstatistic.setText("Statistics ");
        upstatistic.setBorder(null);
        upstatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upstatisticActionPerformed(evt);
            }
        });
        jPanel1.add(upstatistic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figma/Bill.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    public String[][] dataTransfer(List<Bill> bills){
        int i =0 ;
        String data[][] = new String[bills.size()][7];
        for(Bill bill : bills){
            data[i][0] = String.valueOf(bill.getBillId());
            data[i][1] = String.valueOf(bill.getCusId());
            data[i][2] = String.valueOf(bill.getRoomId());
            data[i][3] = String.valueOf(bill.getSvId());
            data[i][4] = bill.getCreateDate();
            data[i][5] = String.valueOf(bill.getTotalAmount());
            data[i][6] = String.valueOf(bill.getPaidStatus());
            i++;
        }
        return data;
    }
    
    public void displayBills(List<Bill> bills) {
        String[][] data = dataTransfer(bills);
        String[] column = {"Bill ID", "Customer ID", "Room ID", "Service ID", "Create Date", "Total Amount", "Paid Status"};
        DefaultTableModel dataModel = new DefaultTableModel(data, column);
        BillTable.setModel(dataModel);
        frame.setVisible(true);
    }

    public void addBillBtnListener(ActionListener listener) {
        addBillBtn.addActionListener(listener);
    }
    public void delBillBtnListener(ActionListener listener) {
        delBillBtn.addActionListener(listener);
    }
    public void updBillBtnListener(ActionListener listener) {
        updBillBtn.addActionListener(listener);
    }
    public void priBillBtnListener(ActionListener listener) {
        printBillBtn.addActionListener(listener);
    }
    public void bookingViewBtnListener(ActionListener listener) {
        bookingViewBtn.addActionListener(listener);
    }
    public void roomViewBtnListener(ActionListener listener) {
        roomViewBtn.addActionListener(listener);
    }
    public void serviceViewBtnListener(ActionListener listener) {
        serviceViewBtn.addActionListener(listener);
    }
    public void customerViewBtnListener(ActionListener listener) {
       customerViewBtn.addActionListener(listener);
    }
    public void logoutViewBtnListener(ActionListener listener) {
        logoutViewBtn.addActionListener(listener);
    }
    public void statisticsBtnListener(ActionListener listener) {
        upstatistic.addActionListener(listener);
    }
    private void addBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBillBtnActionPerformed
        if (addBillBtnListener != null) {
            addBillBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_addBillBtnActionPerformed

    private void delBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBillBtnActionPerformed
        if (delBillBtnListener != null) {
            delBillBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_delBillBtnActionPerformed

    private void updBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updBillBtnActionPerformed
        if (updBillBtnListener != null) {
            updBillBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_updBillBtnActionPerformed

    private void printBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBillBtnActionPerformed
        if (priBillBtnListener != null) {
            priBillBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_printBillBtnActionPerformed

    private void bookingViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingViewBtnActionPerformed
        if (bookingViewBtnListener != null) {
            bookingViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_bookingViewBtnActionPerformed

    private void roomViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomViewBtnActionPerformed
        if (roomViewBtnListener != null) {
            roomViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_roomViewBtnActionPerformed

    private void customerViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerViewBtnActionPerformed
        if (customerViewBtnListener != null) {
            customerViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_customerViewBtnActionPerformed

    private void serviceViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceViewBtnActionPerformed
       if (serviceViewBtnListener != null) {
            serviceViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_serviceViewBtnActionPerformed

    private void billViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billViewBtnActionPerformed
    }//GEN-LAST:event_billViewBtnActionPerformed

    private void logoutViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutViewBtnActionPerformed
        if (logoutViewBtnListener != null) {
            logoutViewBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_logoutViewBtnActionPerformed

    private void upstatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upstatisticActionPerformed
        // TODO add your handling code here:
        if (statisticsBtnListener != null) {
            statisticsBtnListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_upstatisticActionPerformed

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
            java.util.logging.Logger.getLogger(BillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillView().setVisible(true);
            }
        });
    }
    private JFrame frame;
    private ActionListener addBillBtnListener;
    private ActionListener delBillBtnListener;
    private ActionListener updBillBtnListener;
    private ActionListener priBillBtnListener;
    private ActionListener bookingViewBtnListener;
    private ActionListener roomViewBtnListener;
    private ActionListener serviceViewBtnListener;
    private ActionListener customerViewBtnListener;
    private ActionListener logoutViewBtnListener;
    private ActionListener statisticsBtnListener;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BillTable;
    private javax.swing.JButton addBillBtn;
    private javax.swing.JTextField billIdTF;
    private javax.swing.JButton billViewBtn;
    private javax.swing.JButton bookingViewBtn;
    private javax.swing.JLabel cusIdLable;
    private javax.swing.JTextField cusIdSearchTF;
    private javax.swing.JTextField cusIdTF;
    private javax.swing.JButton customerViewBtn;
    private javax.swing.JButton delBillBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutViewBtn;
    private javax.swing.JButton printBillBtn;
    private javax.swing.JTextField roomIdTF;
    private javax.swing.JButton roomViewBtn;
    private javax.swing.JButton serviceViewBtn;
    private javax.swing.JTextField svIdTF;
    private javax.swing.JButton updBillBtn;
    private javax.swing.JButton upstatistic;
    // End of variables declaration//GEN-END:variables

}
