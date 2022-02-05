package sdaSheduleApplication;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * SDA scheduler application
 * Create class Person (Parent class) having fields firstName, lastName, age
 * Create class Trainer extends Person having field isExperienced (boolean)
 * Create class Student extends Person having field hasPreviousJavaKnowledge (boolean)
 * Create class Group having fields name (eg. JavaVilnius11) , one Trainer and list of Students.
 * Create class DataPopulateService which would have static method with a return type of List<Group> and would initialize and return list of 4 groups.
 * Each group should have 2-5 students, and one trainer.
 * <p>
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

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Group> groups = DataPopulateService.dataInitialisation();

        GroupServices groupServices = new GroupServices(groups);
        GroupsMain groupsMain = new GroupsMain();

        groupsMain.menuOptions();
        String userChoose = scanner.nextLine();

        while (!userChoose.equals("0")) {

            switch (userChoose) {
                case "1":
                    System.out.println();
                    System.out.println("Enter group name:");
                    String selectedGroup = scanner.nextLine();
                    groupsMain.sortStudentsInGroup(groupServices, selectedGroup);
                    break;
                case "2":
                    System.out.println();
                    System.out.println("Maximum number of students:");
                    System.out.println(groupServices.searchMaxNumberOfStudents());
                    break;
                case "3": {
                    System.out.println();
                    System.out.println("Enter age parameter:");
                    String enteredValue = scanner.nextLine();
                    groupsMain.showAllStudentsYoungerThanX(groupServices, enteredValue);
                    break;
                }
                case "4":
                    System.out.println();
                    System.out.println("All students grouped by trainer that teaches to them:");
                    groupsMain.showAllStudensGroupedByTrainers(groupServices);
                    break;
                case "5":
                    System.out.println();
                    System.out.println("All students with previous java knowledge:");
                    groupServices.searchStudentsHavingJavaKnowledge()
                            .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
                    break;
                case "6":
                    System.out.println();
                    System.out.println("All trainers who are NOT experienced:");
                    groupServices.searchTrainersWithNoExperience()
                            .forEach(trainer -> System.out.println(trainer.getFirstName() + " " + trainer.getLastName()));
                    break;
                case "7":
                    System.out.println();
                    System.out.println("Group with the highest number of students with no previous java knowledge:");
                    System.out.println(groupServices.searchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge());
                    break;
                case "8": {
                    System.out.println();
                    System.out.println("Remove all the students younger than X age from all groups:");
                    System.out.println("Before remove:");
                    groupsMain.showAllGroups(groups);
                    System.out.println("Enter age parameter:");
                    String enteredValue = scanner.nextLine();
                    try {
                        int selectedAge = Integer.parseInt(enteredValue);
                        groupServices.removeStudentsYoungerThanX(selectedAge);
                        System.out.println("After remove:");
                        groupsMain.showAllGroups(groups);

                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
                case "9": {
                    groupsMain.showAllGroups(groups);
                    break;
                }
            }
            groupsMain.menuOptions();
            userChoose = scanner.nextLine();
        }
    }

    private void showAllGroups(List<Group> groups) {
        groups.forEach(group -> group.getStudents()
                .forEach(student ->
                        System.out.println(student.getAge() + " m. " + student.getFirstName() + " " + student.getLastName())));
    }

    private void showAllStudensGroupedByTrainers(GroupServices groupServices) {
        Map<Trainer, List<Student>> trainers = groupServices.provideTrainersAndStudents();
        trainers.forEach((trainer, students) -> {
            System.out.println("Trainer " + trainer.getFirstName() + " " + trainer.getLastName() + " students:");
            students.forEach(student -> System.out.println("-" + student.getFirstName() + " " + student.getLastName()));
        });
    }

    private void showAllStudentsYoungerThanX(GroupServices groupServices, String enteredValue) {
        try {
            int selectedAge = Integer.parseInt(enteredValue);
            System.out.println("All students younger than " + selectedAge + ":");
            groupServices.searchStudentsYoungerThanX(selectedAge).forEach(student ->
                    System.out.println(student.getAge() + " m. " + student.getFirstName() + " " + student.getLastName()));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    private void sortStudentsInGroup(GroupServices groupServices, String selectedGroup) {
        System.out.println("Sorted students by lastname in group " + selectedGroup + ":");
        List<Student> studentsSorted = groupServices.sortStudentsAlphabetically(selectedGroup);
        studentsSorted.forEach(student -> System.out.println(student.getLastName() + " " + student.getFirstName()));
    }

    private void menuOptions() {
        System.out.println();
        System.out.println("Select option:");
        System.out.println("1 - Sort students in group X");
        System.out.println("2 - Find maximum number of students");
        System.out.println("3 - Find all students younger than X age");
        System.out.println("4 - Show all students grouped by trainer that teaches to them");
        System.out.println("5 - Show all students with previous java knowledge");
        System.out.println("6 - Show all trainers who are NOT experienced");
        System.out.println("7 - Show group with the highest number of students with no previous java knowledge");
        System.out.println("8 - Remove all the students younger than X age from all groups");
        System.out.println("9 - Show all groups");
        System.out.println("0 - Exit menu");
    }
}
