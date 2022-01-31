package sdaSheduleApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class GroupServicesTest {

    GroupServices groupServices;
    List<Group> groups;

    @BeforeEach
    void createGroups() {
        groups = DataPopulateService.dataInitialisation();
        groupServices = new GroupServices(groups);
    }

    @Test
    void testSortStudentsAlphabetically() {
        assertThat(groupServices.sortStudentsAlphabetically("G4")
                .get(5).getLastName()).isEqualTo("Simonas");
        assertThat(groupServices.sortStudentsAlphabetically("G4")
                .get(0).getLastName()).isEqualTo("Dumbrauskas");
    }

    @Test
    void testSortStudentsAlphabetically_invalidOrder() {
        assertThat(groupServices.sortStudentsAlphabetically("G4")
                .get(0).getLastName().equalsIgnoreCase("Simonas")).isFalse();
        assertThat(groupServices.sortStudentsAlphabetically("G4")
                .get(5).getLastName().equalsIgnoreCase("Dumbrauskas")).isFalse();
    }

    @Test
    void testSearchMaxNumberOfStudents() {
        Optional<String> groupName = groupServices.searchMaxNumberOfStudents();
        Optional<String> testValue = Optional.of("G4");

        assertThat(groupName).isPresent();
        assertThat(groupName).isEqualTo(testValue);
    }

    @Test
    void testSearchMaxNumberOfStudents_invalidGroupName() {
        Optional<String> groupName = groupServices.searchMaxNumberOfStudents();
        Optional<String> testValue = Optional.of("G1");

        assertThat(groupName).isPresent();
        assertThat(groupName).isNotEqualTo(testValue);
    }

    @Test
    void testSearchStudentsYoungerThanX() {
        assertThat(groupServices.searchStudentsYoungerThanX(20)).size().isEqualTo(6);
        assertThat(groupServices.searchStudentsYoungerThanX(19)).size().isEqualTo(2);
        assertThat(groupServices.searchStudentsYoungerThanX(18)).size().isEqualTo(0);
    }

    @Test
    void testProvideTrainersAndStudents() {
        Map<Trainer, List<Student>> trainers = groupServices.provideTrainersAndStudents();
        List<Student> studentsTrainerG3 = trainers.entrySet().stream()
                .filter(trainerListEntry -> trainerListEntry.getKey().getLastName().equalsIgnoreCase("Jonaitis"))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertThat(studentsTrainerG3).size().isEqualTo(3);
        assertThat(studentsTrainerG3).extracting(Person::getLastName).containsAnyOf("Simaitis");

    }

    @Test
    void testProvideTrainersAndStudents_invalidStudentLastName() {
        Map<Trainer, List<Student>> trainers = groupServices.provideTrainersAndStudents();
        List<Student> studentsTrainerG3 = trainers.entrySet().stream()
                .filter(trainerListEntry -> trainerListEntry.getKey().getLastName().equalsIgnoreCase("Jonaitis"))
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertThat(studentsTrainerG3).extracting(Person::getLastName).doesNotContain("Justinas");
    }

    @Test
    void testSearchStudentsHavingJavaKnowledge() {
        List<Student> students = groupServices.searchStudentsHavingJavaKnowledge();
        assertThat(students).size().isEqualTo(9);
        assertThat(students).extracting(Person::getLastName).containsAnyOf("Antanaitis");
    }

    @Test
    void testSearchStudentsHavingJavaKnowledge_invalidStudentLastName() {
        List<Student> students = groupServices.searchStudentsHavingJavaKnowledge();
        assertThat(students).extracting(Person::getLastName).doesNotContain("Onaite");
    }

    @Test
    void testSearchTrainersWithNoExperience() {
        List<Trainer> trainersWithoutExperience = groupServices.searchTrainersWithNoExperience();
        assertThat(trainersWithoutExperience).size().isEqualTo(1);
        assertThat(trainersWithoutExperience).extracting(Person::getLastName).containsAnyOf("Benaitis");

    }

    @Test
    void testSearchTrainersWithNoExperience_invalidTrainerLastName() {
        List<Trainer> trainersWithoutExperience = groupServices.searchTrainersWithNoExperience();
        assertThat(trainersWithoutExperience).extracting(Person::getLastName).doesNotContain("Petras");

    }

    @Test
    void testSearchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge() {
        assertThat(groupServices.searchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge()).isEqualTo("G4");
    }

    @Test
    void testSearchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge_invalidGroupName() {
        assertThat(groupServices.searchGroupWithHighestNumberOfStudentsWithoutJavaKnowledge()).isNotEqualTo("G1");
    }

    @Test
    void testRemoveStudentsYoungerThanX() {
        groupServices.removeStudentsYoungerThanX(20);
        List<Student> students = groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .collect(Collectors.toList());

        assertThat(students).size().isEqualTo(10);
        assertThat(students)
                .extracting(Person::getLastName).containsAnyOf("Fedorcuk");

    }

    @Test
    void testRemoveStudentsYoungerThanX_invalidStudent() {
        groupServices.removeStudentsYoungerThanX(20);
        List<Student> students = groups.stream()
                .flatMap(group -> group.getStudents().stream())
                .collect(Collectors.toList());

        assertThat(students)
                .extracting(Person::getLastName).doesNotContain("Simonas");

    }
}