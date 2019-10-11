
/**
 * Write a description of class Review here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Review
{
    private String hallName;
    private int hallRate;
    private String hallReview;

    public Review(String hallName, int hallRate, String hallReview) {
        this.hallName = hallName;
        this.hallRate = hallRate;
        this.hallReview = hallReview;
    }

    public Review() {

    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getHallRate() {
        return hallRate;
    }

    public void setHallRate(int hallRate) {
        this.hallRate = hallRate;
    }

    public String getHallReview() {
        return hallReview;
    }

    public void setHallReview(String hallReview) {
        this.hallReview = hallReview;
    }
}
