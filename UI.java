
/**
 * Write a description of class Main here.
 *
 * @Yike Xu
 * @version (a version number or a date)
 */

import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class UI {
    private PrimeEvents users;
    private String customerLogin;
    private String ownerLogin;
    private int paymentMethod = 0;

    public UI() {
        users = new PrimeEvents();
        customerLogin = "";
        ownerLogin = "";
    }

    public static void main(String[] args) throws ParseException {
        UI p = new UI();
        p.run();
    }

    public void run() throws ParseException {
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
        int choice = users.choiceMenu(0, 4);
        Scanner keyboard = new Scanner(System.in);
        while (a) {
            if (choice == 1 || choice == 2 || choice == 3) {
                login(choice);
                chooseOption(choice);
            } else if (choice == 4) {
                chooseOption(choice);
            } else if (choice == 0) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input!");
                System.out.print("Please enter your choice:");
                choice = keyboard.nextInt();
            }

        }
    }

    public void login(int choice) throws ParseException {
        System.out.println("----------------------------------------------------");
        System.out.print("UserName:");
        Scanner keyboard = new Scanner(System.in);
        String userName = keyboard.nextLine();
        int k = 0;
        while (!users.isNameExist(userName, choice)) {
            System.out.println("userName doesn't exist!");
            System.out.print("UserName:");
            userName = keyboard.nextLine();
            k++;
            if (k == 3) {
                System.out.println("Please check the input!");
                System.out.println("Back to the Main menu!");
                run();
            }
        }

        k = 0;
        System.out.print("PassWord:");
        String userPwd = keyboard.nextLine();
        while (!userPwd.equals(users.loginPwd(userName, choice))) {
            System.out.println("Incorrect password!");
            System.out.print("Password:");
            userPwd = keyboard.nextLine();

            k++;
            if (k == 3) {
                System.out.println("Please check the input!");
                System.out.println("Back to the Main menu!");
                k = 0;
                run();
            }
        }
        System.out.println("Login successful!");
        if (choice == 1) {
            customerLogin = userName;
        } else if (choice == 2) {
            ownerLogin = userName;
        }
    }

    public void register(int choice) throws ParseException {
        if (choice == 1 || choice == 2) {
            String sformat = "MMddhhmmssSSS";
            Scanner keyboard = new Scanner(System.in);
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            String id = dateString;

            System.out.print("UserName:");
            String userName = keyboard.nextLine();
            while (users.isExist(userName)) {
                System.out.println("userName already exists!");
                System.out.print("UserName:");
                userName = keyboard.nextLine();
            }
            while (users.lengthVal(userName, 6)) {
                System.out.println("userName should be greater than or equal to 6 characters!");
                System.out.print("UserName:");
                userName = keyboard.nextLine();
            }
            System.out.print("PassWord:");
            String userPwd = keyboard.nextLine();
            while (users.lengthVal(userPwd, 8)) {
                System.out.println("userName should be greater than or equal to 8 characters!");
                System.out.print("PassWord:");
                userPwd = keyboard.nextLine();
            }
            System.out.print("Name:");
            String name = keyboard.nextLine();
            while (users.isEmpty(name)) {
                System.out.println("Name can not be empty!");
                System.out.print("Name:");
                name = keyboard.nextLine();
            }
            System.out.print("Phone Number:");
            String phoneNo = keyboard.nextLine();
            while (!users.isPhoneNo(phoneNo)) {
                System.out.println("Invalid Australia Phone Number!(Example: 0432477881)");
                System.out.print("Phone Number:");
                phoneNo = keyboard.nextLine();
            }
            System.out.print("Email:");
            String email = keyboard.nextLine();
            while (!users.isEmail(email)) {
                System.out.println("Please enter the correct email!(Example:admin@admin.com)");
                System.out.print("Email:");
                email = keyboard.nextLine();
            }

            String discountType = "";
            if (choice == 1) {
                System.out.println("The hall can offer concessions for veterans and senior citizens.");
                System.out.println("1. Veterans");
                System.out.println("2. Senior Citizens");
                System.out.println("3. Others");
                System.out.println("Please ensure the authenticity of the information！");
                System.out.print("Please enter your choice:");

                int type = users.choiceMenu(1, 3);
                if (type == 1)
                    discountType = "Veterans";
                else if (type == 2)
                    discountType = "Senior Citizens";
                else if (type == 3)
                    discountType = "Others";
            }
            System.out.println("Register Successful!");
            System.out.println("----------------------------------------------------");
            if (choice == 1) //customer
            {
                users.addCustomers("C" + id, name, phoneNo, email, userName, userPwd, discountType);
            } else if (choice == 2) //owner
            {
                users.addOwners("O" + id, name, phoneNo, email, userName, userPwd);
            }
            run();
        }
    }

    public void chooseOption(int choice) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("             Hello," + customerLogin);
            System.out.println("----------------------------------------------------");
            System.out.println("1. View all the halls");
            System.out.println("2. Search halls");
            System.out.println("3. Request for a quotation");
            System.out.println("4. Book halls");
            System.out.println("5. Manage bookings");
            System.out.println("6. Write a review on a hall");
            System.out.println("7. Logout");
            System.out.print("Please enter your choice:");
            choice = users.choiceMenu(1, 7);
            optionCustomer(choice);
        } else if (choice == 2) {
            System.out.println("----------------------------------------------------");
            System.out.println("              Hello," + ownerLogin);
            System.out.println("----------------------------------------------------");
            System.out.println("1. Create halls");
            System.out.println("2. Delete halls");
            System.out.println("3. Manage bookings");
            System.out.println("4. Manage payments");
            System.out.println("5. Manage discounts");
            System.out.println("6. Response to the quotation");
            System.out.println("7. Logout");
            System.out.print("Please enter your choice:");
            choice = users.choiceMenu(1, 7);
            optionOwner(choice);
        } else if (choice == 3) {
            System.out.println("----------------------------------------------------");
            System.out.println("             Hello, Admin");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Manage users");
            System.out.println("2. Manage discounts");
            System.out.println("3: Logout");
            System.out.print("Please enter your choice:");
            choice = users.choiceMenu(1, 3);
            optionAdmin(choice);
        } else if (choice == 4) {
            System.out.println("----------------------------------------------------");
            System.out.println("                    REGISTER                    ");
            System.out.println("----------------------------------------------------");
            System.out.println("Register as...");
            System.out.println("1. Customer");
            System.out.println("2. Owner");
            System.out.print("Please enter your choice:");
            choice = users.choiceMenu(1, 2);
            register(choice);
        } else {
            System.out.println("Invalid Input!");
        }
    }

    public void optionCustomer(int choice) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("------------------------------Halls List---------------------------------------");
            System.out.println("     Hall Name      | Hall Price | Hall Location |       Type        | Capacity");
            System.out.println("-------------------------------------------------------------------------------");
            for (int i = 0; i < users.getHalls().size(); i++) {
                System.out.printf("%-" + 19 + "s", users.getHalls().get(i).getHallName());
                System.out.print(" | ");
                System.out.printf("%-" + 10 + "s", users.getHalls().get(i).getHallPrice());
                System.out.print(" | ");
                System.out.printf("%-" + 13 + "s", users.getHalls().get(i).getHallLocation());
                System.out.print(" | ");
                System.out.printf("%-" + 17 + "s", users.getHalls().get(i).getEventType());
                System.out.print(" | ");
                System.out.print(users.getHalls().get(i).getCapacity());
                System.out.println("");
            }
            System.out.println("Press Enter to back to the main menu");
            String enter = keyboard.nextLine();
            chooseOption(1);
        } else if (choice == 2) {
            System.out.println("---------------------------------------------------------------");
            System.out.print("Please enter the hall's name: ");
            String hallName = keyboard.nextLine();

            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("     Hall Name      | Hall Price | Hall Location |       Type        | Capacity");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("");
            int count = 0;
            for (int i = 0; i < users.getHalls().size(); i++) {
                if (hallName.equals(users.getHalls().get(i).getHallName())) {
                    System.out.printf("%-" + 19 + "s", users.getHalls().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getHalls().get(i).getHallPrice());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getHalls().get(i).getHallLocation());
                    System.out.print(" | ");
                    System.out.printf("%-" + 17 + "s", users.getHalls().get(i).getEventType());
                    System.out.print(" | ");
                    System.out.print(users.getHalls().get(i).getCapacity());
                    System.out.println("");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No matching Hall was found, please check the Hall name.");
                chooseOption(1);
            } else {
                System.out.println("---------------------------Hall Review------------------------------------");
                int rating = 0;
                double totalRating = 0;
                int a = 0;
                for (int i = 0; i < users.getReviews().size(); i++) {
                    String review = "";
                    if (hallName.equals(users.getReviews().get(i).getHallName())) {
                        rating = users.getReviews().get(i).getHallRate();
                        review = users.getReviews().get(i).getHallReview();
                        System.out.println(a + 1 + ". " + review);
                        System.out.println("");
                        a++;
                        totalRating += rating;
                    }
                }
                totalRating = totalRating / a;
                System.out.println("Rating: " + totalRating);
                System.out.print("Press Enter to back to the Main Menu.");
                String enter = keyboard.nextLine();
                chooseOption(1);
            }
        } else if (choice == 3) {
            String sformat = "MMddhhmmssSSS";
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            String id = dateString;

            System.out.println("--------------------quotation------------------------");
            System.out.print("Enter a hall name for quotation:");
            String hallName = keyboard.nextLine();
            int count = 0;
            String hallOwner = "";
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("     Hall Name      | Hall Price | Hall Location |       Type        | Capacity");
            System.out.println("-------------------------------------------------------------------------------");
            for (int i = 0; i < users.getHalls().size(); i++) {
                if (hallName.equals(users.getHalls().get(i).getHallName())) {
                    System.out.printf("%-" + 19 + "s", users.getHalls().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getHalls().get(i).getHallPrice());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getHalls().get(i).getHallLocation());
                    System.out.print(" | ");
                    System.out.printf("%-" + 17 + "s", users.getHalls().get(i).getEventType());
                    System.out.print(" | ");
                    System.out.print(users.getHalls().get(i).getCapacity());
                    System.out.println("");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No matching Hall was found, please check the Hall name.");
                chooseOption(1);
            }
            String customerName = customerLogin;

            for (int i = 0; i < users.getHalls().size(); i++) {
                if (hallName.equals(users.getHalls().get(i).getHallName())) {
                    hallOwner = users.getHalls().get(i).getHallOwner();
                }
            }

            System.out.println("------------------------------------------------------------");
            System.out.print("Please enter the start date(yyyyMMdd):");
            String startDate = keyboard.nextLine();
            while (!users.isValidStartDate(startDate)) {
                System.out.print("Please enter the correct start date!(yyyyMMdd):");
                startDate = keyboard.nextLine();
            }
            System.out.print("Please enter the end date(yyyyMMdd):");
            String endDate = keyboard.nextLine();
            while (!users.isValidEndDate(endDate, startDate)) {
                System.out.println("Please enter the correct end date!(yyyyMMdd):");
                endDate = keyboard.nextLine();
            }
            System.out.println("Catering");
            System.out.println("1. Provide by hall owner");
            System.out.println("2. Provide by yourself");
            System.out.println("TIPS: If need the owner to provide, you need to increase the price by 20%");
            System.out.print("Please enter your choice:");
            boolean catering = true;
            int cateringChoice = users.choiceMenu(1, 2);
            if (cateringChoice == 1) {
                catering = true;
            } else {
                catering = false;
            }


            boolean quotationStatus = false;
            boolean bookStatus = false;
            boolean hallStatus = users.isDateRepeat(startDate, endDate, hallName);
            if (hallStatus) {
                System.out.println("This date has been booked!");
                System.out.println("Request quotation failed");
                System.out.print("Press Enter to back to the Main menu!");
                String enter = keyboard.nextLine();
                chooseOption(1);
            } else {
                users.requestQuotation(hallName, customerName, hallOwner, startDate, endDate, "Q" + id, quotationStatus, bookStatus, catering);
                System.out.println("------------------------------------------------------------");
                System.out.println("Successfully! It will be available in your book list after the hall's owner accept.");
                System.out.println("Thank you for choosing Melbourne Prime Events!");
                System.out.print("Press Enter to back to the Main Menu.");
                String enter = keyboard.nextLine();
                chooseOption(1);
            }
        } else if (choice == 4) {
            boolean a = false;
            System.out.println("----------------------------------Booking---------------------------------------------");
            System.out.println("     Hall Name      | Customer Name | Start Date | End Date   | Quotation ID  | Catering");
            System.out.println("--------------------------------------------------------------------------------------");
            for (int i = 0; i < users.getQuotations().size(); i++) {
                if (customerLogin.equals(users.getQuotations().get(i).getCustomer()) && users.getQuotations().get(i).getQuotationStatus() && !users.getQuotations().get(i).getBookStatus()) {
                    System.out.printf("%-" + 19 + "s", users.getQuotations().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getQuotations().get(i).getCustomer());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getQuotations().get(i).getStartDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getQuotations().get(i).getEndDate());
                    System.out.print(" | ");
                    System.out.print(users.getQuotations().get(i).getQuotationId());
                    System.out.print(" | ");
                    if (users.getQuotations().get(i).getCatering()) {
                        System.out.print("Provide by Owner");
                    } else {
                        System.out.print("Provede by Customer");
                    }
                    System.out.println("");
                    a = true;
                }
            }

            if (!a) {
                System.out.println("No accepted quotation!");
                chooseOption(1);
            } else {
                System.out.println("------------------------------------------------------");
                System.out.print("Please select the quotation you want to book(Enter Quotation ID): ");
                String quotationId = keyboard.nextLine();
                boolean check = true;
                while (check) {
                    for (int j = 0; j < users.getQuotations().size(); j++) {
                        if (quotationId.equals(users.getQuotations().get(j).getQuotationId()))
                            check = false;
                    }
                    if (check == false)
                        break;
                    System.out.println("Please enter the correct quotation id!");
                    System.out.print("QuotationID:");
                    quotationId = keyboard.nextLine();
                }

                System.out.println("Booking successful!");
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date(System.currentTimeMillis());
                String currentDate = String.valueOf(format.format(date));

                String sformat = "MMddhhmmssSSS";
                Date currentTime = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(sformat);
                String dateString = formatter.format(currentTime);
                String bId = "B" + dateString;
                String pId = "P" + dateString;

                String hallName = "";
                String startDate = "";
                String endDate = "";
                String hallOwner = "";
                String phoneNo = "";

                boolean catering = true;

                for (int i = 0; i < users.getQuotations().size(); i++) {
                    if (quotationId.equals(users.getQuotations().get(i).getQuotationId())) {
                        hallName = users.getQuotations().get(i).getHallName();
                        startDate = users.getQuotations().get(i).getStartDate();
                        endDate = users.getQuotations().get(i).getEndDate();
                        catering = users.getQuotations().get(i).getCatering();
                        hallOwner = users.getQuotations().get(i).getHallOwner();
                        users.getQuotations().get(i).setBookStatus(true);
                    }
                }

                for (int i = 0; i < users.getOwners().size(); i++) {
                    if (hallOwner.equals(users.getOwners().get(i).getUserName())) {
                        phoneNo = users.getOwners().get(i).getPhoneNo();
                    }
                }

                boolean hallStatus = false;

                int totalDays = users.calculateTotalDays(startDate, endDate);
                int hallPrice = 0;
                for (int i = 0; i < users.getHalls().size(); i++) {
                    if (hallName.equals(users.getHalls().get(i).getHallName())) {
                        hallPrice = users.getHalls().get(i).getHallPrice();
                    }
                }
                String customerType = "";
                double discountRate = 1.0;
                for (int i = 0; i < users.getCustomers().size(); i++) {
                    if (customerLogin.equals(users.getCustomers().get(i).getUserName()))
                        customerType = users.getCustomers().get(i).getCustomerType();
                }

                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if (customerType.equals(users.getDiscounts().get(i).getCustomerType()))
                        discountRate = users.getDiscounts().get(i).getDiscountRate();
                }
                double totalAmount = 0.0;
                if (catering) {
                    totalAmount = totalDays * hallPrice * 1.2 * discountRate;
                    users.addBooking(bId, currentDate, hallName, hallOwner, customerLogin, startDate, endDate, hallStatus, totalAmount);
                    System.out.println("---------------Payment-----------------------");
                    System.out.println("Total Amount is:" + totalDays + "(days) * " + hallPrice + "(Price per day) * 1.2(Catering) * " + discountRate + "(Special Discount) = $" + totalAmount);
                } else {
                    totalAmount = totalDays * hallPrice * discountRate;
                    users.addBooking(bId, currentDate, hallName, hallOwner, customerLogin, startDate, endDate, hallStatus, totalAmount);
                    System.out.println("Total Amount is:" + totalDays + "(days) * " + hallPrice + "(Price per day) * " + discountRate + "= $" + totalAmount);

                }

                boolean paymentMet = true;
                if (paymentMethod == 1) {
                    System.out.println("---------------Payment Method-----------------");
                    System.out.println("This hall owner just accepts CASH payment only!");
                    System.out.println("----------------------------------------------");
                    System.out.println("Hall owner's phone number:" + phoneNo);
                    System.out.println("Please contact the hall owner and pay as soon as possible!");
                    System.out.println("Thank you for choosing Prime Events!");
                } else if (paymentMethod == 2) {
                    System.out.println("---------------Payment Method-----------------");
                    System.out.println("This hall owner just accepts CARD payment only!");
                    System.out.println("----------------------------------------------");
                    System.out.print("Name On Card: ");
                    String name = keyboard.nextLine();
                    while (users.isName(name)) {
                        System.out.println("Invalid Input!");
                        System.out.print("Name On Card:");
                        name = keyboard.nextLine();
                    }

                    System.out.print("Card Number: ");
                    String cardNo = keyboard.nextLine();
                    while (!users.idLengthVal(cardNo, 16) || !users.isName(cardNo)) {
                        System.out.println("Please enter the correct card number:");
                        cardNo = keyboard.nextLine();
                    }

                    System.out.print("CVV:");
                    String cvv = keyboard.nextLine();
                    while (!users.idLengthVal(cvv, 3) || !users.isName(cvv)) {
                        System.out.print("Please enter the correct CVV:");
                        cvv = keyboard.nextLine();
                    }
                    paymentMet = false;
                } else if (paymentMethod == 3 || paymentMethod == 0) {
                    System.out.println("---------------Payment Method-----------------");
                    System.out.println("1. Pay By Cash");
                    System.out.println("2. Pay By Card");
                    System.out.print("Please select the payment:");
                    int payment = users.choiceMenu(1, 2);
                    if (payment == 1) {
                        System.out.println("Please contact the hall owner and pay as soon as possible!");
                        System.out.println("Hall owner's phone number:" + phoneNo);
                        System.out.println("Thank you for choosing Prime Events!");
                        System.out.print("Press enter to back to the Main menu");
                        String enter = keyboard.nextLine();
                        chooseOption(1);
                    } else if (payment == 2) {
                        System.out.print("Name On Card: ");
                        String name = keyboard.nextLine();
                        while (users.isName(name)) {
                            System.out.println("Invalid Input!");
                            System.out.print("Name On Card:");
                            name = keyboard.nextLine();
                        }

                        System.out.print("Card Number: ");
                        String cardNo = keyboard.nextLine();
                        while (!users.idLengthVal(cardNo, 16) || !users.isName(cardNo)) {
                            System.out.println("Please enter the correct card number:");
                            cardNo = keyboard.nextLine();
                        }

                        System.out.print("CVV:");
                        String cvv = keyboard.nextLine();
                        while (!users.idLengthVal(cvv, 3) || !users.isName(cvv)) {
                            System.out.print("Please enter the correct CVV:");
                            cvv = keyboard.nextLine();
                        }
                        paymentMet = false;
                    }
                }
                System.out.println("Congratulations! Your payment has been accepted.");
                System.out.println("------Receipt------------------");
                System.out.println("|Payment ID:" + pId);
                System.out.println("|Total Amount: " + "$" + totalAmount);
                if (paymentMet) {
                    System.out.println("|Payment Method: Cash");
                } else {
                    System.out.println("|Payment Method: Card");
                }

                users.addPayment(pId, currentDate, totalDays * hallPrice, paymentMet);

                System.out.println("-------------------------------");
                System.out.print("Press Enter to back to the main menu:");
                String enter = keyboard.nextLine();
                chooseOption(1);
            }
        } else if (choice == 5) {
            boolean a = true;
            System.out.println("--------------------------------Booking List-------------------------------------------");
            System.out.println(" Booking ID   |Booking Date|     Hall Name      | Start Date | End Date  | Total Amount");
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < users.getBookings().size(); i++) {
                if (customerLogin.equals(users.getBookings().get(i).getCustomerName())) {
                    System.out.printf("%-" + 13 + "s", users.getBookings().get(i).getBookingId());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getBookings().get(i).getBookingDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 18 + "s", users.getBookings().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getBookings().get(i).getStartDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getBookings().get(i).getEndDate());
                    System.out.print(" | ");
                    System.out.print(users.getBookings().get(i).getTotalAmount());
                    System.out.println("");
                    a = false;
                }
            }
            if (a) {
                System.out.println("No booking history!");
                System.out.println("Please book a hall first!");
                System.out.println("Press Enter to back to the Main menu");
                String enter = keyboard.nextLine();
                chooseOption(1);
            } else {

                System.out.print("Please enter the booking ID to cancel the booking:");
                String bookingId = keyboard.nextLine();
                boolean check = true;
                while (check) {
                    for (int j = 0; j < users.getBookings().size(); j++) {
                        if (bookingId.equals(users.getBookings().get(j).getBookingId()))
                            check = false;
                    }
                    if (!check)
                        break;
                    System.out.println("Please enter the correct Booking id or Press 0 to back to the main menu!");
                    System.out.print("BookingID:");
                    bookingId = keyboard.nextLine();
                    if (bookingId == "0")
                        chooseOption(1);
                }
                for (int i = 0; i < users.getBookings().size(); i++) {
                    if (bookingId.equals(users.getBookings().get(i).getBookingId())) {
                        users.getBookings().remove(users.getBookings().get(i));
                    }
                }
                System.out.println("The booking has been cancelled!");
                System.out.println("Your money will be returned to the payment account within three days.");
                System.out.print("Press Enter to back to the Main menu");
                String enter = keyboard.nextLine();
                chooseOption(1);
            }
        } else if (choice == 6) {
            boolean a = true;
            System.out.println("--------------------------------Booking List-------------------------------------------");
            System.out.println(" Booking ID   |Booking Date|     Hall Name      | Start Date | End Date  | Total Amount");
            System.out.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < users.getBookings().size(); i++) {
                if (customerLogin.equals(users.getBookings().get(i).getCustomerName())) {
                    System.out.printf("%-" + 13 + "s", users.getBookings().get(i).getBookingId());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getBookings().get(i).getBookingDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 18 + "s", users.getBookings().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getBookings().get(i).getStartDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getBookings().get(i).getEndDate());
                    System.out.print(" | ");
                    System.out.print(users.getBookings().get(i).getTotalAmount());
                    System.out.println("");
                    a = false;
                }
            }
            if (a) {
                System.out.println("No booking history!");
                System.out.println("Please book a hall first!");
                System.out.println("Press Enter to back to the Main menu");
                String enter = keyboard.nextLine();
                chooseOption(1);
            } else {

                System.out.print("Please enter the booking ID to rate and write a review for this Hall:");
                String bookingId = keyboard.nextLine();
                boolean check = true;
                String hallName = "";
                while (check) {
                    for (int j = 0; j < users.getBookings().size(); j++) {
                        if (bookingId.equals(users.getBookings().get(j).getBookingId())) {
                            check = false;
                            hallName = users.getBookings().get(j).getHallName();
                        }

                    }
                    if (!check)
                        break;
                    System.out.println("Please enter the correct Booking id!");
                    System.out.print("Booking ID:");
                    bookingId = keyboard.nextLine();
                }
                System.out.print("Rating the hall(1~5, 5 is the highest):");
                int rating = users.choiceMenu(1, 5);
                System.out.println("Write a review for this hall:");
                String review = keyboard.nextLine();
                while (users.isEmpty(review)) {
                    System.out.println("Review can not be empty!");
                    System.out.print("Review:");
                    review = keyboard.nextLine();
                }
                users.addReview(hallName, rating, review);

                System.out.println("Thank you!");
                chooseOption(1);
            }
        } else if (choice == 7) {
            System.out.println("Logout Successful!");
            customerLogin = "";
            run();
        } else {
            System.out.println("Invalid Input!");
        }

    }

    public void optionOwner(int choice) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("------------Create Hall----------------------------");
            System.out.println("Please enter the following Hall's information");

            String sformat = "MMddhhmmssSSS";
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat(sformat);
            String dateString = formatter.format(currentTime);
            String id = dateString;

            System.out.print("Hall name:");
            String hallName = keyboard.nextLine();
            while (users.isEmpty(hallName)) {
                System.out.println("Hall Name can not be empty!");
                System.out.print("Hall Name:");
                hallName = keyboard.nextLine();
            }
            System.out.print("Hall Price(per day):");
            int hallPrice = users.numberRange(1, 9999);
            System.out.print("Hall Location:");
            String hallLocation = keyboard.nextLine();
            while (users.isEmpty(hallLocation)) {
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
            int typeOption = users.choiceMenu(1, 5);
            String eventType = "";
            if (typeOption == 1) {
                eventType = "Wedding ceremony";
            } else if (typeOption == 2) {
                eventType = "Wedding reception";
            } else if (typeOption == 3) {
                eventType = "Birthday";
            } else if (typeOption == 4) {
                eventType = "Anniversary";
            } else if (typeOption == 5) {
                eventType = "All";
            }
            System.out.print("Please enter the hall capacity:");
            int hallCapacity = users.capacity(1, 9999);
            users.addHalls("H" + id, hallName, hallPrice, hallLocation, eventType, hallCapacity, ownerLogin);
            System.out.println("Create Successful!");
            chooseOption(2);
        } else if (choice == 2) {
            System.out.println("-------------------------------------Halls List------------------------------------------------");
            System.out.println("   Hall ID     |     Hall Name      | Hall Price | Hall Location |       Type        | Capacity");
            System.out.println("-----------------------------------------------------------------------------------------------");

            boolean a = true;
            for (int i = 0; i < users.getHalls().size(); i++) {
                if (ownerLogin.equals(users.getHalls().get(i).getHallOwner())) {
                    System.out.print(users.getHalls().get(i).getId());
                    System.out.print(" | ");
                    System.out.printf("%-" + 18 + "s", users.getHalls().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getHalls().get(i).getHallPrice());
                    System.out.print(" | ");
                    System.out.printf("%-" + 13 + "s", users.getHalls().get(i).getHallLocation());
                    System.out.print(" | ");
                    System.out.printf("%-" + 17 + "s", users.getHalls().get(i).getEventType());
                    System.out.print(" | ");
                    System.out.print(users.getHalls().get(i).getCapacity());
                    System.out.println("");
                    a = false;
                }
            }
            if (a) {
                System.out.println("No hall was added!");
                System.out.println("Please add a hall first!");
                System.out.println("Press Enter to back to the Main menu");
                String enter = keyboard.nextLine();
                chooseOption(2);
            } else {
                System.out.print("Please choose the hall you want to DELETE(Hall id):");
                String hallId = keyboard.nextLine();
                String hallName = "";
                boolean check = true;
                while (check) {
                    for (int j = 0; j < users.getHalls().size(); j++) {
                        if (hallId.equals(users.getHalls().get(j).getId())) {
                            hallName = users.getHalls().get(j).getHallName();
                            check = false;
                        }
                    }
                    if (!check)
                        break;
                    System.out.println("Please enter the correct hall id!");
                    System.out.print("Hall ID:");
                    hallId = keyboard.nextLine();
                }

                boolean qCheck = false;
                for (int i = 0; i < users.getQuotations().size(); i++) {
                    if (hallName.equals(users.getQuotations().get(i).getHallName()))
                        qCheck = true;
                }
                if (qCheck) {
                    System.out.println("Please deal with the quotation order of this hall first!");
                    System.out.println("Press Enter to back to the Main menu");
                    String enter = keyboard.nextLine();
                    chooseOption(2);
                } else {
                    System.out.println("The owner has to complete the order that has been paid for, even if you delete hall!");
                    System.out.println("1. Accept");
                    System.out.println("2. Decline");
                    System.out.print("Please enter your choice:");
                    int confirm = users.choiceMenu(1, 2);
                    if (confirm == 1) {
                        for (int i = 0; i < users.getHalls().size(); i++) {
                            if (hallId.equals(users.getHalls().get(i).getId())) {
                                users.getHalls().remove(users.getHalls().get(i));
                            }
                        }
                        System.out.println("Delete Hall successful!");
                        System.out.println("Press Enter to back to the Main menu");
                        String enter = keyboard.nextLine();
                        chooseOption(2);
                    } else {
                        System.out.println("Delete Hall failed!");
                        System.out.println("Press Enter to back to the Main menu");
                        String enter = keyboard.nextLine();
                        chooseOption(2);
                    }
                }
            }
        } else if (choice == 3) {
            System.out.println("----------------------Booking List--------------------------");
            System.out.println("   Booking ID  |     Hall Name      | Start Date | End Date");
            System.out.println("------------------------------------------------------------");
            boolean a = false;
            for (int i = 0; i < users.getBookings().size(); i++) {
                if (ownerLogin.equals(users.getBookings().get(i).getHallOwner())) {
                    System.out.print(users.getBookings().get(i).getBookingId());
                    System.out.print(" | ");
                    System.out.printf("%-" + 18 + "s", users.getBookings().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getBookings().get(i).getStartDate());
                    System.out.print(" | ");
                    System.out.print(users.getBookings().get(i).getEndDate());
                    System.out.println("");
                    a = true;
                }
            }
            if (a) {
                System.out.println("---------------------------------------------------------------");
                System.out.print("Please enter Booking ID to cancel the booking:");
                String bookingId = keyboard.nextLine();
                boolean check = true;
                while (check) {
                    for (int j = 0; j < users.getBookings().size(); j++) {
                        if (bookingId.equals(users.getBookings().get(j).getBookingId()))
                            check = false;
                    }
                    if (!check)
                        break;
                    System.out.println("Please enter the correct booking id!");
                    System.out.print("BookingID:");
                    bookingId = keyboard.nextLine();
                }
                for (int i = 0; i < users.getBookings().size(); i++) {
                    if (bookingId.equals(users.getBookings().get(i).getBookingId()))
                        users.getBookings().remove(users.getBookings().get(i));
                }
                System.out.println("Cancel booking successful!");
                System.out.print("Press Enter to back to the main menu");
                String enter = keyboard.nextLine();
                chooseOption(2);
            } else {
                System.out.println("No booking history!");
                chooseOption(2);
            }
        } else if (choice == 4) {
            System.out.println("---------------Payments----------------------------");
            System.out.println("1. Pay by Cash");
            System.out.println("2. Pay by Card");
            System.out.println("3. Pay by Cash or Credit Card");
            System.out.print("Please select the payment method you accept:");
            paymentMethod = users.choiceMenu(1, 3);
            System.out.println("Update Successful!");
            System.out.print("Press Enter to back to the main menu");
            String enter = keyboard.nextLine();
            chooseOption(2);
        } else if (choice == 5) {
            double discountRate1 = 1.0;
            double discountRate2 = 1.0;
            double discountRate3 = 1.0;
            for (int i = 0; i < users.getDiscounts().size(); i++) {
                if ("Veterans".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate1 = users.getDiscounts().get(i).getDiscountRate();
                } else if ("Senior Citizens".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate2 = users.getDiscounts().get(i).getDiscountRate();
                } else if ("Others".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate3 = users.getDiscounts().get(i).getDiscountRate();
                }
            }
            System.out.println("------------Manage Discount----------------------------");
            System.out.println("The discount rate is as follows");
            System.out.println("Veterans = " + discountRate1);
            System.out.println("Senior Citizens = " + discountRate2);
            System.out.println("Others = " + discountRate3);

            System.out.println("1. Veterans");
            System.out.println("2. Senior Citizens");
            System.out.println("3. Others");
            System.out.print("Please choose the option you want to edit:");
            int option = users.choiceMenu(1, 3);
            if (option == 1) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Veterans".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
            } else if (option == 2) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Senior Citizens".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
            } else if (option == 3) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Others".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
            }
            System.out.println("Edit Successful!");
            System.out.print("Press Enter to back to the main menu");
            String enter = keyboard.nextLine();
            chooseOption(2);
        } else if (choice == 6) {
            boolean a = false;
            System.out.println("---------------------------------Response Quotation---------------------------");
            System.out.println("     Hall Name      |  Customer Name  | Start Date |  End Date  | Quotation ID");
            System.out.println("------------------------------------------------------------------------------");
            for (int i = 0; i < users.getQuotations().size(); i++) {
                if (ownerLogin.equals(users.getQuotations().get(i).getHallOwner()) && !users.getQuotations().get(i).getQuotationStatus()) {
                    System.out.printf("%-" + 19 + "s", users.getQuotations().get(i).getHallName());
                    System.out.print(" | ");
                    System.out.printf("%-" + 15 + "s", users.getQuotations().get(i).getCustomer());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getQuotations().get(i).getStartDate());
                    System.out.print(" | ");
                    System.out.printf("%-" + 10 + "s", users.getQuotations().get(i).getEndDate());
                    System.out.print(" | ");
                    System.out.print(users.getQuotations().get(i).getQuotationId());
                    System.out.println("");
                    a = true;
                }
            }
            if (!a) {
                System.out.println("No quotation!");
                chooseOption(2);
            } else {
                System.out.println("------------------------------------------------------");
                System.out.println("Please select the quotation you want to respond(Enter Quotation ID): ");
                String quotationId = keyboard.nextLine();
                boolean check = true;
                while (check) {
                    for (int j = 0; j < users.getQuotations().size(); j++) {
                        if (quotationId.equals(users.getQuotations().get(j).getQuotationId()))
                            check = false;
                    }
                    if (!check)
                        break;
                    System.out.println("Please enter the correct quotation id!");
                    System.out.print("QuotationID:");
                    quotationId = keyboard.nextLine();
                }
                System.out.println("1. Accept");
                System.out.println("2. Decline");
                System.out.print("Please enter your choice:");
                int quoChoice = users.choiceMenu(1, 2);
                if (quoChoice == 1) {
                    for (int i = 0; i < users.getQuotations().size(); i++) {
                        if (quotationId.equals(users.getQuotations().get(i).getQuotationId())) {
                            users.getQuotations().get(i).setQuotationStatus(true);
                        }
                    }
                } else if (quoChoice == 2) {
                    for (int i = 0; i < users.getQuotations().size(); i++) {
                        if (quotationId.equals(users.getQuotations().get(i).getQuotationId())) {
                            users.getQuotations().remove(users.getQuotations().get(i));
                        }
                    }
                }
                System.out.println("Thank you!");
                chooseOption(2);
            }
        } else if (choice == 7) {
            System.out.println("Logout Successful!");
            ownerLogin = "";
            run();
        } else {
            System.out.println("Invalid Input!");
            chooseOption(1);
        }
    }

    public void optionAdmin(int choice) throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("---------------Manage Users----------------------------");
            System.out.println("1. View customers' information");
            System.out.println("2. View owners' information");
            System.out.println("3. Delete customer's account");
            System.out.println("4. Delete owner's account");
            System.out.print("Please enter your choice:");
            int manageChoice = users.choiceMenu(1, 4);
            if (manageChoice == 1) {
                System.out.println("----------------------");
                System.out.println(" Customer ID | Username ");
                System.out.println("----------------------");
                for (int i = 0; i < users.getCustomers().size(); i++) {
                    System.out.print(users.getCustomers().get(i).getId());
                    System.out.print("|");
                    System.out.print(users.getCustomers().get(i).getUserName());
                    System.out.println("");
                }
                System.out.println("----------------------");
                chooseOption(3);
            } else if (manageChoice == 2) {
                System.out.println("----------------------");
                System.out.println(" Owner ID | Username ");
                System.out.println("----------------------");
                for (int i = 0; i < users.getOwners().size(); i++) {
                    System.out.print(users.getOwners().get(i).getId());
                    System.out.print(" | ");
                    System.out.print(users.getOwners().get(i).getUserName());
                    System.out.println("");
                }
                System.out.println("----------------------");
                chooseOption(3);
            } else if (manageChoice == 3) {
                boolean a = true;
                System.out.println("Please enter the customer ID to delete customer's account");
                System.out.println("---------------------------------------------------------");
                String customerId = keyboard.nextLine();
                for (int i = 0; i < users.getCustomers().size(); i++) {
                    if (customerId.equals(users.getCustomers().get(i).getId())) {
                        users.getCustomers().remove(i);
                        System.out.println("Delete Successful!");
                        a = false;
                    }
                }
                if (a) {
                    System.out.println("There is no corresponding ID!");
                    chooseOption(3);
                }
                chooseOption(3);
            } else if (manageChoice == 4) {
                boolean a = true;
                System.out.println("Please enter the owner ID to delete customer's account");
                System.out.println("---------------------------------------------------------");
                String customerId = keyboard.nextLine();
                for (int i = 0; i < users.getOwners().size(); i++) {
                    if (customerId.equals(users.getOwners().get(i).getId())) {
                        users.getOwners().remove(i);
                        System.out.println("Delete Successful!");
                        a = false;
                    }
                }
                if (a) {
                    System.out.println("There is no corresponding ID!");
                    chooseOption(3);
                }
                chooseOption(3);
            }
        } else if (choice == 2) {
            double discountRate1 = 1.0;
            double discountRate2 = 1.0;
            double discountRate3 = 1.0;
            for (int i = 0; i < users.getDiscounts().size(); i++) {
                if ("Veterans".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate1 = users.getDiscounts().get(i).getDiscountRate();
                } else if ("Senior Citizens".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate2 = users.getDiscounts().get(i).getDiscountRate();
                } else if ("Others".equals(users.getDiscounts().get(i).getCustomerType())) {
                    discountRate3 = users.getDiscounts().get(i).getDiscountRate();
                }
            }
            System.out.println("------------Manage Discount----------------------------");
            System.out.println("The discount rate is as follows");
            System.out.println("Veterans = " + discountRate1);
            System.out.println("Senior Citizens = " + discountRate2);
            System.out.println("Others = " + discountRate3);

            System.out.println("1. Veterans");
            System.out.println("2. Senior Citizens");
            System.out.println("3. Others");
            System.out.print("Please choose the option you want to edit:");
            int option = users.choiceMenu(1, 3);
            if (option == 1) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Veterans".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
                System.out.println("Edit Successful!");
                chooseOption(3);
            } else if (option == 2) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Senior Citizens".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
                System.out.println("Edit Successful!");
                chooseOption(3);
            } else if (option == 3) {
                System.out.print("Please enter the new discount rate(10-100): %");
                int rate = users.discountRate(10, 100);
                for (int i = 0; i < users.getDiscounts().size(); i++) {
                    if ("Others".equals(users.getDiscounts().get(i).getCustomerType())) {
                        users.getDiscounts().get(i).setDiscountRate(rate * 0.01);
                    }
                }
                System.out.println("Edit Successful!");
                chooseOption(3);
            }
        } else if (choice == 3) {
            System.out.println("Logout Successful!");
            run();
        }
    }
}