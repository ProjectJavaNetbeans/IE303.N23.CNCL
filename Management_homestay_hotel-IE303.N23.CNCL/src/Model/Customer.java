package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Customer {

    /**
     * Default constructor
     */
    public Customer() {
    }

    /**
     * 
     */
    private int cusId;

    /**
     * 
     */
    private String cusName;
    
    /**
     * 
     */
    private String cusEmail;

    /**
     * 
     */
    private String cusPhone;

    /**
     * 
     */
    private String cusAddress;
    
    public Customer(int cusId, String cusName, String cusEmail, String cusPhone, String cusAddress) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public int getCusId() {
        return cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    // Lay danh sach khach hang
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM CUSTOMER");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cus_id");
                String name = rs.getString("cus_name");
                String email = rs.getString("cus_email");
                String phone = rs.getString("cus_phone");
                String address = rs.getString("cus_address");

                Customer customer = new Customer(id, name, email, phone, address);
                customers.add(customer);
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
        return customers;
    }

    // Them khach hang
    public void addCustomer(int cusId, String cusName, String cusEmail, String cusPhone, String cusAddress){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
            
        String sqlInsert = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?)";
        String selectAll = "SELECT * FROM CUSTOMER";
        try
        {            
            ps =cn.prepareStatement(sqlInsert);
            ps.setInt(1, cusId);
            ps.setString(2, cusName);
            ps.setString(3, cusEmail);
            ps.setString(4, cusPhone);
            ps.setString(5, cusAddress);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            // Lay du lieu tu bang Customer
            rs = ps.executeQuery();
            // xuat du lieu
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
            }
            ps.close();
            cn.close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Unsccessful insert!");
        }
    }
    
    // Xoa khach hang
    public void deleteCustomer(String cusPhoneNumSearch){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlDelete = "DELETE FROM CUSTOMER WHERE cus_phone = ?";

            ps = cn.prepareStatement(sqlDelete);
            ps.setString(1, cusPhoneNumSearch);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful delete!");
            } else {
                JOptionPane.showMessageDialog(null, "Phone Number not found!");
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
    public void updateCustomer(String cusPhoneNumSearch, String cusName, String cusEmail, String cusPhone, String cusAddress){
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        
        try {
            String sqlUpdate = "UPDATE CUSTOMER SET cus_name = ?, cus_email = ?, cus_phone = ?, cus_address = ? WHERE cus_phone = ?";

            ps = cn.prepareStatement(sqlUpdate);
            ps.setString(1, cusName);
            ps.setString(2, cusEmail);
            ps.setString(3, cusPhone);
            ps.setString(4, cusAddress);
            ps.setString(5, cusPhoneNumSearch);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Successful update customer!");
            } else {
                JOptionPane.showMessageDialog(null, "Phone Number not found!");
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