public class Activity2_Jurada {
    public static void main (String[] args) {
        int num=10;
        int num1=11;
        boolean bool1 = ( (num % 2) == 0);
        boolean bool2 = ( (num1++ % 2) == 0);

    String result1 = ( bool1 ) ? "true \n "+ num :"false \n"+ num;
    String result2 = ( bool2 ) ? "true \n "+ num1 :"false \n"+ num1;
    
    System.out.println(result1);
    System.out.println(result2);
        
 
}
    



}
