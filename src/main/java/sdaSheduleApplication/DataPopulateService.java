package sdaSheduleApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataPopulateService {

    public static List<Group> dataInitialisation() {
        List<Group> groups = new ArrayList<>();
        Trainer trainerG1 = new Trainer("Juozas", "Juozaitis", 30, true);
        Trainer trainerG2 = new Trainer("Benas", "Benaitis", 31, false);
        Trainer trainerG3 = new Trainer("Jonas", "Jonaitis", 30, true);
        Trainer trainerG4 = new Trainer("Aloyzas", "Petras", 60, true);

        Student studentAntanas  = new Student("Antanas", "Antanaitis", 20, true, trainerG2);
        Student studentAlgis  = new Student("Algis", "Algaitis", 25, true, trainerG1);
        Student studentOna  = new Student("Ona", "Onaite", 30, false, trainerG2);

        Set<Student> studentsG1 = new HashSet<>();
        studentsG1.add(studentAlgis);
        studentsG1.add(studentAntanas);
        studentsG1.add(studentOna);

        Group groupG1 = new Group("G1",trainerG1, studentsG1 );

        Student studentRapolas  = new Student("Rapolas", "Rapolaitis", 28, false, trainerG1);
        Student studentSimas  = new Student("Simas", "Simaitis", 19, true, trainerG3);
        Student studentMaryte  = new Student("Maryte", "Marytyte", 26, true, trainerG4);

        Set<Student> studentsG2 = new HashSet<>();
        studentsG2.add(studentRapolas);
        studentsG2.add(studentSimas);
        studentsG2.add(studentMaryte);

        Group groupG2 = new Group("G2",trainerG2, studentsG2 );



        Student studentPetras = new Student("Petras", "Petrauskas", 20, true, trainerG4);
        Student studentDomas = new Student("Domas", "Domauskas", 19, false, trainerG3);
        Student studentSamas = new Student("Samas", "Samonavicius", 18, false, trainerG4);
        Student studentLinas = new Student("Linas", "Luktauskas", 21, true, trainerG1);

        Set<Student> studentsG3 = new HashSet<>();
        studentsG3.add(studentDomas);
        studentsG3.add(studentLinas);
        studentsG3.add(studentPetras);
        studentsG3.add(studentSamas);

        Group groupG3 = new Group("G3",trainerG3, studentsG3);


        Student studentDovydas = new Student("Dovydas", "Justinas", 21, true, trainerG1);
        Student studentJustinas = new Student("Justinas", "Dumbrauskas", 20, false, trainerG2);
        Student studentSkirmantas = new Student("Skirmantas", "Simonas", 18, false, trainerG2);
        Student studentMartynas = new Student("Martynas", "Lukminas", 19, false, trainerG3);
        Student studentJakterina = new Student("Jakaterina", "Fedorcuk", 19, true, trainerG4);
        Student studentJadvyga = new Student("Jadvyga", "Fedorcuk", 20, true, trainerG4);

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
