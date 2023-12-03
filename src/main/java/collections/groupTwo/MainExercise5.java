package collections.groupTwo;

import java.util.ArrayList;
import java.util.List;

public class MainExercise5 {

    public static void main(String[] args) {

        //5. Stwórz klasę Student która posiada pola:
        //nr indeksu
        //imie
        //nazwisko
        //płeć (wartość enum)
        //W mainie stwórz instancję kolekcji typu ArrayList, która zawiera obiekty klasy Student.
        //Dodaj do kolekcji kilku studentów (dodaj je ręcznie - wpisz cokolwiek).
        //a. Spróbuj wypisać elementy listy stosując zwykłego "sout'a"
        //b. Spróbuj wypisać elementy stosując pętlę foreach
        //c. Wypisz tylko kobiety
        //d. Wypisz tylko mężczyzn
        //e. Wypisz tylko indeksy osób

        List<Student5> student5s = new ArrayList<Student5>();

        Student5 student5 = new Student5("40735","Paul","Smith", Gender5.MALE);
        Student5 student51 = new Student5("48712","Anna","Crane", Gender5.FEMALE);
        Student5 student52 = new Student5("43423","Michael","Toss", Gender5.MALE);
        Student5 student53 = new Student5("32132","Angelina","Freeman", Gender5.FEMALE);

        student5s.add(student5);
        student5s.add(student51);
        student5s.add(student52);
        student5s.add(student53);

        System.out.println(student5s);

        System.out.println();

        for (Student5 s : student5s) {
            System.out.println(s);
        }

        System.out.println();

        student5s.stream()
                .filter(s -> s.getGender5().equals(Gender5.FEMALE))
                .forEach(System.out::println);

        System.out.println();

        student5s.stream()
                .filter(s -> s.getGender5().equals(Gender5.MALE))
                .forEach(System.out::println);

        System.out.println();

        student5s.stream()
                .map(s -> s.getStudentsCardNumber())
                .forEach(System.out::println);
    }

}
