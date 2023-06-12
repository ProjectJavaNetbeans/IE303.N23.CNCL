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
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Nhattruong
 */
public class BillController {
    private Bill model;
    private BillView view;
    
    public BillController(Bill model, BillView view) {
        this.model = model;
        this.view = view;
        
        view.addBillBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addBillBtnActionPerformed(e);
            }
        });
        
        view.delBillBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                delBillBtnActionPerformed(e);
            }
        });
        
        view.updBillBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updBillBtnActionPerformed(e);
            }
        });

          view.priBillBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                priBillBtnActionPerformed(e);
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
        view.bookingViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingViewBtnActionPerformed(e);
            }
        });
        view.logoutViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutViewBtnActionPerformed(e);
            }
        });
    }
    
    public double calcTotalAmount(String cusPhone, String roomName, String svName){
        double totalAmount = 0;
        double svPrice = model.getServicePrice(svName);
        if(roomName.equals("P01") || roomName.equals("P02")){
            totalAmount += 100000 + svPrice;
        }
        if(roomName.equals("P03") || roomName.equals("P04") || roomName.equals("P05") || roomName.equals("P06") || roomName.equals("P07")){
            totalAmount += 250000 + svPrice;
        }
        if(roomName.equals("P08") || roomName.equals("P09") || roomName.equals("P10")){
            totalAmount += 300000 + svPrice;
        }
        return totalAmount;
    }
    
    private void addBillBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        List<Bill> bills = model.getBills();
        int billId;
        if(bills.size() <= 0) billId = 121; 
        else {
            int lastId = bills.get(bills.size() - 1).getBillId();
            billId = lastId + 1;
        } // Lay id moi nhat
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String createDate = currentDateTime.format(formatter);
        
        String cusPhone = view.getCusPhone();
        String roomName = view.getRoomName();
        String svName = view.getSvName();
        double totalAmount = calcTotalAmount(cusPhone, roomName, svName);
        boolean paidStatus = view.getPaidStatus();

        model.addBill(billId, cusPhone, roomName, svName, createDate, totalAmount,paidStatus);

        // Cap nhat table
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
    
    private void priBillBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        model.priBill(view.getCusPhoneSearch());
        
        // Cap nhat table
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
    
    private void delBillBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int billId = Integer.parseInt(view.getBillId());

        model.deleteBill(billId);

        // Cap nhat table
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
    
    private void updBillBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int billId = Integer.parseInt(view.getBillId());
        String cusPhone = view.getCusPhone();
        String roomName = view.getRoomName();
        String svName = view.getSvName();
        double totalAmount = calcTotalAmount(cusPhone, roomName, svName);
        boolean paidStatus = view.getPaidStatus();

        model.updateBill(billId, cusPhone, roomName, svName, totalAmount, paidStatus);

        view.displayBills(model.getBills());
        view.setVisible(true);
    }
    
    private void bookingViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bkView = new BookingView();
        Booking bkModel = new Booking();
        Room roomModel = new Room();
        BookingController controller = new BookingController(bkModel, roomModel, bkView);

        controller.displayBookingView();
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
    private void customerViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        CustomerView cusView = new CustomerView();
        Customer cusModel = new Customer();
        CustomerController controller = new CustomerController(cusModel,cusView);

        controller.displayCustomerView();
    }
    private void logoutViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        LoginView liview = new LoginView();
        LoginController controller = new LoginController(liview);
        controller.displayLoginView();
    }
    
    public void displayBillView() {
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
}
