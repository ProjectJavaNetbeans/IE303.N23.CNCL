/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import View.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Nhattruong
 */
public class BookingController {
    
    private Booking model;
    private BookingView view;
    
    public BookingController(Booking model, BookingView view){
        this.model = model;
        this.view = view;
        
        view.addBookingBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addBookingBtnActionPerformed(e);
            }
        });
        view.customerViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerViewBtnActionPerformed(e);
            }
        });
        view.roomViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                roomViewBtnActionPerformed(e);
            }
        });
        view.serviceViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serviceViewBtnActionPerformed(e);
            }
        });
        view.billViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                billViewBtnActionPerformed(e);
            }
        });
        view.logoutViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutViewBtnActionPerformed(e);
            }
        });
    }
    
    public void displayBookingView() {
        view.displayBookings(model.getBookings());
        view.setVisible(true);

    }
    
    private void addBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        List<Booking> bookings = model.getBookings();
        int lastId = bookings.get(bookings.size() - 1).getBookingId(); // Lay id moi nhat
        int bookingId = lastId + 1;
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String bookingDate = currentDateTime.format(formatter);
        
        String cusName = view.getBookingId();
        String cusEmail = view.getCusEmail();
        String cusPhone = view.getCusPhone();
        String cusAddress = view.getCusAddress();

        model.addCustomer(cusId, cusName, cusEmail, cusPhone, cusAddress);

        // Cap nhat table
        view.displayCustomers(model.getCustomers());
        view.setVisible(true);
    }
    
    private void customerViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        CustomerView customerView = new CustomerView();
        customerView.setVisible(true);
    }
    private void roomViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        RoomView roomView = new RoomView();
        roomView.setVisible(true);
    }
    
    private void serviceViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        ServiceView serviceView = new ServiceView();
        serviceView.setVisible(true);
    }
    private void billViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BillView billView = new BillView();
        billView.setVisible(true);
    }
    private void logoutViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        loginView loginView = new loginView();
        loginView.setVisible(true);
    }
}
