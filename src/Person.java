public class Person {

    private String personId;
    private String fullName;
    private int age;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayPersonDetails() {
        System.out.println("--- Person Details ---");
        System.out.println("ID: " + personId);
        System.out.println("Name: " + fullName);
        System.out.println("Age: " + age);
    }
}