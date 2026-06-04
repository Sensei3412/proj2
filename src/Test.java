public class Test {
    
    public static void main(String[] args) {
       int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] odd; 
        int[] even;

        int oddCount = 0;
        int evenCount = 0;
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
               evenCount++; 
            } else {
                oddCount++;
            }
        }
        
        odd = new int[oddCount];
        even = new int[evenCount];
        
        int oddIndex = 0;
        int evenIndex = 0;
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                even[evenIndex++] = num[i];
            } else {
                odd[oddIndex++] = num[i];
            }
        }
        System.out.print(odd.length + " ");

    }
}