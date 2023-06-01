package Model;

import java.util.ArrayList;
import Model.DataConnection;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 */
public class Booking {

    /**
     * Default constructor
     */
    public Booking() {
    }

    /**
     * 
     */
    private int bookingId;

    /**
     * 
     */
    private int cusId;

    /**
     * 
     */
    private int roomId;

    /**
     * 
     */
    private String bookingDate;

    /**
     * 
     */
    private String checkInDate;

    /**
     * 
     */
    private String checkOutDate;

    public Booking(int bookingId, int cusId, int roomId, String bookingDate, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.cusId = cusId;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCusId() {
        return cusId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    // Lay danh sach don dat phong
    public ArrayList<Booking> getBookings() {
        ArrayList<Booking> Bookings = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM BOOKING");
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookingID = rs.getInt("booking_id");
                int cusID = rs.getInt("cus_id");
                int roomID = rs.getInt("room_id");
                String bookingDATE = rs.getString("booking_date");
                String checkInDATE = rs.getString("check_in_date");
                String checkOutDATE = rs.getString("check_out_date");

                Booking booking = new Booking(bookingID, cusID, roomID, bookingDATE, checkInDATE, checkOutDATE);
                Bookings.add(booking);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data download failed!");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
            }
        }
        return Bookings;
    }
    
    // Them don dat phong
    public void addBooking(int bookingId, int cusId, int roomId, String bookingDate, String checkInDate, String checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        String sqlInsert = "INSERT INTO BOOKING VALUES(?, ?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM BOOKING";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, bookingId);
            ps.setInt(2, cusId);
            ps.setInt(3, roomId);
            ps.setString(4, bookingDate);
            ps.setString(5, checkInDate);
            ps.setString(6, checkOutDate);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Booking
            rs = ps.executeQuery();
            
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
            String sqlDelete = "DELETE FROM BOOKING WHERE booking_id = ?";

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
    public void updateBooking(int bookingId, int cusId, int roomId, String checkInDate, String checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BOOKING SET cus_id = ?, room_id = ?, check_in_date = ?, check_out_date = ? WHERE booking_id = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.setInt(2, roomId);
            ps.setString(3, checkInDate);
            ps.setString(4, checkOutDate);
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
    
    public void updateRoomStatus(int roomId){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE ROOM SET room_status = ? WHERE room_id = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setBoolean(1, true);
            ps.setInt(2, roomId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful update room status!");
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