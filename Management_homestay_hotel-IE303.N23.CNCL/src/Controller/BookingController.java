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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhattruong
 */
public class BookingController {
    
    private Booking bkModel;
    private Room roomModel;
    private BookingView view;
    
    public BookingController(Booking bkModel, Room roomModel, BookingView view){
        this.bkModel = bkModel;
        this.roomModel = roomModel;
        this.view = view;
        
        view.addBookingBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addBookingBtnActionPerformed(e);
            }
        });
        view.updBookingBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updBookingBtnActionPerformed(e);
            }
        });
        view.delBookingBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                delBookingBtnActionPerformed(e);
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
        view.displayBookings(bkModel.getBookings(), roomModel.getRooms());
        view.setVisible(true);
    }
    
    private void addBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ArrayList<Booking> bookings = bkModel.getBookings();
        int bookingId;
        if(bookings.size()<=0) bookingId = 1;
        else{
            int lastId = bookings.get(bookings.size() - 1).getBookingId();
            bookingId = lastId + 1;
        }
        
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String bookingDate = currentDateTime.format(formatter);
        
        String cusPhone = view.getCusPhone();
        String roomName = view.getRoomName();
        String checkInDate = view.getCheckInDate();
        String checkOutDate = view.getCheckOutDate();

        bkModel.addBooking(bookingId, cusPhone, roomName, bookingDate, checkInDate, checkOutDate);
        bkModel.updateRoomStatus(roomName);
        
        // Cap nhat table
        view.displayBookings(bkModel.getBookings(), roomModel.getRooms());
        view.setVisible(true);
    }
    
    private void delBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int bkId = Integer.parseInt(view.getBookingId());

        bkModel.deleteBooking(bkId);

        // Cap nhat table
        view.displayBookings(bkModel.getBookings(), roomModel.getRooms());
        view.setVisible(true);
    }
    
    private void updBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int bkId = Integer.parseInt(view.getBookingId());
        String cusPhone = view.getCusPhone();
        String roomName = view.getRoomName();
        String checkInDate = view.getCheckInDate();
        String checkOutDate = view.getCheckOutDate();

        bkModel.updateBooking(bkId, cusPhone, roomName, checkInDate, checkOutDate);

        // Cap nhat table
        view.displayBookings(bkModel.getBookings(), roomModel.getRooms());
        view.setVisible(true);
    }
    
    private void customerViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        CustomerView cusView = new CustomerView();
        Customer cusModel = new Customer();
        CustomerController controller = new CustomerController(cusModel,cusView);

        controller.displayCustomerView();
    }
    private void roomViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        RoomView roomView = new RoomView();
        Room roomModel = new Room();
        RoomController controller = new RoomController(roomModel,roomView);

        controller.displayRoomView();
    }
    
    private void serviceViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        ServiceView svView = new ServiceView();
        Service svModel = new Service();
        Employee empModel = new Employee();
        ServiceController controller = new ServiceController(svModel, empModel,svView);

        controller.displayServiceView();
    }
    private void billViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BillView billView = new BillView();
        Bill billModel = new Bill();
        BillController controller = new BillController(billModel,billView);

        controller.displayBillView();
    }
    private void logoutViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        LoginView liview = new LoginView();
        LoginController controller = new LoginController(liview);
        controller.displayLoginView();
    }
}
