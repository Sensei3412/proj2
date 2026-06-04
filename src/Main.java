import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Create creator = new Create();
        Read reader = new Read();
        Update updater = new Update();
        Delete deleter = new Delete();

        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Forgot password");
            System.out.println("3. Check Info");
            System.out.println("4. Buy");
            System.out.println("Press Enter without typing to Log out securely.");
            System.out.println("Pick a number: ");
            System.out.print("Input: ");
           
            
            String mainInput = scanner.nextLine();

            // Handle Empty Enter Trigger for Log Out
            if (mainInput.trim().isEmpty()) {
                System.out.println("\n--- Secure Logout Verification ---");
                System.out.print("Enter ID: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid ID format.\n");
                    scanner.nextLine();
                    continue;
                }
                int inputId = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                
                System.out.print("Password: ");
                String inputPassword = scanner.nextLine();
                
                boolean isLoggedOut = deleter.deleteUserSecurely(inputId, inputPassword);
                if (isLoggedOut) {
                    System.out.println("\n---- Successfully Log out ----\n");
                } else {
                    System.out.println("\nLogout Failed: Incorrect ID or Password combination.\n");
                }
                continue;
            }

            // Process explicit menu items using Switch/Case
            switch (mainInput) {
                case "1":
                    // Choice 1: Registration Input Prompts
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please enter a valid number for Age.");
                        System.out.print("Age: ");
                        scanner.next();
                    }
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    // Ticket Choice Sub-Menu Placement
                    System.out.println("\n----- Buy a Ticket -----");
                    System.out.println("1. Regular");
                    System.out.println("2. VIP");
                    System.out.println("Pick a Number");
                    System.out.print("Input: ");
                    
                    int ticketChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    String ticketType = (ticketChoice == 2) ? "VIP" : "Regular";

                    creator.registerUser(name, age, email, password, ticketType);
                    System.out.println();
                    break;

                case "2":
                    System.out.print("User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                
                    System.out.print("Old password: ");
                    String oldPwd = scanner.nextLine();
                    
                    System.out.print("New password: ");
                    String newPwd = scanner.nextLine();

                    boolean isUpdated = updater.updatePassword(userId, oldPwd, newPwd);
                    if (isUpdated) {
                        System.out.println("\nChange successfully!\n");
                    } else {
                        System.out.println("\nUpdate Failed: Old password is incorrecct.\n");
                    }
                    break;

                case "3":
                   
                    System.out.print("Id: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid numeric ID format.\n");
                        scanner.nextLine();
                        break;
                    }
                    int checkId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    
                    System.out.print("Password: ");
                    String checkPassword = scanner.nextLine();
                    
                    reader.checkUserInfo(checkId, checkPassword);
                    System.out.println();
                    break;

                case "4":
                    System.out.println("\n1. Premium Meal Set - $100");
                    System.out.println("2. Regular Meal Set - $50");
                    System.out.println("3. Budget Meal Set - $10");
                    System.out.println("Pick a number");
                    System.out.print("Input: ");
                    
                    int mealChoice = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    String mealPicked = "";
                    switch (mealChoice) {
                        case 1: mealPicked = "Premium Meal Set"; break;
                        case 2: mealPicked = "Regular Meal Set"; break;
                        case 3: mealPicked = "Budget Meal Set"; break;
                        default:
                            System.out.println("Invalid selection.\n");
                            break;
                    }

                    if (mealPicked.isEmpty()) break;

                    System.out.println("\nEnter your ID");
                    System.out.print("Input: ");
                    int buyUserId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    // Fire the simplified update
                    creator.buyMealSimple(buyUserId, mealPicked);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid menu option selection.\n");
                    break;
            }
        }
    }
}