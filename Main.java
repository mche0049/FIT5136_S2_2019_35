
/**
 * Write a description of class Main here.
 * 
 * @Echo
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
    private Users users;

    public Main()
    {
        users = new Users();
    }

    public void run()
    {
        boolean a = true;
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("        Welcome to Melbourne Prime Events");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("");
        System.out.println("1. log in as a customer");
        System.out.println("2. log in as an owner");
        System.out.println("3. log in as an administrator");
        System.out.println("4. register");
        System.out.println("0. Exit");
        System.out.print("Please enter your choice:");
        int choice = users.customersMenu(0,4);
        Scanner keyboard = new Scanner(System.in);
        while(a)
        {
            if(choice == 1 ||choice == 2 || choice == 3)
            {
                login(choice);
                chooseOption(choice);
            }
            else if(choice == 4)
            {
                chooseOption(choice);
            }
            else if(choice == 0)
            {
                return;
            }
            else
            {
                System.out.println("Invalid Input!");
                System.out.print("Please enter your choice:");
                choice = keyboard.nextInt();
            }

        }
    }
    
    public void login(int choice)
    {
        System.out.println("----------------------------------------------------");
        System.out.print("UserName:");
        Scanner keyboard = new Scanner(System.in);
        String userName = keyboard.nextLine();
        while(!users.isNameExist(userName, choice))
        {
            System.out.println("userName doesn't exist!");
            System.out.print("UserName:");
            userName = keyboard.nextLine();
        }
        System.out.print("PassWord:");
        String userPwd =keyboard.nextLine();
        while(!userPwd.equals(users.loginPwd(userName, choice)))
        {
            System.out.println("Incorrect password!");
            System.out.print("Password:");
            userPwd = keyboard.nextLine();
        }
        System.out.println("Login successful!");
    }

    public void register(int choice)
    {
        if(choice == 1 || choice == 2)
        {
            String sformat = "MMddhhmmssSSS";
            Scanner keyboard = new Scanner(System.in);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            long id = Long.valueOf(dateString);

            System.out.print("UserName:");
            String userName = keyboard.nextLine();
            while(users.isExist(userName))
            {
                System.out.println("userName already exists!");
                System.out.print("UserName:");
                userName = keyboard.nextLine();
            }
            while(users.lengthVal(userName, 6))
            {
                System.out.println("userName should be greater than or equal to 6 characters!");
                System.out.print("UserName:");
                userName = keyboard.nextLine();
            }
            System.out.print("PassWord:");
            String userPwd =keyboard.nextLine();
            while(users.lengthVal(userPwd, 8))
            {
                System.out.println("userName should be greater than or equal to 8 characters!");
                System.out.print("PassWord:");
                userPwd =keyboard.nextLine();
            }
            System.out.print("Name:");
            String name = keyboard.nextLine();
            while(users.isEmpty(name))
            {
                System.out.println("Name can not be empty!");
                System.out.print("Name:");
                name = keyboard.nextLine();
            }
            System.out.print("Phone Number:");
            String phoneNo = keyboard.nextLine();
            while(!users.isPhoneNo(phoneNo))
            {
                System.out.println("Invalid Australia Phone Number!(Example: 0432477881)");
                System.out.print("Phone Number:");
                phoneNo =keyboard.nextLine();
            }
            System.out.println("Email:");
            String email = keyboard.nextLine();
            while(!users.isEmail(email))
            {
                System.out.println("Please enter the correct email!(Example:admin@admin.com)");
                System.out.print("Email:");
                email =keyboard.nextLine();
            }
            System.out.println("Register Successfully");
            System.out.println("----------------------------------------------------");
            if(choice == 1) //customer
            {
                users.addCustomers(id, name, phoneNo, email, userName, userPwd);
            }
            else if(choice == 2) //owner
            {
                users.addOwners(id, name, phoneNo, email, userName, userPwd);
            }
            run();
        }
    }

    public void chooseOption(int choice)
    {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("1. View all the halls");
            System.out.println("2. Search halls");
            System.out.println("3. Request for a quotation");
            System.out.println("4. Book halls");         
            System.out.println("5. Manage bookings");
            System.out.println("6. Write a review on a hall"); 
            System.out.println("7. Logout");
            System.out.print("Please enter your choice:");
            choice = users.customersMenu(1,7);
            optionCustomer(choice);
        }
        else if (choice == 2)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("1. Create halls");
            System.out.println("2. Manage halls");        
            System.out.println("3. Manage bookings");
            System.out.println("4. Manage payments"); 
            System.out.println("5. Manage discounts"); 
            System.out.println("6. Logout");
            System.out.print("Please enter your choice:");
            choice = users.customersMenu(1,6);
            optionOwner(choice);
        }
        else if (choice == 3)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("1. Manage users");
            System.out.println("2. Manage discounts");
            System.out.println("3: Logout");
            System.out.print("Please enter your choice:");
            choice = users.customersMenu(1,3);
        }
        else if (choice == 4)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("                    REGISTER                    ");
            System.out.println("----------------------------------------------------");
            System.out.println("Register as...");
            System.out.println("1. Customer");
            System.out.println("2. Owner");
            System.out.print("Please enter your choice:");
            choice = users.customersMenu(1,2);
            register(choice);
        }
        else
        {
            System.out.println("Invalid Input!");
        }
    }

    public void optionCustomer(int choice)
    {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1)
        {
            System.out.println("---------------Halls List----------------------------");
            System.out.println("Hall No  | Hall Name | Hall Price | Hall Location | Type    | Capacity");
            System.out.println("20190001 | aHall     | 100        | Clayton       | All     | 50");
            System.out.println("20190002 | bHall     | 100        | Caulfield     | All     | 100");
            System.out.println("20190003 | cHall     | 100        | Box Hill      | All     | 150");

            System.out.println("             <    Previous    1    Next    >             ");
            System.out.println("1.Previous");
            System.out.println("2.Next");
            System.out.println("b.Back to the main menu");
            ;System.out.print("Please enter your choice:");
            String choiceOption = keyboard.nextLine();
            if(choiceOption.equals("b"))
            {
                chooseOption(1);
            }
            String choiceOption1 = keyboard.nextLine();
            if (choiceOption1.equals("b") )
            {
                chooseOption(1);
            }
        }
        else if (choice == 2)
        {
            System.out.println("----------------------------------------------------");
            System.out.print("Please enter the hall's name: ");
            String choiceOption = keyboard.nextLine();
            System.out.println("----------------------------------------------------");
            System.out.println("Hall No  | Hall Name | Hall Price | Hall Location | Type    | Capacity");
            System.out.println("20190001 | aHall     | 100        | Clayton       | All     | 50");
            System.out.println("----------------------------------------------------");
            System.out.println("b. Back to the main menu");
            String choiceOption1 = keyboard.nextLine();
            if (choiceOption1.equals("b") )
            {
                chooseOption(1);
            }
        }
        else if (choice == 3)
        {
            System.out.println("--------------------quotation------------------------");
            System.out.print("Enter a hall name for quotation:");
            String hallName = keyboard.nextLine();
            System.out.println("----------------------------------------------------");
            System.out.println("Hall No  | Hall Name | Hall Price | Hall Location | Type    | Capacity");
            System.out.println("20190001 | aHall     | 100        | Clayton       | All     | 50");
            System.out.println("Please enter your name:");
            String name = keyboard.nextLine();
            System.out.println("Please enter your phone number:");
            String phoneNo = keyboard.nextLine();
            System.out.println("Please enter the start date(DD/MM/YYYY):");
            String startDate = keyboard.nextLine();
            System.out.print("Please enter the end date(DD/MM/YYYY):");
            String endDate = keyboard.nextLine();
            System.out.println("Successfully! It will be available in your book list after the hall's owner accept");
            System.out.println("Thank you for choosing Melbourne Prime Events!");
            chooseOption(1);
        }
        else if (choice == 4)
        {
            Random random = new Random();
            System.out.println("----------------Book List----------------------------");
            System.out.println("Hall No  | Hall Name | Hall Price | Hall Location | Type    | Capacity");
            System.out.println("20190001 | aHall     | 100        | Clayton       | All     | 50");
            System.out.println("----------------Book Information----------------------");   
            System.out.print("Name:" + "PhoneNo:");
            System.out.print("Start Date:" + "End Date:");
            System.out.println("---------------Payment-----------------------");
            System.out.print("Enter Amount:");
            String amount = keyboard.nextLine();
            System.out.print("Enter Password to confirm the order:");
            String userPwd = keyboard.nextLine();
            System.out.println("Congratulations! Your payment has been accepted.");
            System.out.println("Do you want to view the receipt?(y/n)");
            String yesOrNo = keyboard.nextLine();
            if (yesOrNo.equals("y"))
            {
                System.out.println("Order ID:" + (Math.random()*9+1)*100000);
                System.out.println("Amount Paid:" + amount);
                SimpleDateFormat df = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
                System.out.println("Payment Date:" + df.format(new Date()));
                System.out.println("----------------------------------------------------");
                System.out.print("Press b to back to the main menu");
                String choiceOption1 = keyboard.nextLine();
                if (choiceOption1.equals("b") )            
                {
                    chooseOption(1);
                }
            }
            else if (yesOrNo.equals("n"))
            {
                chooseOption(1);
            }
        }
        else if (choice == 5)
        {
            System.out.println("------------Booking List----------------------------");
            System.out.println("   Order ID |Hall No  | Hall Name | Start Date | End Date  |");
            System.out.println("1. 100001   |2019001  | aHall     | DD/MM/YYYY | DD/MM/YYYY|");
            System.out.print("Please choose the booking you want to cancel:");
            String manage = keyboard.nextLine();
            System.out.println("The booking has been cancelled!");
            chooseOption(1);
        }
        else if (choice == 6)
        {
            System.out.println("----------------------------------------------------");
            System.out.println("Please enter the Booking ID:");
            String bookId = keyboard.nextLine();
            System.out.println("------------Booking List----------------------------");
            System.out.println("   Order ID |Hall No  | Hall Name | Start Date | End Date  |");
            System.out.println("   100001   |2019001  | aHall     | DD/MM/YYYY | DD/MM/YYYY|");
            System.out.println("----------------------------------------------------");
            System.out.println("Rating the hall(1~5, 5 is the highest):");
            String rating = keyboard.nextLine();
            System.out.println("Write a review for this hall:");
            String review = keyboard.nextLine();
            System.out.println("Thank you!");
            chooseOption(1);
        }
        else if (choice == 7)
        {
            System.out.println("Logout Successful!");
        }
        else
        {
            System.out.println("Invalid Input!");
        }
    }

    public void optionOwner(int choice)
    {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1)
        {
            System.out.println("------------Create Hall----------------------------");
            System.out.println("Please enter the followting Hall's information");
            
            String sformat = "MMddhhmmssSSS";
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            long id = Long.valueOf(dateString);
            
            System.out.print("Hall name:");
            String hallName = keyboard.nextLine();
            while(users.isEmpty(hallName))
            {
                System.out.println("Hall Name can not be empty!");
                System.out.print("Hall Name:");
                hallName = keyboard.nextLine();
            }
            System.out.println("Hall Price(per day):");
            int hallPrice = users.numberRange(1,9999);
            System.out.print("Hall Location:");
            String hallLocation = keyboard.nextLine();
            while(users.isEmpty(hallLocation))
            {
                System.out.println("Hall Location can not be empty!");
                System.out.print("Hall Location:");
                hallLocation = keyboard.nextLine();
            }
            System.out.println("Please choose the type of the Hall:");
            System.out.println("1.Wedding ceremony");
            System.out.println("2.Wedding reception");
            System.out.println("3.Birthday");
            System.out.println("4.Anniversary");
            System.out.println("5.All");
            int typeOption = users.customersMenu(1,5);
            if(typeOption == 1)
            {
                String eventType = "Wedding ceremony";
            }
            else if(typeOption == 2)
            {
                String eventType = "Wedding reception";
            }
            else if(typeOption == 3)
            {
                String eventType = "Birthday";
            }
            else if(typeOption == 4)
            {
                String eventType = "Anniversary";
            }
            else if(typeOption == 5)
            {
                String eventType = "All";
            }
            System.out.print("Please enter the hall capacity:");
            int hallCapacity = users.numberRange(1,9999);
            
            //users.getOwners().get()
            
            System.out.println("Create Successful!");
            chooseOption(2);
        }
        else if (choice == 2)
        {
            System.out.println("---------------Halls List----------------------------");
            System.out.println("  Hall No  | Hall Name | Hall Price | Hall Location | Type    | Capacity");
            System.out.println("1.20190001 | aHall     | 100        | Clayton       | All     | 50");
            System.out.println("2.20190002 | bHall     | 100        | Caulfield     | All     | 100");
            System.out.println("3.20190003 | cHall     | 100        | Box Hill      | All     | 150");
            System.out.print("Please choose the hall you want to manage:");
            String manage = keyboard.nextLine();
            System.out.println("1. Update Hall's information");
            System.out.println("2. Delete Hall");
        }
        else if (choice == 3)
        {
            System.out.println("------------Booking List----------------------------");
            System.out.println("   Order ID |Hall No  | Hall Name | Start Date | End Date  |");
            System.out.println("   100001   |2019001  | aHall     | DD/MM/YYYY | DD/MM/YYYY|");
            System.out.println("----------------------------------------------------");
            System.out.print("Please choose the order you want to manage:");
            String manage = keyboard.nextLine();
            System.out.println("1. Cancel booking");
        }
        else if (choice == 4)
        {

        }
        else if (choice == 5)
        {

        }
        else if (choice == 6)
        {

        }
        else
        {
            System.out.println("Invalid Input!");
            chooseOption(1);
        }
    }
}