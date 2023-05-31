package Model;

import java.util.ArrayList;
import Model.DataConnection;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    public List<Booking> getBookings() {
        List<Booking> Bookings = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM BOOKING");
            rs = ps.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("booking_id");
                int cusId = rs.getInt("cus_id");
                int roomId = rs.getInt("room_id");
                String bookingDate = rs.getString("booking_date");
                String checkInDate = rs.getString("check_in_date");
                String checkOutDate = rs.getString("check_out_date");

                Booking booking = new Booking(bookingId, cusId, roomId, bookingDate, checkInDate, checkOutDate);
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
    public void addBooking(int bookingId, int cusId, int roomId, String bookingDate, JDateChooser checkInDate, JDateChooser checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String checkinDate = dateFormat.format(checkInDate.getDate());
        String checkoutDate = dateFormat.format(checkOutDate.getDate());
        
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
    public void updateBooking(int bookingId, int cusId, int roomId, Date checkInDate, Date checkOutDate){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BOOKING SET booking_id = ?, room_id = ?, check_in_date = ?, check_out_date = ? WHERE booking_id = ?";

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