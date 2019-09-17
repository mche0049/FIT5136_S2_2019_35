
/**
 * Write a description of class Hall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hall
{
    private long id;
    private String hallName;
    private int hallPrice;
    private String hallLocation;
    private String eventType;
    private int capacity;
    private String description;

    public Hall(long id, String hallName, int hallPrice, String hallLocation, String eventType, int capacity, String description)
    {
        this.id = id;
        this.hallName = hallName;
        this.hallPrice = hallPrice;
        this.hallLocation = hallLocation;
        this.eventType = eventType;
        this.capacity = capacity;
        this.description = description;
    }

    public Hall()
    {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getHallPrice() {
        return hallPrice;
    }

    public void setHallPrice(int hallPrice) {
        this.hallPrice = hallPrice;
    }

    public String getHallLocation() {
        return hallLocation;
    }

    public void setHallLocation(String hallLocation) {
        this.hallLocation = hallLocation;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
