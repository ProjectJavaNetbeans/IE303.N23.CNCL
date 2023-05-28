package Model;

public class BillDetail {

    /**
     * Default constructor
     */
    public BillDetail() {
    }

    /**
     * 
     */
    private int bdId;

    /**
     * 
     */
    private int svId;

    /**
     * 
     */
    private int billId;

    /**
     * 
     */
    private double unitPrice;

    public BillDetail(int bdId, int svId, int billId) {
        this.bdId = bdId;
        this.svId = svId;
        this.billId = billId;
        
    }

    public int getBdId() {
        return bdId;
    }

    public int getSvId() {
        return svId;
    }

    public int getBillId() {
        return billId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
}