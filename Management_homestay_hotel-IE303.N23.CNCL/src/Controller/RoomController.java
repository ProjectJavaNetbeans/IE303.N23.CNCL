/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Room;
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
public class RoomController {
    
    private Room model;
    private RoomView view;
    
    public RoomController(Room model, RoomView view) {
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
        ArrayList<Room> rooms = model.getRooms();
        int lastId = rooms.get(rooms.size() - 1).getRoomId(); 
        int RoomId = lastId + 1;
        String Name = view.getRoomName();
        String type = view.getRoomType();
        String rates = view.getRoomRates();
        int ht_id = 111;
        boolean status = view.getStatus();

        model.insertRoom(new Room(RoomId, Name, type, Double.parseDouble(rates), status, ht_id));

        view.displayRoom(model.getRooms());
        view.setVisible(true);
    }
    
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int roomId = Integer.parseInt(view.getRoomId());

        model.deleteRoom(roomId);

        view.displayRoom(model.getRooms());
        view.setVisible(true);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int RoomId = Integer.parseInt(view.getRoomId());
        String Name = view.getRoomName();
        String type = view.getRoomType();
        String rates = view.getRoomRates();
        int ht_id = 111;
        boolean status = view.getStatus();

        model.updateRoom(new Room(RoomId, Name, type, Double.parseDouble(rates), status, ht_id));

        view.displayRoom(model.getRooms());
        view.setVisible(true);
    }
    
    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bookingView = new BookingView();
        bookingView.setVisible(true);
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
    
    public void displayRoomView() {
        view.displayRoom(model.getRooms());
        view.setVisible(true);
    }
}
