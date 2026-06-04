class PersonalInfo {
    
    public void printBasicInfo() {
        System.out.println("My Personal Information");
        System.out.println("Name: Pedro Delos Santos");
        System.out.println("Age:  30");
        System.out.println("Address: San Pedro, San Jose, Antique");
        System.out.println("Email: myname@mngtvi.edu.ph\n");
    }
    
    public void printAboutMe() {
        System.out.println("My Skills:");
        System.out.println("- Java Programming");
        System.out.println("- Object-Oriented Design");
        System.out.println("- Logic Formulation\n");
    }
}

class ThePalindrome {
    
    public void checkPalindrome() {
        System.out.println("The Palindrome");
        
        String word1 = "Civic";
        verifyWord(word1);
        
        String word2 = "Java";
        verifyWord(word2);
        System.out.println();
    }
    
    private void verifyWord(String original) {
        String cleanWord = original.toLowerCase();
        String reverse = "";
        
        for (int i = cleanWord.length() - 1; i >= 0; i--) {
            reverse += cleanWord.charAt(i);
        }
        
        System.out.println("Check Word: " + original);
        if (cleanWord.equals(reverse)) {
            System.out.println(original + " is Palindrome");
        } else {
            System.out.println(original + " is NOT a Palindrome");
        }
    }
}

class NutritionalStatus {
    // Initializing tracking metrics as instance variables
    double weightKg = 50.0;
    double heightCm = 165.0;
    double waistCm = 65.0;
    double tempCelsius = 35.0;
    
    // a. Print metric values
    public void printNutritionalStatus() {
        System.out.println("My Nutritional Status");
        System.out.println("Weight: " + (int)weightKg + " kg.");
        System.out.println("Height: " + (int)heightCm + " cm.");
        System.out.println("Waist: " + (int)waistCm + " cm.");
        System.out.println("Body Temperature: " + (int)tempCelsius + "°C\n");
    }
    
    public void convertNutritionalStatus() {
        double weightLb = weightKg * 2.20462262;
        double heightIn = heightCm * 0.39370079;
        double waistIn = waistCm * 0.39370079;
        double tempFahrenheit = (tempCelsius * 9 / 5) + 32;
        
        System.out.println("Converted Nutritional Status");
        System.out.println("Weight: " + weightLb + " lb.");
        System.out.println("Height: " + heightIn + " in.");
        System.out.println("Waist: " + waistIn + " in.");
        System.out.println("Body Temperature: " + (int)tempFahrenheit + "°F\n");
    }
    
    public void checkBMI() {
        double heightMeters = heightCm / 100.0;
        double bmi = weightKg / (heightMeters * heightMeters);
        
        System.out.println("My Body Mass Index");
        System.out.printf("BMI: %.1f\n", bmi);
        
        System.out.print("Status: ");
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.println("Normal");
        } else if (bmi >= 25.0 && bmi < 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        System.out.println();
    }
}

class MyManagement {
    
    public void display() {
        PersonalInfo info = new PersonalInfo();
        info.printBasicInfo();
        info.printAboutMe();
        
        ThePalindrome palindrome = new ThePalindrome();
        palindrome.checkPalindrome();
        
        NutritionalStatus status = new NutritionalStatus();
        status.printNutritionalStatus();
        status.convertNutritionalStatus();
        status.checkBMI();
    }
}

public class Activity6_Jurada {
    public static void main(String[] args) {
        MyManagement manager = new MyManagement();
        manager.display();
    }
}