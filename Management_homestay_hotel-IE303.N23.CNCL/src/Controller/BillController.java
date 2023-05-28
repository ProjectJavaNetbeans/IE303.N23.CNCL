/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bill;
import View.BillView;
import Model.Service;
import java.sql.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nhattruong
 */
public class BillController {
    private Bill model;
    private BillView view;
    
    public BillController(Bill model, BillView view) {
        this.model = model;
        this.view = view;
    }
    
    public double calcTotalAmount(){
        double total = 0;
        for(Service sv : model.getUseSvList()){
            total += sv.getSvPrice();
        }
        return total;
    }
    
    public Service billDetailSearch(int svId){
        for(Service sv : model.getUseSvList()){
            if(sv.getSvId() == svId){
                return sv;
            }
        }
        return null;
    }
    
    public void addUseService(Service sv){
        model.getUseSvList().add(sv);
    }
    
    // Them hoa don
    public void addBill(int billId, int cusId, int empId, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String createDate = currentDateTime.format(formatter); 
        
        String sqlInsert = "INSERT INTO BILL VALUES(?, ?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM BILL";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, billId);
            ps.setInt(2, cusId);
            ps.setInt(3, empId);
            ps.setString(4, createDate);
            ps.setDouble(5, calcTotalAmount());
            ps.setBoolean(6, paidStatus);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Booking
            rs = ps.executeQuery();
            // xuat du lieu
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getDouble(5) + "  " + rs.getBoolean(6));
            }
            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsccessful insert!");
        }
    }
    
    // Xoa hoa don
    public void deleteBill(int billId){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlDelete = "DELETE FROM BILL WHERE billId = ?";

            ps = cn.prepareStatement(sqlDelete);
            ps.setInt(1, billId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful delete!");
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found!");
            }
            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsuccessful delete!");
        } 
    }
    
    // Sua hoa don
    public void updateBill(int billId, int cusId, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BILL SET cusId = ?, totalAmount = ?, paidStatus = ? WHERE billId = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.setDouble(2, calcTotalAmount());
            ps.setBoolean(3, paidStatus);
            ps.setInt(4, billId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful update!");
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found!");
            }
            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsuccessful update!");
        }
    }
}
