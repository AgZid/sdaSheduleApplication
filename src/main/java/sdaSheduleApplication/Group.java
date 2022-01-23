package sdaSheduleApplication;

import lombok.Data;

import java.util.Set;

@Data
public class Group {

    private String groupName;
    private Trainer trainer;
    private Set<Student> students;

    public Group(String groupName, Trainer trainer, Set<Student> students) {

        try {
            if (students.size() > 5) {
                throw new MaximumNumberOfStudentsReached("Maximum number of students is reached" );
            }
        } catch (MaximumNumberOfStudentsReached e) {
            System.out.println(groupName + " " + e.getMessage());
        }

        this.groupName = groupName;
        this.trainer = trainer;
        this.students = students;
    }
}