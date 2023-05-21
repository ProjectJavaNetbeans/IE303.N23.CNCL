package Model;

import java.util.ArrayList;
/**
 * 
 */
public class Booking {

    /**
     * Default constructor
     */
    public Booking() {
    }

    /**
     * 
     */
    private int bookingId;

    /**
     * 
     */
    private Customer customer;

    /**
     * 
     */
    private ArrayList<Room> rooms;

    /**
     * 
     */
    private long bookingDate;

    /**
     * 
     */
    private long checkInDate;

    /**
     * 
     */
    private long checkOutDate;
}