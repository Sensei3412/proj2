public class Activity3_Jurada {
    
    public static void main(String[] args) {
        int startNumber = 1;
        int iteration = 10;
        int commonDifference = 5;
        
        int sum = 0;
        long product = 1;
        
        System.out.println("Initial Number: " + startNumber);
        System.out.println("No. of Iterations: " + iteration);
        System.out.println("Common Difference: " + commonDifference);
        System.out.println("\n");
        
        System.out.print("Sum: ");
        int currentNum = startNumber;
        for (int counterVariable = 1; counterVariable <= iteration; counterVariable++) {
            sum += currentNum;
            System.out.print(currentNum);
            
            if (counterVariable < iteration) {
                System.out.print(" + ");
            }
            currentNum += commonDifference;
        }
        System.out.println(" = " + sum);
        
        System.out.print("Product: ");
        currentNum = startNumber;
        for (int counterVariable = 1; counterVariable <= iteration; counterVariable++) {
            product *= currentNum;
            System.out.print(currentNum);
            
            if (counterVariable < iteration) {
                System.out.print(" * ");
            }
            currentNum += commonDifference;
        }
        System.out.print(" = ");
        System.out.format("%,d\n", product);
    }
}