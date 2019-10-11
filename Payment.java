
/**
 * Write a description of class Payment here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Payment
{
    private String paymentId;
    private String paymentDate;
    private int totalAmount;
    private boolean paymentMethod;

    public Payment(String paymentId, String paymentDate, int totalAmount, boolean paymentMethod) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public Payment() {

    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(boolean paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
