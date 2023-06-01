package Model;


import java.util.*;

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

    /**
     * @param bookingId 
     * @param bookingDate 
     * @param checInDate 
     * @param checkOutDate
     */
    public Booking(int bookingId, Customer customer, ArrayList<Room> rooms, long bookingDate, long checkInDate, long checkOutDate) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.rooms = rooms;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }



}