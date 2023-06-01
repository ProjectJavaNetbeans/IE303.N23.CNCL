package Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/**
 * 
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/**
 * 
 */
public class Employee {

    /**
     * Default constructor
     */
    public Employee() {
    }

    /**
     * 
     */
    private int empId;

    /**
     * 
     */
    private String empName;

    /**
     * 
     */
    private int shift;

    /**
     * 
     */
    private String empPhone;

    /**
     * 
     */
    private String empAddress;

    /**
     * 
     */
    private String empAccount;

    /**
     * 
     */
    private String empPassword;

    /**
     * @param empId 
     * @param empName 
     * @param shift 
     * @param empPhone 
     * @param empAddress 
     * @param empAccount 
     * @param empPassword
     */
    public Employee(int empId, String empName, int shift, String empPhone, String empAddress, String empAccount, String empPassword) {
        this.empId = empId;
        this.empName = empName;
        this.shift = shift;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
        this.empAccount = empAccount;
        this.empPassword = empPassword;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpAccount() {
        return empAccount;
    }

    public void setEmpAccount(String empAccount) {
        this.empAccount = empAccount;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }
    
    Connection cn = DataConnection.Connect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public void insertEmployee(Employee emp)
    {
        try 
        {
            String sqlUpdate = "INSERT INTO EMPLOYEE (emp_name, shift, emp_phone, emp_address, emp_acc, emp_pass) VALUES ('" +emp.getEmpName() + "', '" +emp.getShift()+ "', '" +emp.getEmpPhone()+ "', '" +emp.getEmpAddress()+ "', '" + emp.getEmpAccount()+ "', '" + emp.getEmpPassword()+ "');";
            String selectAll = "SELECT * FROM EMPLOYEE";
            
            ps = cn.prepareStatement(sqlUpdate);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successful insert!");
            
            ps = cn.prepareStatement(selectAll);
            rs = ps.executeQuery();
        }
        catch(SQLException e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Failed insert!");
        }
        finally
        {
            flushStatementOnly();
        }
    }
    
    public void updateEmployee(Employee emp){
        try {
            String update = "UPDATE EMPLOYEE SET emp_name = '" +emp.getEmpName() + "', shift = '" +emp.getShift()+ "', emp_phone = '" +emp.getEmpPhone()+ "', emp_address = '" +emp.getEmpAddress()+ "', emp_acc = '" +emp.getEmpAccount()+ "', emp_pass = '" +emp.getEmpPassword()+ "'WHERE emp_id = " +emp.getEmpId()+ ";";
            ps = cn.prepareStatement(update);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successful update!");
        }
        catch (SQLException e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Failed update!");
        }
        finally {
            flushStatementOnly();
        }
    }
    
    public ArrayList<Employee> getEmps() {
        ArrayList<Employee> emps = new ArrayList<>();
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = cn.prepareStatement("SELECT * FROM EMPLOYEE");
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                int shift = rs.getInt("shift");
                String phone = rs.getString("emp_phone");
                String address = rs.getString("emp_address");
                String acc = rs.getString("emp_acc");
                String pass = rs.getString("emp_pass");

                Employee emp= new Employee(id, name, shift, phone, address, acc, pass);
                emps.add(emp);
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
        return emps;
    }
    
    public void removeEmployee(int manv){
        try{
            String remove = "DELETE FROM EMPLOYEE WHERE emp_id = " + manv;
            ps = cn.prepareStatement(remove);
            ps.execute();
        }
        catch (SQLException e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại.");
        }
        finally {
            flushStatementOnly();
        }
    }
    
    private void flushStatementOnly()
    {
        try
        {
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println("Closing DataBase!");
        }
    }


}