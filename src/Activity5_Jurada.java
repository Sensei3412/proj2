public class Activity5_Jurada {
    public static void main(String[] args) {

        String word = "PneumonouLtraMicrosCopicSilicovolcanoconiosiS";
        
        int consonantCount = 0;
        String consonantsList = ""; 
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
                    ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') {
                    
                    consonantsList += ch + " ";
                    
                    consonantCount++;
                }
            }
        }
        System.out.println("Consonants: " + consonantsList);
        System.out.println("Total: " + consonantCount);
    }
}
