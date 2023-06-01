/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nhattruong
 */
public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
        
        
        view.loginBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginBtnActionPerformed(e);
            }
        });
    }
    
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String username = view.getUserName();
        String password = view.getPassword();
             System.out.println("222");

        boolean loginSuccess = login(username, password);
             System.out.println("222");

        if (loginSuccess) {
            view.setVisible(false);

            CustomerView view = new CustomerView();
            Customer model = new Customer();
            CustomerController controller = new CustomerController(model,view);

            controller.displayCustomerView();

        } else {
            JOptionPane.showMessageDialog(view, "Login failed! Invalid username or password!");
        }    
    }
    
    public boolean login(String username, String password) {
        Connection cn = DataConnection.Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) AS count FROM EMPLOYEE WHERE emp_acc = ? AND emp_pass = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if(count > 0) return true; 
            }
            
         
        } 
        catch(SQLException ex) {
            System.out.println(ex);
        }  finally {
        // Đóng kết nối và các đối tượng PreparedStatement, ResultSet
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        return false;
    }
}
