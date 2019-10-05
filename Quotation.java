
/**
 * Write a description of class Quotation here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Quotation
{
    private String customer;
    private String hallOwner;
    private String startDate;
    private String endDate;
    private String quotationId;
    private boolean quotationStatus;

    public Quotation(){
    }

    public Quotation(String customer, String hallOwner, String startDate, String endDate, String quotationId, boolean quotationStatus) {
        this.customer = customer;
        this.hallOwner = hallOwner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quotationId = quotationId;
        this.quotationStatus = quotationStatus;
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
    
}
