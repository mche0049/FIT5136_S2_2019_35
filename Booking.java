
/**
 * Write a description of class Booking here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Booking {
    private String bookingId;
    private String bookingDate;
    private String hallName;
    private String hallOwner;
    private String customerName;
    private String startDate;
    private String endDate;
    private boolean hallStatus;
    private double totalAmount;

    public Booking(String bookingId, String bookingDate, String hallName, String hallOwner, String customerName, String startDate, String endDate, boolean hallStatus, double totalAmount) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.hallName = hallName;
        this.hallOwner = hallOwner;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hallStatus = hallStatus;
        this.totalAmount = totalAmount;
    }

    public Booking() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getHallOwner() { return hallOwner; }

    public void setHallOwner(String hallOwner) { this.hallOwner = hallOwner; }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean getHallStatus() {
        return hallStatus;
    }

    public void setHallStatus(boolean hallStatus) {
        this.hallStatus = hallStatus;
    }

    public double getTotalAmount() { return totalAmount; }

    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
