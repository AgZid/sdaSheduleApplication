package sdaSheduleApplication;

public class Student extends Person {

    private boolean hasPreviousJavaKnowledge;


    public Student(String firstName, String lastName, int age, boolean hasPreviousJavaKnowledge) {
        super(firstName, lastName, age);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }
}
