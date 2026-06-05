import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Create creator = new Create();
        Read reader = new Read();
        Update updater = new Update();

        boolean isLoggedIn = false;
        int currentUserId = -1;
        String currentUserName = "";
        String currentUserTicket = "";
        String currentUserEmail = "";

        while (true) {
            if (!isLoggedIn) {
                System.out.println("1. Log in");
                System.out.println("2. Register");
                System.out.println("3. GUI Mode");
                System.out.println("Pick a number");
                System.out.print("Input: ");
                
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1": 
                        System.out.print("Name: ");
                        String loginName = scanner.nextLine();
                        System.out.print("Age: ");
                        int loginAge = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Email: ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Password: ");
                        String loginPwd = scanner.nextLine();

                        int foundId = reader.verifyLogin(loginName, loginAge, loginEmail, loginPwd);
                        
                        if (foundId != -1) {
                            currentUserId = foundId;
                            currentUserName = loginName;
                            currentUserEmail = loginEmail;

                            System.out.println("\n---- Ticket Required ----");
                            System.out.println("Buy Ticket");
                            System.out.println("1. Regular");
                            System.out.println("2. VIP");
                            System.out.println("Pick a number");
                            System.out.print("Input: ");
                            int tChoice = scanner.nextInt(); scanner.nextLine();
                            
                            currentUserTicket = (tChoice == 2) ? "VIP" : "Regular";
                            int tPrice = (tChoice == 2) ? 400 : 50;

                            updater.updateTicket(currentUserId, currentUserTicket, tPrice);

                            System.out.println("\n\"" + currentUserName + "\", \"" + currentUserId + "\", \"" + currentUserTicket + "\", \"" + currentUserEmail + "\"");
                            System.out.println("---- Welcome to Gala ----\n");
                            isLoggedIn = true;
                        } else {
                            System.out.println("\nInvalid credentials. Access Denied.\n");
                        }
                        break;

                    case "2":
                        System.out.println("\n---- Create User ----");
                        System.out.print("Name: ");
                        String regName = scanner.nextLine();
                        System.out.print("Email: ");
                        String regEmail = scanner.nextLine();
                        System.out.print("Age: ");
                        int regAge = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Password: ");
                        String regPwd = scanner.nextLine();

                        System.out.println("\n---- Ticket Required ----");
                        System.out.println("Buy Ticket");
                        System.out.println("1. Regular - $50");
                        System.out.println("2. VIP - $400");
                        System.out.println("Pick a number");
                        System.out.print("Input: ");
                        int regTChoice = scanner.nextInt(); scanner.nextLine();

                        currentUserTicket = (regTChoice == 2) ? "VIP" : "Regular";
                        int regTPrice = (regTChoice == 2) ? 400 : 50;

                        currentUserId = creator.registerUser(regName, regAge, regEmail, regPwd, currentUserTicket, regTPrice);
                        currentUserName = regName;
                        currentUserEmail = regEmail;

                        System.out.println("\n\"" + currentUserName + "\", \"" + currentUserId + "\", \"" + currentUserTicket + "\", \"" + currentUserEmail + "\"");
                        System.out.println("---- Welcome to Gala ----\n");
                        isLoggedIn = true;
                        break;

                    case "3":
                        runGuiMode(creator, reader, updater);
                        break;

                    default:
                        System.out.println("Invalid selection.\n");
                        break;
                }
            } else {
                System.out.println("\"" + currentUserId + "\", \"" + currentUserName + "\", \"" + currentUserTicket + "\"");
                System.out.println("1. Buy");
                System.out.println("2. Log out");
                System.out.println("Pick a number");
                System.out.print("Input: ");
                
                String idleChoice = scanner.nextLine();

                switch (idleChoice) {
                    case "1":
                        System.out.println("1. Premium Meal Set - $100");
                        System.out.println("2. Regular Meal Set - $50");
                        System.out.println("3. Budget Meal Set - $10");
                        System.out.println("Pick a number");
                        System.out.print("Input: ");
                        int mealNum = scanner.nextInt(); scanner.nextLine();

                        String foodName = "";
                        int foodPrice = 0;
                        if (mealNum == 1) { foodName = "Premium Meal Set"; foodPrice = 100; }
                        else if (mealNum == 2) { foodName = "Regular Meal Set"; foodPrice = 50; }
                        else { foodName = "Budget Meal Set"; foodPrice = 10; }

                        updater.addMealToUser(currentUserId, foodName, foodPrice);
                        System.out.println("\n---- Buy Success ----\n");
                        break;

                    case "2":
                        int totalCost = reader.calculateTotalBill(currentUserId);
                        
                        System.out.println("\nPayment Total: $" + totalCost);
                        System.out.println("Payment Method");
                        System.out.println("1. Card");
                        System.out.println("2. Cash");
                        System.out.println("3. E-Wallet");
                        System.out.println("Pick a number");
                        System.out.print("Input: ");
                        scanner.nextLine();
                        
                        System.out.println("\n---- Payment Receive ----\n");

                        isLoggedIn = false;
                        currentUserId = -1;
                        currentUserName = "";
                        currentUserTicket = "";
                        currentUserEmail = "";
                        break;

                    default:
                        System.out.println("Invalid option.\n");
                        break;
                }
            }
        }
    }

    private static void runGuiMode(Create creator, Read reader, Update updater) {
        while (true) {
            // ---- WELCOME SCREEN MENU (GUI) ----
            Object[] mainChoices = {"Log in", "Register", "Exit GUI"};
            int mainChoice = JOptionPane.showOptionDialog(null, 
                    "Select an option below:", "Gala Registration System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, mainChoices, mainChoices[0]);
            if (mainChoice == 2 || mainChoice == -1) {
                break; 
            }

            boolean isLoggedIn = false;
            int currentUserId = -1;
            String currentUserName = "";
            String currentUserTicket = "";
            String currentUserEmail = "";

            if (mainChoice == 0) { 
                String loginName = JOptionPane.showInputDialog("Name:");
                if (loginName == null) continue;
                
                String ageInput = JOptionPane.showInputDialog("Age:");
                if (ageInput == null) continue;
                int loginAge = Integer.parseInt(ageInput);
                
                String loginEmail = JOptionPane.showInputDialog("Email:");
                if (loginEmail == null) continue;
                
                String loginPwd = JOptionPane.showInputDialog("Password:");
                if (loginPwd == null) continue;

                int foundId = reader.verifyLogin(loginName, loginAge, loginEmail, loginPwd);
                
                if (foundId != -1) {
                    currentUserId = foundId;
                    currentUserName = loginName;
                    currentUserEmail = loginEmail;

                    Object[] tickets = {"Regular", "VIP"};
                    int tSel = JOptionPane.showOptionDialog(null, 
                            "Buy Ticket\n1. Regular\n2. VIP", "---- Ticket Required ----",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tickets, tickets[0]);
                    
                    currentUserTicket = (tSel == 1) ? "VIP" : "Regular";
                    int tPrice = (tSel == 1) ? 400 : 50;

                    updater.updateTicket(currentUserId, currentUserTicket, tPrice);

                    JOptionPane.showMessageDialog(null, 
                            "\"" + currentUserName + "\", \"" + currentUserId + "\", \"" + currentUserTicket + "\", \"" + currentUserEmail + "\"\n---- Welcome to Gala ----");
                    isLoggedIn = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Access Denied.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (mainChoice == 1) {
                JOptionPane.showMessageDialog(null, "---- Create User ----");
                String regName = JOptionPane.showInputDialog("Name:");
                if (regName == null) continue;
                
                String regEmail = JOptionPane.showInputDialog("Email:");
                if (regEmail == null) continue;
                
                String ageInput = JOptionPane.showInputDialog("Age:");
                if (ageInput == null) continue;
                int regAge = Integer.parseInt(ageInput);
                
                String regPwd = JOptionPane.showInputDialog("Password:");
                if (regPwd == null) continue;

                Object[] tickets = {"Regular - $50", "VIP - $400"};
                int regTSel = JOptionPane.showOptionDialog(null, 
                        "Buy Ticket\n1. Regular - $50\n2. VIP - $400", "---- Ticket Required ----",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tickets, tickets[0]);

                currentUserTicket = (regTSel == 1) ? "VIP" : "Regular";
                int regTPrice = (regTSel == 1) ? 400 : 50;

                currentUserId = creator.registerUser(regName, regAge, regEmail, regPwd, currentUserTicket, regTPrice);
                currentUserName = regName;
                currentUserEmail = regEmail;

                JOptionPane.showMessageDialog(null, 
                        "\"" + currentUserName + "\", \"" + currentUserId + "\", \"" + currentUserTicket + "\", \"" + currentUserEmail + "\"\n---- Welcome to Gala ----");
                isLoggedIn = true;
            }

            while (isLoggedIn) {
                Object[] idleOptions = {"Buy", "Log out"};
                int idleChoice = JOptionPane.showOptionDialog(null, 
                        "\"" + currentUserId + "\", \"" + currentUserName + "\", \"" + currentUserTicket + "\"", "Idle Opt Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, idleOptions, idleOptions[0]);

                if (idleChoice == 0) {
                    Object[] meals = {"Premium Meal Set - $100", "Regular Meal Set - $50", "Budget Meal Set - $10"};
                    int mealSel = JOptionPane.showOptionDialog(null, "Pick a Meal Set:", "Menu Selection",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, meals, meals[0]);

                    if (mealSel != -1) {
                        String foodName = "";
                        int foodPrice = 0;
                        if (mealSel == 0) { foodName = "Premium Meal Set"; foodPrice = 100; }
                        else if (mealSel == 1) { foodName = "Regular Meal Set"; foodPrice = 50; }
                        else { foodName = "Budget Meal Set"; foodPrice = 10; }

                        updater.addMealToUser(currentUserId, foodName, foodPrice);
                        JOptionPane.showMessageDialog(null, "---- Buy Success ----");
                    }

                } else if (idleChoice == 1 || idleChoice == -1) { 
                    int totalCost = reader.calculateTotalBill(currentUserId);
                    
                    Object[] paymentMethods = {"Card", "Cash", "E-Wallet"};
                    JOptionPane.showOptionDialog(null, 
                            "Payment Total: $" + totalCost + "\n\nSelect Payment Method:", "Payment Method",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, paymentMethods, paymentMethods[0]);
                    
                    JOptionPane.showMessageDialog(null, "---- Payment Receive ----");
                    
                    isLoggedIn = false;
                }
            }

        }
    }
}
    
