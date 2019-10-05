import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Write a description of class Users here.
 * 
 * @Yike Xu
 * @version (a version number or a date)
 */
public class Users
{
    private ArrayList<Owner> owners;
    private ArrayList<Customer> customers;
    private ArrayList<Administrator> administrators;
    private ArrayList<Quotation> quotations;

    public Users()
    {
        owners = new ArrayList<Owner>();
        customers = new ArrayList<Customer>();
        administrators = new ArrayList<Administrator>();
        quotations = new ArrayList<Quotation>();

        addCustomers("C20190101", "yike xu", "0432477881", "yxuu0080@student.monash.edu", "xykxyk", "xykxykxyk");
        addOwners("O20190102", "haozhe ma", "0432477880", "hmaa0012@student.monash.edu", "mhzmhz", "mhzmhzmhz");
    }

    public ArrayList<Owner> getOwners() 
    {
        return owners;
    }
    
    public ArrayList<Quotation> getQuotations()
    {
        return quotations;
    }

    public Owner getOwnerByName(String name)
    {
        for(int i = 0; i < owners.size(); i++)
        {
            if (name.equals(owners.get(i).getUserName()))
            {
                return owners.get(i);
            }
        }
        return null;
    }
    
    public Customer getCustomerByName(String name) {
        for(int i = 0; i < customers.size(); i++)
        {
            if (name.equals(customers.get(i).getUserName()))
            {
                return customers.get(i);
            }
        }
        return null;
    }

    public void setOwners(ArrayList<Owner> owners) 
    {
        this.owners = owners;
    }

    public void addOwners(String id, String name, String phoneNo, String email, String userName, String userPwd)
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

    public void addCustomers(String id, String name, String phoneNo, String email, String userName, String userPwd)
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

        public void requestQuotation(String customer, String hallOwner, String startDate, String endDate,String quotationId, boolean quotationStatus) {
        Quotation quotation = new Quotation();
        quotation.setCustomer(customer);
        quotation.setHallOwner(hallOwner);
        quotation.setStartDate(startDate);
        quotation.setEndDate(endDate);
        quotation.setQuotationId(quotationId);
        quotation.setQuotationStatus(quotationStatus);
        quotations.add(quotation);
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
    
    public boolean idLengthVal(String str)
    {
        if(str.length() == 14)
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

    public int capacity(int number1, int number2 )
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
                    System.out.println("Please enter a reasonable hall capacity!");
                    System.out.print("Hall Capacity:");
                    choice1 = keyboard.nextLine();
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid Input!");
                System.out.print("Hall Capacity:");
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

    public boolean isValidStartDate(String str){
        boolean result = true;
        int a = 0;
        try {
            a = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            //e.printStackTrace();
        }

        if(str.length() == 8) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date(System.currentTimeMillis());
            int b = Integer.parseInt(format.format(date));
            if(a >= b)
            {
                try {
                    format.setLenient(false);
                    format.parse(str);
                } catch (ParseException e) {
                    result = false;
                }
            }
            else
            {
                result = false;
            }
        }else{
            result = false;
        }
        return result;
    }

    public boolean isValidEndDate(String str, String str1){
        boolean result = true;
        int a = 0;
        try {
            a = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            //e.printStackTrace();
        }
        int b = Integer.parseInt(str1);
        if(str.length() == 8) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            if(a > b)
            {
                try {
                    format.setLenient(false);
                    format.parse(str);
                } catch (ParseException e) {
                    result = false;
                }
            }
            else {
                result = false;
            }
        }else{
            result = false;
        }
        return result;
    }
}
