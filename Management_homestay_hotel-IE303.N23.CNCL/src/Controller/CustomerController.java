/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Customer;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Nhattruong
 */
public class CustomerController {
    
    // Them khach hang
    public void addCustomer(int cusId, String cusName, long cusPhone, String cusAddress){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        String sqlInsert = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?)";
        String selectAll = "SELECT * FROM CUSTOMER";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, cusId);
            ps.setString(2, cusName);
            ps.setLong(3, cusPhone);
            ps.setString(4, cusAddress);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Customer
            rs = ps.executeQuery();
            // xuat du lieu
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getLong(3) + "  " + rs.getString(4));
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
    
    // Xoa khach hang
    public void deleteCustomer(int cusId){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlDelete = "DELETE FROM CUSTOMER WHERE cusId = ?";

            ps = cn.prepareStatement(sqlDelete);
            ps.setInt(1, cusId);

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
    
    // Sua khach hang
    public void updateBooking(int cusId, String cusName, long cusPhone, String cusAddress){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BOOKING SET cusId = ?, roomId = ?, checkInDate = ?, checkOutDate = ? WHERE bookingId = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.setString(2, cusName);
            ps.setLong(3, cusPhone);
            ps.setString(4, cusAddress);

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
