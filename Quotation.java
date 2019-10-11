
/**
 * Write a description of class Quotation here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Quotation
{
    private String hallName;
    private String customer;
    private String hallOwner;
    private String startDate;
    private String endDate;
    private String quotationId;
    private boolean quotationStatus;
    private boolean bookStatus;
    private boolean catering;

    public Quotation(){
    }

    public Quotation(String hallName, String customer, String hallOwner, String startDate, String endDate, String quotationId, boolean quotationStatus, boolean bookStatus, boolean catering) {
        this.hallName = hallName;
        this.customer = customer;
        this.hallOwner = hallOwner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quotationId = quotationId;
        this.quotationStatus = quotationStatus;
        this.bookStatus = bookStatus;
        this.catering = catering;
    }


    public String getHallName() {
        return hallName;
    }
    
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getHallOwner() {
        return hallOwner;
    }

    public void setHallOwner(String hallOwner) {
        this.hallOwner = hallOwner;
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

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public boolean getQuotationStatus() {
        return quotationStatus;
    }
    
    public void setQuotationStatus(boolean quotationStatus) {
        this.quotationStatus = quotationStatus;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public boolean getCatering() { return catering;}

    public void setCatering(boolean catering) { this.catering = catering;}
    
}
