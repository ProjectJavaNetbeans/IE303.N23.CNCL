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
    
    public double calcTotalAmount(int roomId, int svId){
        double totalAmount = 0;
        if(roomId > 0 && roomId < 3){
            totalAmount += 100000;
        }
        if(roomId > 2 && roomId < 8){
            totalAmount += 250000;
        }
        if(roomId > 7 && roomId < 11){
            totalAmount += 300000;
        }
        if(svId == 101) totalAmount += 40000;
        if(svId == 102) totalAmount += 5000;
        if(svId == 103) totalAmount += 10000;
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
        
        int cusId = Integer.parseInt(view.getCusId());
        int roomId = Integer.parseInt(view.getRoomId());
        int svId = Integer.parseInt(view.getSvId());
        double totalAmount = calcTotalAmount(roomId, svId);
        boolean paidStatus = view.getPaidStatus();

        model.addBill(billId, cusId, roomId, svId, createDate, totalAmount,paidStatus);

        // Cap nhat table
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
    
    private void priBillBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int billId = Integer.parseInt(view.getBillId());

        model.priBill(billId);
        
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
        int cusId = Integer.parseInt(view.getCusId());
        int roomId = Integer.parseInt(view.getRoomId());
        int svId = Integer.parseInt(view.getSvId());
        double totalAmount = calcTotalAmount(roomId, svId);
        boolean paidStatus = view.getPaidStatus();

        model.updateBill(billId, cusId, roomId, svId, totalAmount, paidStatus);

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
