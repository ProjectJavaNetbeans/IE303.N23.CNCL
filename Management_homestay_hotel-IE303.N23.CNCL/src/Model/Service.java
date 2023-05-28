package Model;

import java.util.ArrayList;

public class Service {

    /**
     * Default constructor
     */
    public Service() {
    }

    /**
     * 
     */
    private int svId;

    /**
     * 
     */
    private String svName;

    /**
     * 
     */
    private double svPrice;

    private ArrayList<Service> svList;
    
    public int getSvId() {
        return svId;
    }

    public double getSvPrice() {
        return svPrice;
    }
}