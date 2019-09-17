import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Write a description of class Users here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Users
{
    private ArrayList<Owner> owners;
    private ArrayList<Customer> customers;
    private ArrayList<Administrator> administrators;

    public Users()
    {
        owners = new ArrayList<Owner>();
        customers = new ArrayList<Customer>();
        administrators = new ArrayList<Administrator>();
    }

    public ArrayList<Owner> getOwners() 
    {
        return owners;
    }

    public void setOwners(ArrayList<Owner> owners) 
    {
        this.owners = owners;
    }

    public void addOwners(long id, String name, String phoneNo, String email, String userName, String userPwd)
    {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setName(name);
        owner.setPhoneNo(phoneNo);
        owner.setEmail(email);
        owner.setUserName(userName);
        owner.setUserPwd(userPwd);
        owners.add(owner);
    }

    public void addCustomers(long id, String name, String phoneNo, String email, String userName, String userPwd)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setPhoneNo(phoneNo);
        customer.setEmail(email);
        customer.setUserName(userName);
        customer.setUserPwd(userPwd);
        customers.add(customer);
    }

    public void addAdministrator(int id, String name, String userName, String userPwd)
    {
        Administrator administrator = new Administrator();
        administrator.setId(id);
        administrator.setName(name);
        administrator.setUserName(userName);
        administrator.setUserPwd(userPwd);
    }

    public boolean isExist(String userName)
    {
        for (int i = 0; i < owners.size(); i++)
        {
            if(userName.equals(owners.get(i).getUserName()) )
            {
                return true;
            }
        }

        for (int i = 0; i < customers.size(); i++)
        {
            if(userName.equals(customers.get(i).getUserName()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist(String userName, int choice)
    {
        if(choice == 2)
        {
            for (int i = 0; i < owners.size(); i++)
            {
                if(userName.equals(owners.get(i).getUserName()) )
                {
                    return true;
                }
            }
        }
        else if (choice == 1) {

            for (int i = 0; i < customers.size(); i++)
            {
                if(userName.equals(customers.get(i).getUserName()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public String loginPwd(String userName, int choice)
    {   
        if(choice == 1)
        {
            for (int i = 0; i < customers.size(); i++)
            {
                if(userName.equals(customers.get(i).getUserName()))
                {
                    return customers.get(i).getUserPwd();
                }
            }
        }
        else if(choice == 2)
        {
            for (int i = 0; i < owners.size(); i++)
            {
                if(userName.equals(owners.get(i).getUserName()))
                {
                    return owners.get(i).getUserPwd();
                }
            }
        }
        return "";
    }

    public boolean lengthVal(String userName, int length)
    {
        if(userName.length() < length)
        {
            return true;
        }
        return false;
    }

    public boolean isPhoneNo(String phoneNo)
    {
        return phoneNo.charAt(0) == '0' && phoneNo.length() == 10 && phoneNo.matches("[0-9]+");
    }

    public boolean isEmpty(String str)
    {
       if(str.length() > 0)
       {
           return false;
       }
       return true;
    }
    
    public int customersMenu(int number1, int number2 )
    {
        Scanner keyboard = new Scanner(System.in);
        String choice1 = keyboard.nextLine();
        int choice = 0;
        while(true)
        {
            try
            {
                choice = Integer.parseInt(choice1);
                if(choice >= number1 && choice <= number2)
                {
                    break;
                }
                else 
                {
                    System.out.println("Invalid Input!");
                    System.out.print("Please enter your choice:");
                    choice1 = keyboard.nextLine();
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input!");
                System.out.print("Please enter your choice:");
                choice1 = keyboard.nextLine();
            }
        }
        return choice;
    }
    
        public int numberRange(int number1, int number2 )
    {
        Scanner keyboard = new Scanner(System.in);
        String choice1 = keyboard.nextLine();
        int choice = 0;
        while(true)
        {
            try
            {
                choice = Integer.parseInt(choice1);
                if(choice >= number1 && choice <= number2)
                {
                    break;
                }
                else 
                {
                    System.out.println("Please enter a reasonable price!");
                    System.out.print("HallPrice:");
                    choice1 = keyboard.nextLine();
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input!");
                System.out.print("Hall Price:");
                choice1 = keyboard.nextLine();
            }
        }
        return choice;
    }
    
    public boolean isEmail(String string) {
		if (string == null)
		return false;
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx1);
		m = p.matcher(string);
		if (m.matches())
			return true;
		else
			return false;
	}
}

