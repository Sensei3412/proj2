public class Activity8_Jurada {
    public static void main(String[] args) {

        Person client = new Person();
        client.setPersonId("MNG-2026-B1");
        client.setFullName("Danny Cruz"); 
        client.setAge(23);
        client.displayPersonDetails();
        System.out.println();

        BankAccount checking = new BankAccount();
        checking.setAccountNumber("1000084182");
        checking.setBalance(3000.0);
        
        System.out.println("--- Testing Bank Account ---");
        checking.deposits(500.0); 
        checking.withdraw(2000.0); 
        checking.withdraw(1000.0); 
        System.out.println();
        checking.displayAccountDetails();
        System.out.println();

        SavingsAccount savings = new SavingsAccount();
        savings.setAccountNumber("999888777");
        savings.setBalance(2000.0);
        
        System.out.println("--- Testing Savings Account Rule ---");
        System.out.println();
        savings.displayAccountDetails();
        
        savings.withdraw(600.0); 

        savings.withdraw(400.0);

        System.out.println();
        
        savings.displayAccountDetails();
    }
}