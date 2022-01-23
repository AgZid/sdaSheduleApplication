package sdaSheduleApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataPopulateService {

    public static List<Group> dataInitialisation() {
        List<Group> groups = new ArrayList<>();

        Trainer trainerG1 = new Trainer("Jonas", "Jonaitis", 30, true);
        Student studentAntanas  = new Student("Antanas", "Antanaitis", 20, true);
        Student studentAlgis  = new Student("Algis", "Algaitis", 25, true);
        Student studentOna  = new Student("Ona", "Onaite", 30, false);

        Set<Student> studentsG1 = new HashSet<>();
        studentsG1.add(studentAlgis);
        studentsG1.add(studentAntanas);
        studentsG1.add(studentOna);

        Group groupG1 = new Group("G1",trainerG1, studentsG1 );

        Trainer trainerG2 = new Trainer("Benas", "Benaitis", 31, false);
        Student studentRapolas  = new Student("Rapolas", "Rapolaitis", 28, false);
        Student studentSimas  = new Student("Simas", "Simaitis", 19, true);
        Student studentMaryte  = new Student("Maryte", "Marytyte", 26, true);

        Set<Student> studentsG2 = new HashSet<>();
        studentsG2.add(studentRapolas);
        studentsG2.add(studentSimas);
        studentsG2.add(studentMaryte);

        Group groupG2 = new Group("G2",trainerG2, studentsG2 );

        Trainer trainerG3 = new Trainer("Jonas", "Jonaitis", 30, true);
        Student studentPetras = new Student("Petras", "Petrauskas", 20, true);
        Student studentDomas = new Student("Domas", "Domauskas", 19, false);
        Student studentSamas = new Student("Samas", "Samonavicius", 18, false);
        Student studentLinas = new Student("Linas", "Luktauskas", 21, true);

        Set<Student> studentsG3 = new HashSet<>();
        studentsG3.add(studentDomas);
        studentsG3.add(studentLinas);
        studentsG3.add(studentPetras);
        studentsG3.add(studentSamas);

        Group groupG3 = new Group("G3",trainerG3, studentsG3);

        Trainer trainerG4 = new Trainer("Aloyzas", "Petras", 60, true);
        Student studentDovydas = new Student("Dovydas", "Justinas", 21, true);
        Student studentJustinas = new Student("Justinas", "Dumbrauskas", 20, false);
        Student studentSkirmantas = new Student("Skirmantas", "Simonas", 18, false);
        Student studentMartynas = new Student("Martynas", "Lukminas", 19, true);
        Student studentJakterina = new Student("Jakaterina", "Fedorcuk", 19, true);
        Student studentJadvyga = new Student("Jadvyga", "Fedorcuk", 20, true);

        Set<Student> studentsG4 = new HashSet<>();
        studentsG4.add(studentDovydas);
        studentsG4.add(studentJustinas);
        studentsG4.add(studentSkirmantas);
        studentsG4.add(studentMartynas);
        studentsG4.add(studentJakterina);
        studentsG4.add(studentJadvyga);

        Group groupG4 = new Group("G4",trainerG4, studentsG4);

        groups.add(groupG1);
        groups.add(groupG2);
        groups.add(groupG3);
        groups.add(groupG4);

        return groups;
    }
}
