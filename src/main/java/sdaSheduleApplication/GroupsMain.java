package sdaSheduleApplication;

import java.util.List;

/**
 * SDA scheduler application
 * Create class Person (Parent class) having fields firstName, lastName, age
 * Create class Trainer extends Person having field isExperienced (boolean)
 * Create class Student extends Person having field hasPreviousJavaKnowledge (boolean)
 * Create class Group having fields name (eg. JavaVilnius11) , one Trainer and list of Students.
 * Create class DataPopulateService which would have static method with a return type of List<Group> and would initialize and return list of 4 groups.
 *     Each group should have 2-5 students, and one trainer.
 *
 * Ensure the fact that a group will only have distinct students (How would you do that?)
 * Ensure the fact that a group will only have a maximum of 5 students; When you try to add a 6th one throw an MaximumNumberOfStudentsReached exception
 * Display all students in a group sorted alphabetically by lastName or display ALL students alphabetically.
 * Display the group with the maximum number of students
 * Display all students younger than 25
 * Display all students grouped by trainer that teaches to them (eg. Trainer1 - stud1, stud3, stud4; Trainer2 - stud2, stud 10) - regardless of the group they're part of (If you were to store this information in a data structure what would you use?)
 * Display all students with previous java knowledge
 * Display all trainers who are NOT experienced.
 * Display the group with the highest number of students with no previous java knowledge
 * Remove all the students younger than 20 from all groups
 */
public class GroupsMain {

    public static void main(String[] args) {

        List<Group> groups = DataPopulateService.dataInitialisation();

        GroupServices groupServices = new GroupServices(groups);
        System.out.println("Sort students:");
        List<Student> studentsSorted =  groupServices.sortStudentsAlphabetically("G4");
        studentsSorted.forEach(student -> System.out.println(student.getLastName() + " " + student.getFirstName()));

        System.out.println();
        System.out.println("Maximum number of students:");
        System.out.println(groupServices.searchMaxNumberOfStudents());

        System.out.println();
        System.out.println("All students younger than 25");
        groupServices.groupWithStudentsYoungerThanX(25).forEach(student ->
                System.out.println(student.getAge() + " m. " + student.getFirstName() + " " + student.getLastName() ));
    }
}
