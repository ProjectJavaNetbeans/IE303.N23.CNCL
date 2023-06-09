/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.*;
import Model.Employee;
import Model.DataConnection;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Hồ Thống
 */
public class EmployeeController {
    private Employee model;
    private EmployeeView view;
    
    public EmployeeController(Employee model, EmployeeView view) {
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
        List<Employee> emps = model.getEmps();
        int lastId = emps.get(emps.size() - 1).getEmpId(); // Lay id moi nhat
        int EmpId = lastId + 1;
        String Name = view.getEmpName();
        int shift = Integer.valueOf(view.getEmpShift());
        String phone = view.getEmpPhone();
        String address = view.getEmpAddress();
        String acc = view.getEmpAcc();
        String pass = view.getEmpPassWord();

        model.insertEmployee(new Employee(EmpId, Name, shift, phone, address, acc,pass));

        // Cap nhat table
        view.displayEmp(model.getEmps());
        view.setVisible(true);
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int empId = Integer.parseInt(view.getEmpID());

        model.removeEmployee(empId);

        // Cap nhat table
        view.displayEmp(model.getEmps());
        view.setVisible(true);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int empId = Integer.parseInt(view.getEmpID());
        String Name = view.getEmpName();
        int shift = Integer.valueOf(view.getEmpShift());
        String phone = view.getEmpPhone();
        String address = view.getEmpAddress();
        String acc = view.getEmpAcc();
        String pass = view.getEmpPassWord();
        

        model.updateEmployee(new Employee(empId, Name, shift, phone, address, acc,pass));

        // Cap nhat table
        view.displayEmp(model.getEmps());
        view.setVisible(true);
    }
    
    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        RoomView roomView = new RoomView();
        Room roomModel = new Room();
        RoomController controller = new RoomController(roomModel,roomView);

        controller.displayRoomView();
    }
    
    private void btnBookingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        BookingView bkView = new BookingView();
        Booking bkModel = new Booking();
        Room roomModel = new Room();
        BookingController controller = new BookingController(bkModel, roomModel, bkView);

        controller.displayBookingView();
    }
    
    private void btnSvActionPerformed(java.awt.event.ActionEvent evt) {                                          
        view.setVisible(false);

        ServiceView svView = new ServiceView();
        Service svModel = new Service();
        Employee empModel = new Employee();
        ServiceController controller = new ServiceController(svModel, empModel,svView);

        controller.displayServiceView();
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
}
