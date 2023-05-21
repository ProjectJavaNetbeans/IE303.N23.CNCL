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
    private String billDate;

    /**
     * 
     */
    private double totalAmount;

    /**
     * 
     */
    private boolean paid;

    /**
     * 
     */
    private ArrayList<BillDetails> billDetails;
    
}