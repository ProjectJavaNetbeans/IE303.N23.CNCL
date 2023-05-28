package Model;

import java.util.*;

/**
 * 
 */
public class Bill {

    /**
     * Default constructor
     */
    public Bill() {
    }

    /**
     * 
     */
    private int billId;

    /**
     * 
     */
    private int cusId;

    /**
     * 
     */
    private int empId;

    /**
     * 
     */
    private String createDate;

    /**
     * 
     */
    private double totalAmount;

    /**
     * 
     */
    private boolean paidStatus;

    /**
     * 
     */
    private ArrayList<Service> useSvList;
    
    public Bill(int billId, int cusId, int empId, String createDate, double totalAmount, boolean paidStatus) {
        this.billId = billId;
        this.cusId = cusId;
        this.empId = empId;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.paidStatus = paidStatus;
        this.useSvList = new ArrayList<Service>();}

    public int getBillId() {
        return billId;
    }

    public int getCusId() {
        return cusId;
    }

    public int getEmpId() {
        return empId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public ArrayList<Service> getUseSvList() {
        return useSvList;
    }
    
    
}