package collections.groupTwo;

import java.util.List;

public class MainExercise6 {

    public static void main(String[] args) {

        //6.
        //Stwórz aplikację, a w niej klasę Dziennik i Student. Klasa Student powinna:
        //- posiadać listę ocen studenta (List<Double>)
        //- posiadać (pole) numer indeksu studenta (String)
        //- posiadać (pole) imię studenta
        //- posiadać (pole) nazwisko studenta
        //Klasa Dziennik powinna:
        //- posiadać (jako pole) listę Studentów.
        //- posiadać metodę 'dodajStudenta(Student):void' do dodawania nowego studenta do
        //dziennika
        //- posiadać metodę 'usuńStudenta(Student):void' do usuwania studenta
        //- posiadać metodę 'usuńStudenta(String):void' do usuwania studenta po jego numerze
        //indexu
        //- posiadać metodę 'zwróćStudenta(String):Student' która jako parametr przyjmuje numer
        //indexu studenta, a w wyniku zwraca konkretnego studenta.
        //- posiadać metodę 'podajŚredniąStudenta(String):double' która przyjmuje indeks studenta
        //i zwraca średnią ocen studenta.
        //- posiadać metodę 'podajStudentówZagrożonych():List<Student>'
        //- posiadać metodę 'posortujStudentówPoIndeksie():List<Student>' - która sortuje listę
        //studentów po numerach indeksów, a następnie zwraca posortowaną listę.
        //- posiadać metodę ‘dodajOcene(String, Double):void’
        //*Polecenia VarArgs:
        //- dodanie kilku studentów
        //- usunięcie kilku studentów
        //- wyszukiwanie studentów (i zwrócenie znalezionych w liście)
        //- dodanie/usuwanie ocen studentom

        Student6 student = new Student6("Paul", "Crane", List.of(5.0d, 4.5d, 3.5d, 3d), "12345");
        Student6 student1 = new Student6("Nina", "Shovel", List.of(5.0d, 4.5d, 5.0d, 4.5d), "54321");
        Student6 student2 = new Student6("Anna", "Smith", List.of(5.0d, 2.0d, 3.5d, 3d), "98765");
        Student6 student3 = new Student6("Dominic", "Toss", List.of(2.0d, 4.5d, 2.0d, 3d), "67384");
        Student6 student4 = new Student6("Dave", "Batista", List.of(5.0d, 3.0d, 4.0d, 4.0d), "12572");

        Register6 register = new Register6();

        register.addStudent(student);

        register.addStudents(student1, student2, student3, student4);

        register.removeStudent(student);

        register.removeStudentUsingStudentsCardNumber("54321");

        register.removeStudents(student2, student3);

        register.addStudents(student3);

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        register.addStudents(student3, student4);

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        register.removeStudentsUsingStudentsCardNumbers("12572", "67384");

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        register.addStudents(student, student1, student2, student3, student4);

        Double studentsAverage = register.getStudentsAverage("12345");
        System.out.println(studentsAverage);

        System.out.println();

        Double studentsAverage1 = register.getStudentsAverage("51651");
        System.out.println(studentsAverage1);

        System.out.println();

        List<Double> studentsAverages = register.getStudentsAverages("12345", "54321");
        studentsAverages.stream()
                .forEach(System.out::println);

        System.out.println();

        List<Student6> failingStudents = register.getFailingStudents();
        failingStudents.stream()
                .forEach(System.out::println);

        System.out.println();

        List<Student6> sortedStudents = register.sortStudents(register.getStudents());
        sortedStudents.stream()
                .forEach(System.out::println);

        System.out.println();

        register.addMark("12572", 2.0d);

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        List<Student6> failingStudents1 = register.getFailingStudents();
        failingStudents1.stream()
                .forEach(System.out::println);

        System.out.println();

        register.addMarkForStudents(5d, "98765", "67384");

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        register.addMarksForStudent("12345", 5d, 4d, 3d);

        for (Student6 registerStudent : register.getStudents()) {
            System.out.println(registerStudent);
        }

        System.out.println();

        Student6 studentUsingStudentsCardNumber = register.getStudentUsingStudentsCardNumber("12345");
        System.out.println(studentUsingStudentsCardNumber);

        System.out.println();

        List<Student6> studentsUsingStudentsCardNumbers = register.getStudentsUsingStudentsCardNumbers("54321", "98765");
        studentsUsingStudentsCardNumbers.stream()
                .forEach(System.out::println);
    }

}
