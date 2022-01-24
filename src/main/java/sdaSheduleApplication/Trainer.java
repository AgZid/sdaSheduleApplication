package sdaSheduleApplication;


public class Trainer extends Person{

    private boolean isExperienced;

    public Trainer(String firstName, String lastName, int age, boolean isExperienced) {
        super(firstName, lastName, age);
        this.isExperienced = isExperienced;
    }

    public boolean isExperienced() {
        return isExperienced;
    }

}
