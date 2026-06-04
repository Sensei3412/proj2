public class Activity1_Jurada {
    static String firstname = "Dan Michael";
    static String lastname = "Jurada";
    String instanceVariable = "Lugta";
    String instanceVariable2 = "Laua-an";
    String instanceVariable3 = "Antique";
    int localVariable = 20;

    public static void main(String[] args) {
        Activity1_Jurada app = new Activity1_Jurada();
        System.out.print( "Name: " + Activity1_Jurada.firstname + " ");
        System.out.println(Activity1_Jurada.lastname);
        System.out.println("Barangay: " + app.instanceVariable);
        System.out.println("MUnicipality: " + app.instanceVariable2);
        System.out.println("Province: " + app.instanceVariable3);
        System.out.println("Age: " + app.localVariable);
        System.err.println();
        System.out.println("TrueOrFalse: " + (boolean) false);
        System.out.println("Grade: " + (char) 'A');
        System.out.println("Temperature: " + (float) 37.5); 


    }
}