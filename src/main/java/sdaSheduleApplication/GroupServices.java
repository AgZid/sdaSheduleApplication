package sdaSheduleApplication;

import java.util.*;
import java.util.stream.Collectors;

public class GroupServices {

    List<Group> groups;

    public GroupServices(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> sortStudentsAlphabetically(String groupToSortName) {
        List<Student> studentsToSort = groups.stream()
                .filter(group -> group.getGroupName().equalsIgnoreCase(groupToSortName))
                .flatMap(group -> group.getStudents().stream())
                .collect(Collectors.toList());

        StudentLastnameComporator studentLastnameComparator = new StudentLastnameComporator();
        Collections.sort(studentsToSort, studentLastnameComparator);

        return studentsToSort;
    }

    public Optional<String> searchMaxNumberOfStudents() {
        return Optional.of(groups.stream()
                .max(Comparator.comparingInt(groups -> groups.getStudents().size()))
                .map(Group::getGroupName)
                .orElse("Tuscias sarasas"));

    }

    public List<Student> searchStudentsYoungerThanX(int ageToCompare) {
        return groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> student.getAge() < ageToCompare)
                .collect(Collectors.toList());

    }

    public Map<Trainer, List<Student>> provideTrainersAndStudents() {
        return  groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> Objects.nonNull(student))
                .collect(Collectors.groupingBy(student -> student.getTrainer()));

    }

    public List<Student> searchStudentsHavingJavaKnowledge() {
        return groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> student.isHasPreviousJavaKnowledge())
                .collect(Collectors.toList());
    }

    public List<Trainer> searchTrainersWithNoExperience() {
        return groups.stream()
                .filter(group -> !group.getTrainer().isExperienced())
                .map(group -> group.getTrainer())
                .collect(Collectors.toList());
    }

    public String searchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge() {
        Map<String, Long> groupsJavaKnowledge = groups.stream()
                .collect(Collectors.toMap(
                        group -> group.getGroupName(),
                        (group -> group.getStudents().stream()
                                .filter(student -> !student.isHasPreviousJavaKnowledge())
                                .count()

                        )));

        return groupsJavaKnowledge.entrySet().stream()
                .max(Comparator.comparingInt(value -> value.getValue().intValue()))
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .orElse("");


    }

    public void removeStudentsYoungerThanX(int ageToCompare) {
        groups.forEach(group -> group.getStudents()
                .removeIf(student -> student.getAge() < ageToCompare));
    }



}
