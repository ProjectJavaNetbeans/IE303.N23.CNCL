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

/**
 *
 * @author Nhattruong
 */
public class BookingController {
    Connection cn = DataConnection.Connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    // Them don dat phong
    public void addBooking(int cusId, int roomId, JDateChooser checkInDate, JDateChooser checkOutDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String checkinDate = dateFormat.format(checkInDate.getDate());
        String checkoutDate = dateFormat.format(checkOutDate.getDate());
        
        System.out.println(checkinDate);
        System.out.println(checkoutDate);

        try
        {
            String addBook = "INSERT INTO BOOKING(cusId, roomId, checkInDate, checkOutDate)values("
                    + cusId + "," + roomId + "," + "'" + checkinDate + "'" +"," + "'" + checkoutDate + "'" + ")";
            System.out.print(addBook);
            
            ps =cn.prepareStatement(addBook);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
        }
        finally
            {
                try
            {
                ps.close();
            }
            catch(Exception e)
            {
                System.out.println("Closing DataBase!");
            }
        }       
    }
    // Xoa don dat phong
    public void deleteBooking(int cusId, int roomId, Date checkInDate, Date checkOutDate){
        
    }
    // Sua don dat phong
    public void updateBooking(int cusId, int roomId, Date checkInDate, Date checkOutDate){
        
    }
    
}
