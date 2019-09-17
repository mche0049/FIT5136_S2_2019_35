
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer
{
    private long id;
    private String name;
    private String phoneNo;
    private String email;
    private String userName;
    private String userPwd;

    public Customer(long id, String name, String phoneNo, String email, String userName, String userPwd) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Customer()
    {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
