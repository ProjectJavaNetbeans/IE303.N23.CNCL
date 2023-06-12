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
 * @author Hồ Thống
 */
public class StatisticController {
    private Bill model;
    private StatisticView view;
    
    public StatisticController(Bill model, StatisticView view){
        this.model = model;
        this.view = view;
        
        view.exitBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                exitBtnActionPerformed(e);
            }
        });
        view.confirmBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                confirmBtnActionPerformed(e);
            }
        });
    }
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        view.setVisible(false);

        BillView billView = new BillView();
        Bill billModel = new Bill();
        BillController controller = new BillController(billModel,billView);

        controller.displayBillView();
    }
    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {
        double result = 0 ;
        String year = view.getYear();
        List<Bill> bills = model.getBills();
        for(Bill b: bills){
            if(b.getPaidStatus() && (b.getCreateDate().substring(0,4).equals(year))){
                result += b.getTotalAmount();
            }
        }
        view.setResult(String.valueOf(result));
    }
    
    public void displayStatisticView() {
        view.displayBills(model.getBills());
        view.setVisible(true);
    }
}
