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
import java.util.ArrayList;
/**
 *
 * @author Hồ Thống
 */
public class ServiceController {
    private Service svModel;
    private Employee empModel;
    private ServiceView view;
    
    public ServiceController(Service svModel, Employee empModel, ServiceView view) {
        this.svModel = svModel;
        this.empModel = empModel;
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
        ArrayList<Service> svs = svModel.getServices();
        int lastId = svs.get(svs.size() - 1).getSvId(); // Lay id moi nhat
        int SvId = lastId + 1;
        String Name = view.getSvName();
        double price = Double.parseDouble(view.getSvPrice());
        

        svModel.addService(new Service(SvId, Name,price ));

        view.displayService(svModel.getServices(), empModel.getEmps());
        view.setVisible(true);
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int svId = Integer.parseInt(view.getSvId());

        svModel.deleteService(svId);

        // Cap nhat table
        view.displayService(svModel.getServices(), empModel.getEmps());
        view.setVisible(true);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int svId = Integer.parseInt(view.getSvId());
        String Name = view.getSvName();
        String price = view.getSvPrice();
        

        svModel.updateService(new Service(svId, Name, Double.valueOf(price)));

        // Cap nhat table
        view.displayService(svModel.getServices(), empModel.getEmps());
        view.setVisible(true);
    }

    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bkView = new BookingView();
        Booking bkModel = new Booking();
        Room roomModel = new Room();
        BookingController controller = new BookingController(bkModel, roomModel, bkView);

        controller.displayBookingView();
    }
    
    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        RoomView roomView = new RoomView();
        Room roomModel = new Room();
        RoomController controller = new RoomController(roomModel,roomView);

        controller.displayRoomView();
    }
    
    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        CustomerView cusView = new CustomerView();
        Customer cusModel = new Customer();
        CustomerController controller = new CustomerController(cusModel,cusView);

        controller.displayCustomerView();
    }
   
    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BillView billView = new BillView();
        Bill billModel = new Bill();
        BillController controller = new BillController(billModel,billView);

        controller.displayBillView();
    }
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        LoginView liview = new LoginView();
        LoginController controller = new LoginController(liview);
        controller.displayLoginView();
    }
    
    public void displayServiceView() {
        view.displayService(svModel.getServices(), empModel.getEmps());
        view.setVisible(true);
    }
}
