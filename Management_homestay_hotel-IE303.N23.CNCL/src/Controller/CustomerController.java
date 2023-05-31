/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Customer;
import Model.DataConnection;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhattruong
 */
public class CustomerController {
    
    private Customer model;
    private CustomerView view;

    public CustomerController(Customer model, CustomerView view) {
        this.model = model;
        this.view = view;
        
        view.addCusBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCusBtnActionPerformed(e);
            }
        });
        view.delCusBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delCusBtnActionPerformed(e);
            }
        });
        view.updCusBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updCusBtnActionPerformed(e);
            }
        });
        view.bookingViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookingViewBtnActionPerformed(e);
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
    
    public void displayCustomerView() {
        view.displayCustomers(model.getCustomers());
        view.setVisible(true);

    }
    
    private void addCusBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        List<Customer> customers = model.getCustomers();
        int lastId = customers.get(customers.size() - 1).getCusId(); // Lay id moi nhat
        int cusId = lastId + 1;
        String cusName = view.getCusName();
        String cusEmail = view.getCusEmail();
        String cusPhone = view.getCusPhone();
        String cusAddress = view.getCusAddress();

        model.addCustomer(cusId, cusName, cusEmail, cusPhone, cusAddress);

        // Cap nhat table
        view.displayCustomers(model.getCustomers());
        view.setVisible(true);
    }
    
    private void delCusBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int cusId = Integer.parseInt(view.getCusId());

        model.deleteCustomer(cusId);

        // Cap nhat table
        view.displayCustomers(model.getCustomers());
        view.setVisible(true);
    }
    
    private void updCusBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int cusId = Integer.parseInt(view.getCusId());
        String cusName = view.getCusName();
        String cusEmail = view.getCusEmail();
        String cusPhone = view.getCusPhone();
        String cusAddress = view.getCusAddress();

        model.updateCustomer(cusId, cusName, cusEmail, cusPhone, cusAddress);

        // Cap nhat table
        view.displayCustomers(model.getCustomers());
        view.setVisible(true);
    }
    
    private void bookingViewBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bookingView = new BookingView();
        bookingView.setVisible(true);
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
