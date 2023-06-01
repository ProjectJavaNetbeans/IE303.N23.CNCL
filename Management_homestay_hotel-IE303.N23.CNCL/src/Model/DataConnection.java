/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author Nhattruong
 */
public class DataConnection {
    
    public static Connection Connect()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/MANAGEMENTHOMESTAYHOTEL";
        
        try {
            // Su dung driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Ket noi database
            Connection cn = DriverManager.getConnection(databaseUrl, "admin", "123456");
            System.out.println("Successful connection!");
            return cn;
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found! Err: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.err.println("Unsuccessful connection! Err: " + ex.getMessage());
            return null;
        }
    }

}
