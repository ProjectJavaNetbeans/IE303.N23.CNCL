/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Booking;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nhattruong
 */
public class BookingController {
    
    // Them don dat phong
    public void addBooking(int bookingId, int cusId, int roomId, JDateChooser checkInDate, JDateChooser checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String checkinDate = dateFormat.format(checkInDate.getDate());
        String checkoutDate = dateFormat.format(checkOutDate.getDate());
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String bookingDate = currentDateTime.format(formatter); 
        
        System.out.println(checkinDate);
        System.out.println(checkoutDate);
        
        String sqlInsert = "INSERT INTO BOOKING VALUES(?, ?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM BOOKING";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, bookingId);
            ps.setInt(2, cusId);
            ps.setInt(3, roomId);
            ps.setString(4, bookingDate);
            ps.setString(5, checkinDate);
            ps.setString(6, checkoutDate);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Booking
            rs = ps.executeQuery();
            // xuat du lieu
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
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
    
    // Xoa don dat phong
    public void deleteBooking(int bookingId){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlDelete = "DELETE FROM BOOKING WHERE bookingId = ?";

            ps = cn.prepareStatement(sqlDelete);
            ps.setInt(1, bookingId);

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
    
    // Sua don dat phong
    public void updateBooking(int bookingId, int cusId, int roomId, Date checkInDate, Date checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BOOKING SET cusId = ?, roomId = ?, checkInDate = ?, checkOutDate = ? WHERE bookingId = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.setInt(2, roomId);
            ps.setDate(3, new java.sql.Date(checkInDate.getTime()));
            ps.setDate(4, new java.sql.Date(checkOutDate.getTime()));
            ps.setInt(5, bookingId);

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
