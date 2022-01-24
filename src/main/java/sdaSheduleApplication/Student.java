package sdaSheduleApplication;


public class Student extends Person {



    private boolean hasPreviousJavaKnowledge;
    private Trainer trainer;

    public Student(String firstName, String lastName, int age, boolean hasPreviousJavaKnowledge, Trainer trainer) {
        super(firstName, lastName, age);
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }


}
