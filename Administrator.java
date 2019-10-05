
/**
 * Write a description of class Administrator here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Administrator
{
    private int id;
    private String name;
    private String userName;
    private String userPwd;
    
    public Administrator(int id, String name, String userName, String userPwd) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.userPwd = userPwd;
    }
    
    public Administrator()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
