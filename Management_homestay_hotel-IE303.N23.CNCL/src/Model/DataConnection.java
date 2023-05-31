/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Hồ Thống
 */
public class DataConnection {
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Khai báo tên db cần làm việc cần thây thế
    private final static String DATABASE_LINK = "jdbc:mysql://localhost:3306/MANAGEMENTHOMESTAYHOTEL";
    
    /**
     * Hàm kết nối đến db trong MySQL cần làm việc
     * @return 
     */
    public static Connection Connect()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/MANAGEMENTHOMESTAYHOTEL";
        
        try {
 
            //Nạp driver của mysql vào để sử dụng
            Class.forName(JDBC_DRIVER);
            
            // Ket noi database
            Connection cn = DriverManager.getConnection(databaseUrl, "admin", "123456");
            System.out.println("Successful connection!");
            return cn;
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Không tìm thấy driver. Chi tiết: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.err.println("Không kết nối được đến MySQL. Chi tiết: " + ex.getMessage());
            return null;
        }
        
        //Trả về kết nối
        //return conn;
    }

}
