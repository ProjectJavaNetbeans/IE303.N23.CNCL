package Model;


import java.util.*;
import View.BillView;
import View.StatisticView;
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
    private String cusPhone;

    /**
     * 
     */
    private String roomName;

    /**
     * 
     */
    private String svName;
    
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

    public Bill(int billId, String cusPhone, String roomName, String svName, String createDate, double totalAmount, boolean paidStatus) {
        this.billId = billId;
        this.cusPhone = cusPhone;
        this.roomName = roomName;
        this.svName = svName;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.paidStatus = paidStatus;
    }

    public int getBillId() {
        return billId;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getSvName() {
        return svName;
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
                String cusPhone = rs.getString("cus_phone");
                String roomName = rs.getString("room_name");
                String svName = rs.getString("sv_name");
                String createDate = rs.getString("create_date");
                Double totalAmount = rs.getDouble("total_amount");
                Boolean paidStatus = rs.getBoolean("paid_status");

                Bill bill = new Bill(billId, cusPhone, roomName, svName, createDate, totalAmount, paidStatus);
                bills.add(bill);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data download failed!" + ex);
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
    public void addBill(int billId, String cusPhone, String roomName, String svName, String createDate, double totalAmount, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sqlInsert = "INSERT INTO BILL VALUES(?, ?, ?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM BILL";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, billId);
            ps.setString(2, cusPhone);
            ps.setString(3, roomName);
            ps.setString(4, svName);
            ps.setString(5, createDate);
            ps.setDouble(6, totalAmount);
            ps.setBoolean(7, paidStatus);
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
                JOptionPane.showMessageDialog(null, "Bill ID not found!");
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
    public void updateBill(int billId, String cusPhone, String roomName, String svName, double totalAmount, boolean paidStatus){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE BILL SET cus_phone = ?, room_name = ?, sv_name = ?, total_amount = ?, paid_status = ? WHERE bill_id = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setString(1, cusPhone);
            ps.setString(2, roomName);
            ps.setString(3, svName);
            ps.setDouble(4, totalAmount);
            ps.setBoolean(5, paidStatus);
            ps.setInt(6, billId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful update!");
            } else {
                JOptionPane.showMessageDialog(null, "Bill ID not found!");
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
    public void priBill(String cusPhone) {
        try (
            Connection cn = DataConnection.Connect();
            PreparedStatement psSearch = cn.prepareStatement("SELECT SUM(total_amount) AS total_amount_sum, room_name FROM BILL WHERE cus_phone = ? GROUP BY room_name");
            PreparedStatement psUpdateBill = cn.prepareStatement("UPDATE BILL SET paid_status = true WHERE cus_phone = ?");
            PreparedStatement psUpdateRoom = cn.prepareStatement("UPDATE ROOM SET room_status = false WHERE room_name = ?")) {

            psSearch.setString(1, cusPhone);
            psSearch.execute();

            try (ResultSet rs = psSearch.executeQuery()) {
                if (rs.next()) {
                    Double totalAmountSum = rs.getDouble("total_amount_sum");
                    String roomNAME = rs.getString("room_name");
                    JOptionPane.showMessageDialog(null, "Customer Phone: " + cusPhone + "\nTotal Amount: " + totalAmountSum);

                    psUpdateBill.setString(1, cusPhone);
                    psUpdateBill.execute();

                    psUpdateRoom.setString(1, roomNAME);
                    psUpdateRoom.execute();
                }
            }

            System.out.println("Closing DataBase!");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsuccessful print bill!");
        }
    }

    public double getServicePrice(String svName) {
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlGetServicePrice = "SELECT sv_price FROM SERVICE WHERE sv_name = ?";

        double svPrice = 0.0;

        try {            
            ps = cn.prepareStatement(sqlGetServicePrice);
            ps.setString(1, svName);

            ps.execute();

            rs = ps.executeQuery();
            
            if (rs.next()) {
                svPrice = rs.getDouble("sv_price");
                JOptionPane.showMessageDialog(null, "Service (" + svName + ") :" + svPrice + "đ");
            }

            ps.close();
            cn.close();
            System.out.println("Closing DataBase!");
        } catch(SQLException ex) {
            System.out.println("Failed get price! Err: " + ex);
        }

        return svPrice;
    }

}