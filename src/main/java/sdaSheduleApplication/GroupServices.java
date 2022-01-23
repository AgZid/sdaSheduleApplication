package sdaSheduleApplication;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    public Optional<String> searchMaxNumberOfStudents () {

        Optional<String> groupWithMaxStudents = Optional.of(groups.stream()
                .max(Comparator.comparingInt(groups -> groups.getStudents().size()))
                .map(group -> group.getGroupName())
                .orElse("Tuscias sarasas"));

       return groupWithMaxStudents;
    }

    public List<Student> groupWithStudentsYoungerThanX (int ageToCompare) {
        return groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .filter(student -> student.getAge() < ageToCompare)
                .collect(Collectors.toList());

    }

//    public List<Person> provideTrainersAndStudents () {
//
//        return
//
//    }





}
