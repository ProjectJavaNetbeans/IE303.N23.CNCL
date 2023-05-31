package Model;

import java.util.*;
import View.BillView;
import java.sql.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * 
 */
public class Bill {

    /**
     * Default constructor
     */
    public Bill() {
    }

    /**
     * 
     */
    private int billId;

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
    private int svId;
    
    /**
     * 
     */
    private String createDate;

    /**
     * 
     */
    private double totalAmount;

    /**
     * 
     */
    private boolean paidStatus;

    public Bill(int billId, int cusId, int roomId, int svId, String createDate, double totalAmount, boolean paidStatus) {
        this.billId = billId;
        this.cusId = cusId;
        this.roomId = roomId;
        this.svId = svId;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.paidStatus = paidStatus;
    }

    public int getBillId() {
        return billId;
    }

    public int getCusId() {
        return cusId;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getSvId() {
        return svId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Boolean getPaidStatus() {
        return paidStatus;
    }
    
    // Lay danh sach hoa don
    public List<Bill> getBills() {
        List<Bill> bills = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM BILL");
            rs = ps.executeQuery();

            while (rs.next()) {
                int billId = rs.getInt("bill_id");
                int cusId = rs.getInt("cus_id");
                int roomId = rs.getInt("room_id");
                int svId = rs.getInt("sv_id");
                String createDate = rs.getString("create_date");
                Double totalAmount = rs.getDouble("total_amount");
                Boolean paidStatus = rs.getBoolean("paid_status");

                Bill bill = new Bill(billId, cusId, roomId, svId, createDate, totalAmount, paidStatus);
                bills.add(bill);
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
        return bills;
    }
    
    // Them hoa don
    public void addBill(int billId, int cusId, int roomId, int svId, String createDate, double totalAmount, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sqlInsert = "INSERT INTO BILL VALUES(?, ?, ?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM BILL";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, billId);
            ps.setInt(2, cusId);
            ps.setInt(3, roomId);
            ps.setInt(4, svId);
            ps.setString(5, createDate);
            ps.setDouble(6, totalAmount);
            ps.setBoolean(7, paidStatus);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Booking
            rs = ps.executeQuery();
            // xuat du lieu
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4) + "  " + rs.getString(5) + "  " + rs.getDouble(6) + "  " + rs.getBoolean(7));
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
            String sqlDelete = "DELETE FROM BILL WHERE bill_id = ?";

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
    public void updateBill(int billId, int cusId, int roomId, int svId, double totalAmount, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BILL SET cus_id = ?, room_id = ?, sv_id = ?, total_amount = ?, paid_status = ? WHERE bill_id = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.setInt(2, roomId);
            ps.setInt(3, svId);
            ps.setDouble(4, totalAmount);
            ps.setBoolean(5, paidStatus);
            ps.setInt(6, billId);

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
    
    // In hoa don
    public void priBill(int cusId) {
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlSearch =  "SELECT SUM(total_amount) AS total_amount_sum FROM BILL WHERE cus_id = ?";
        String sqlUpdate =  "UPDATE BILL SET paid_status = true WHERE cus_id = ?";
        try {            
            ps = cn.prepareStatement(sqlSearch);
            ps.setInt(1, cusId);
            
            ps.execute();

            rs = ps.executeQuery();
            if (rs.next()) {
                Double totalAmountSum = rs.getDouble("total_amount_sum");
                JOptionPane.showMessageDialog(null, "Customer ID: " + cusId + "\nTotal Amount: " + totalAmountSum);
            }

            ps = cn.prepareStatement(sqlUpdate);
            ps.setInt(1, cusId);
            ps.execute();
            
            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        } catch(SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsccessful insert!");
        }
    }
}