package sdaSheduleApplication;

import java.util.Comparator;

public class StudentLastnameComporator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return firstStudent.getLastName().compareTo(secondStudent.getLastName());
    }
}
