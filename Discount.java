
/**
 * Write a description of class Discount here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Discount
{
    private String customerType;
    private double discountRate;

    public Discount() {

    }

    public Discount(String customerType, double discountRate) {
        this.customerType = customerType;
        this.discountRate = discountRate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
