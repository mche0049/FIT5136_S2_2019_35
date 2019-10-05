import java.util.ArrayList;
/**
 * Write a description of class Owner here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Owner
{
    
    private ArrayList<Hall> halls;
    
    private String id;
    private String name;
    private String phoneNo;
    private String email;
    private String userName;
    private String userPwd;

    public Owner(String id, String name, String phoneNo, String email, String userName, String userPwd, ArrayList<Hall> halls) 
    {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userName = userName;
        this.userPwd = userPwd;
        this.halls = halls;
    }
    
    public Owner() {
        halls = new ArrayList<Hall>();
        
        addHalls("H2019010101", "Caulfield Hall", 1000, "Caulfield", "All", 500, "mhzmhz");
    }
    
    public ArrayList<Hall> getHalls() {
        return halls;
    }
    
    public void setHalls(ArrayList<Hall> halls){
        this.halls = halls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    
    public void addHalls(String id, String hallName, int hallPrice, String hallLocation, String eventType, int capacity, String hallOwner )
    {
        Hall hall = new Hall();
        hall.setId(id);
        hall.setHallName(hallName);
        hall.setHallPrice(hallPrice);
        hall.setHallLocation(hallLocation);
        hall.setEventType(eventType);
        hall.setCapacity(capacity);
        hall.setHallOwner(hallOwner);
        halls.add(hall);
    }
}
