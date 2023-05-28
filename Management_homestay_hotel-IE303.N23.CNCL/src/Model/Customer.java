package Model;

import java.util.ArrayList;

public class Customer {

    /**
     * Default constructor
     */
    public Customer() {
    }

    /**
     * 
     */
    private int cusId;

    /**
     * 
     */
    private String cusName;

    /**
     * 
     */
    private String cusPhone;

    /**
     * 
     */
    private String cusAddress;
    
    private ArrayList<Customer> cusList;

    public Customer(int cusId, String cusName, String cusPhone, String cusAddress) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.cusList = new ArrayList<Customer>();
    }
    
    public void addCustomer(int cusId, String cusName, String cusPhone, String cusAddress){
        cusList.add(new Customer(cusId, cusName, cusPhone, cusAddress));
    }
    
}