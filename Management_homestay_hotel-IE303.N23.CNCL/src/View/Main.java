/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;
import Model.*;
import Controller.*;
/**
 *
 * @author Nhattruong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Service svmodel =  new Service();
        Employee emmodel =  new Employee();
        ServiceView view = new ServiceView();
        ServiceController ctron = new ServiceController(svmodel,emmodel ,view);
        ctron.displayServiceView();
    }
    
}
