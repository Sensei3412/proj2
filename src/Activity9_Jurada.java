class OddNumberException extends IllegalArgumentException {
    public OddNumberException(String message) {
        super(message);
    }
}
public class Activity9_Jurada {

    public void checkIfEven(int number) {
        if (number % 2 != 0) {
            throw new OddNumberException("Error: " + number + " is odd.");
        } else {
            System.out.println(number + " is even.");
        }
    }

    public static void main(String[] args) {
        Activity9_Jurada checker = new Activity9_Jurada();

        System.out.println("Let's say the number is 14:");
        try {
            checker.checkIfEven(14);
        } catch (OddNumberException e) { 
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Let's say the number is 17:");
        try {
            checker.checkIfEven(17);
        } catch (OddNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}