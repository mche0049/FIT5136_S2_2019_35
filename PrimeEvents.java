import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Write a description of class Users here.
 * Detailed description of controller class
 *
 * @version (a version number or a date)
 */
public class PrimeEvents
{
    private ArrayList<Owner> owners;
    private ArrayList<Customer> customers;
    private ArrayList<Administrator> administrators;
    private ArrayList<Quotation> quotations;
    private ArrayList<Booking> bookings;
    private ArrayList<Hall> halls;
    private ArrayList<Payment> payments;
    private ArrayList<Review> reviews;
    private ArrayList<Discount> discounts;

    public PrimeEvents()
    {
        owners = new ArrayList<Owner>();
        customers = new ArrayList<Customer>();
        administrators = new ArrayList<Administrator>();
        quotations = new ArrayList<Quotation>();
        bookings = new ArrayList<Booking>();
        halls = new ArrayList<Hall>();
        payments = new ArrayList<Payment>();
        reviews = new ArrayList<Review>();
        discounts = new ArrayList<Discount>();

        addCustomers("C20190101", "customer1", "0432477881", "test1@test1.com", "customer1", "123123123", "Others");
        addCustomers("C20190102", "customer2", "0432477888", "test2@test2.com", "customer2", "123123123", "Veterans");
        addOwners("O20190102", "owner1", "0432477880", "owner1@owner1.com", "owner1", "123123123");
        addOwners("O20190103", "owner2", "0432477882", "owner2@owner2.com", "owner2", "123123123");
        requestQuotation("hall1", "customer1", "owner1", "20191201", "20191205", "Q1234567890123",false, false, true);
        requestQuotation("hall2", "customer2", "owner2", "20191101", "20191102", "Q1234567890234",true, false, false);
        addHalls("H2019010101", "hall1", 888, "Caulfield", "All", 800, "owner1");
        addHalls("H2019010102", "hall2", 1000, "Clayton", "All", 1000, "owner2");
        addDiscount("Veterans", 0.8);
        addDiscount("Senior Citizens", 0.8);
        addDiscount("Others", 1.0);
        addAdmin("A1234567890123", "admin", "admin1", "123123123");
    }

    public ArrayList<Customer> getCustomers() {return customers;}

    public ArrayList<Discount> getDiscounts() {return discounts;}

    public ArrayList<Owner> getOwners() 
    {
        return owners;
    }

    public ArrayList<Quotation> getQuotations()
    {
        return quotations;
    }

    public ArrayList<Hall> getHalls() { return halls;}

    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }

    public ArrayList<Payment> getPayments() { return payments; }

    public ArrayList<Review> getReviews() { return reviews;}

    public Hall getHallByName(String name)          //to get the hall name
    {
        for(int i = 0; i < halls.size(); i++)
        {
            if (name.equals(halls.get(i).getHallOwner()))
            {
                return halls.get(i);
            }
        }
        return null;
    }

    public Customer getCustomerByName(String name) {            // to get the customer by name
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

    public void addCustomers(String id, String name, String phoneNo, String email, String userName, String userPwd, String customerType)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setPhoneNo(phoneNo);
        customer.setEmail(email);
        customer.setUserName(userName);
        customer.setUserPwd(userPwd);
        customer.setCustomerType(customerType);
        customers.add(customer);
    }

    public void addAdmin(String id, String name, String userName, String userPwd) {
        Administrator administrator = new Administrator();
        administrator.setId(id);
        administrator.setName(name);
        administrator.setUserName(userName);
        administrator.setUserPwd(userPwd);
        administrators.add(administrator);
    }

    public void addDiscount(String customerType, double discountRate) {
        Discount discount = new Discount();
        discount.setCustomerType(customerType);
        discount.setDiscountRate(discountRate);
        discounts.add(discount);
    }

    public void requestQuotation(String hallName, String customer, String hallOwner, String startDate, String endDate,String quotationId, boolean quotationStatus, boolean bookStatus, boolean catering)
    {
        Quotation quotation = new Quotation();
        quotation.setHallName(hallName);
        quotation.setCustomer(customer);
        quotation.setHallOwner(hallOwner);
        quotation.setStartDate(startDate);
        quotation.setEndDate(endDate);
        quotation.setQuotationId(quotationId);
        quotation.setQuotationStatus(quotationStatus);
        quotation.setBookStatus(bookStatus);
        quotation.setCatering(catering);
        quotations.add(quotation);
    }

    public void addBooking(String bookingId, String bookingDate, String hallName, String hallOwner, String customerName, String startDate, String endDate, boolean hallStatus, double totalAmount)
    {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setBookingDate(bookingDate);
        booking.setHallName(hallName);
        booking.setHallOwner(hallOwner);
        booking.setCustomerName(customerName);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setHallStatus(hallStatus);
        booking.setTotalAmount(totalAmount);
        bookings.add(booking);
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

    public void addPayment(String paymentId, String paymentDate, int totalAmount, boolean paymentMethod) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setPaymentDate(paymentDate);
        payment.setTotalAmount(totalAmount);
        payment.setPaymentMethod(paymentMethod);
        payments.add(payment);

    }

    public void addReview(String hallName, int hallRate, String hallReview) {
        Review review = new Review();
        review.setHallName(hallName);
        review.setHallRate(hallRate);
        review.setHallReview(hallReview);
        reviews.add(review);
    }
    
    public boolean isExist(String userName)             // to check whether the username exist
    {
        for (int i = 0; i < owners.size(); i++)
        {
            if(userName.equals(owners.get(i).getUserName()) )
            {
                return true;
            }
        }

        for (int i = 0; i < customers.size(); i++)    //validation of username      
        {
            if(userName.equals(customers.get(i).getUserName()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist(String userName, int choice)             ///validation of owner details
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
        else if (choice == 1) {                 //validation for name of customer

            for (int i = 0; i < customers.size(); i++)
            {
                if(userName.equals(customers.get(i).getUserName()))
                {
                    return true;
                }
            }
        }
        else if (choice == 3) {         // validation for name of admin
            for (int i = 0; i < administrators.size(); i++) {
                if(userName.equals(administrators.get(i).getUserName()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public String loginPwd(String userName, int choice)         // method of login password
    {   
        if(choice == 1)                 // for customer
        {
            for (int i = 0; i < customers.size(); i++)
            {
                if(userName.equals(customers.get(i).getUserName()))
                {
                    return customers.get(i).getUserPwd();
                }
            }
        }
        else if(choice == 2)        // for owner
        {
            for (int i = 0; i < owners.size(); i++)
            {
                if(userName.equals(owners.get(i).getUserName()))
                {
                    return owners.get(i).getUserPwd();
                }
            }
        }
        else if (choice == 3) {     // for administartor
            for (int i = 0; i < administrators.size(); i++) {
                if(userName.equals(administrators.get(i).getUserName())) {
                    return administrators.get(i).getUserPwd();
                }
            }
        }
        return "";
    }

    public boolean lengthVal(String userName, int length)       // username length check
    {
        if(userName.length() < length)
        {
            return true;
        }
        return false;
    }

    public boolean idLengthVal(String str, int number)          // password length check
    {
        if(str.length() == number)
        {
            return true;
        }
        return false;
    }

    public boolean isPhoneNo(String phoneNo)            //length of phone number check
    {
        return phoneNo.charAt(0) == '0' && phoneNo.length() == 10 && phoneNo.matches("[0-9]+");
    }

    public boolean isEmpty(String str)          //booleean check
    {
        if(str.length() > 0)
        {
            return false;
        }
        return true;
    }

    public int choiceMenu(int number1, int number2 )
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

    public int numberRange(int number1, int number2 )    ///number check
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
            catch (NumberFormatException e)                 // format exception
            {
                System.out.println("Invalid Input!");
                System.out.print("Hall Price:");
                choice1 = keyboard.nextLine();
            }
        }
        return choice;
    }

    public int discountRate(int number1, int number2 )          //to manage discounts
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
                    System.out.println("Please enter a reasonable discount!");
                    System.out.print("Discount Rate:");
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



    public int capacity(int number1, int number2 )      // to enter the hall capacity
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

    public boolean isEmail(String string) {             //for entering the email
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

    public boolean isValidStartDate(String str){        // for validating the start date format
        boolean result = true;
        int a = 0;
        try {
            a = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            //e.printStackTrace();
        }

        if(str.length() == 8) {                 // checking the length of date 
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

    public boolean isValidEndDate(String str, String str1){         // checking the format of enddate 
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

    public int calculateTotalDays(String startDate,String endDate) throws ParseException{           // calculating the total dates from start to end
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyyMMdd" );
        Date date1=null;
        Date date = formatter.parse(startDate);
        long ts = date.getTime();
        date1 =  formatter.parse(endDate);
        long ts1 = date1.getTime();
        long ts2=ts1-ts;
        int totalTime = 0;
        totalTime=(int) (ts2/(24*3600*1000)+1);
        return totalTime;
    }


    public boolean isName(String str) {             // check for the name 
        String txt = str + "";
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(txt);
        if (m.matches()) {
            return true;
        }
        p = Pattern.compile("[a-zA-Z]");
        m = p.matcher(txt);
        return false;
    }

    public boolean isDateRepeat(String startDate, String endDate, String hallName) {                // checking whether the date is repeated
        boolean a = false;
        System.out.println(startDate);
        for(int i = 0; i < bookings.size();i++) {
            if(hallName.equals(bookings.get(i).getHallName()) && Integer.parseInt(startDate) >= Integer.parseInt(bookings.get(i).getStartDate()) && Integer.parseInt(startDate) <= Integer.parseInt(bookings.get(i).getEndDate())) {
                a = true;
                break;
            }
            else if(hallName.equals(bookings.get(i).getHallName()) && Integer.parseInt(endDate) >= Integer.parseInt(bookings.get(i).getStartDate()) && Integer.parseInt(endDate) <= Integer.parseInt(bookings.get(i).getEndDate())) {
                a = true;
                break;
            }
            else
                a = false;
        }
        return a;
    }
}
