/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Service;
import Model.DataConnection;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hồ Thống
 */
public class ServiceController {
    private Service model;
    private ServiceView view;
    
    public ServiceController(Service model, ServiceView view) {
        this.model = model;
        this.view = view;
        
        view.addBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddActionPerformed(e);
            }
        });
        view.delBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDelActionPerformed(e);
            }
        });
        view.updBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateActionPerformed(e);
            }
        });
        view.bookingViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBookingActionPerformed(e);
            }
        });
        view.roomViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRoomActionPerformed(e);
            }
        });
        view.CusViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCusActionPerformed(e);
            }
        });
        view.serviceViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSvActionPerformed(e);
            }
        });
        view.billViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBillActionPerformed(e);
            }
        });
        view.logoutViewBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogoutActionPerformed(e);
            }
        });
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                          
        List<Service> svs = model.getSvs();
        int lastId = svs.get(svs.size() - 1).getSvId(); // Lay id moi nhat
        int SvId = lastId + 1;
        String Name = view.getSvName();
        double price = Double.valueOf(view.getSvPrice());
        

        model.addService(new Service(SvId, Name,price ));

        // Cap nhat table
        view.displayService(model.getSvs());
        view.setVisible(true);
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int svId = Integer.parseInt(view.getSvId());

        model.deleteService(svId);

        // Cap nhat table
        view.displayService(model.getSvs());
        view.setVisible(true);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int svId = Integer.parseInt(view.getSvId());
        String Name = view.getSvName();
        String price = view.getSvPrice();
        

        model.updateService(new Service(svId, Name, Double.valueOf(price)));

        // Cap nhat table
        view.displayService(model.getSvs());
        view.setVisible(true);
    }
    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bookingView = new BookingView();
        bookingView.setVisible(true);
    }
    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        RoomView roomView = new RoomView();
        roomView.setVisible(true);
    }
    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        CustomerView cusView = new CustomerView();
        cusView.setVisible(true);
    }
    private void btnSvActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        ServiceView serviceView = new ServiceView();
        serviceView.setVisible(true);
    }
    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BillView billView = new BillView();
        billView.setVisible(true);
    }
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        loginView loginView = new loginView();
        loginView.setVisible(true);
    }
}
