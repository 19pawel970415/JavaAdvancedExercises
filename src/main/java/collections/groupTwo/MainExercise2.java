package collections.groupTwo;

import java.util.*;

public class MainExercise2 {

    public static void main(String[] args) {

        //2.
        //Stwórz oddzielnego maina, a w nim kolejną listę integerów. Wykonaj zadania:
        //- dodaj do listy 10 liczb losowych
        //- oblicz sumę elementów na liście (wypisz ją)
        //- oblicz średnią elementów na liście (wypisz ją)
        //- stwórz kopię listy i ją posortuj
        //- podaj medianę elementów na liście posortowanej (wypisz ją)
        //- znajdź największy i najmniejszy element na liście która nie była sortowana. Zrób to pętlą foreach
        //- po znalezieniu elementu znajdź index elementu maksymalnego używając kolejnej pętli foreach
        //- po znalezieniu elementów (największy i najmniejszy) znajdź index posługując się metodą indexof
        //Sprawdź działanie aplikacji

        List<Integer> integers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int integer = random.nextInt(100) + 0;
            integers.add(Integer.valueOf(integer));
        }

        int counter = 0;
        int max = integers.get(0);
        int min = integers.get(0);

        for (Integer integer : integers) {
            if (integer >= max) {
                max = integer;
            }
            if (integer <= min) {
                min = integer;
            }
        }

        for (Integer integer : integers) {
            if (integer == max) {
                break;
            }
            counter++;
        }

        System.out.println(counter);
        System.out.println(integers.indexOf(max));

        counter = 0;

        for (Integer integer : integers) {
            if (integer == min) {
                break;
            }
            counter++;
        }

        System.out.println(counter);
        System.out.println(integers.indexOf(min));


        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        System.out.println(sum);
        System.out.println((double) sum / (double) integers.size());

        Collections.sort(integers);

        for (Integer integer : integers) {
            System.out.println(integer);
        }


        counter = 0;
        int sum1 = 0;
        for (Integer integer : integers) {
            if (counter == 4 || counter == 5) {
                sum1 += integer;
            }
            counter++;
        }

        double median = (double) sum1 / 2.0d;
        System.out.println(median);

        //3.
        //Stwórz oddzielnego maina, a w nim kolejną listę String'ów. Wykonaj zadania:
        //- dodaj do listy elementy 10030, 3004, 4000, 12355, 12222, 67888, 111200, 225355,
        //2222, 1111, 3546, 138751, 235912 (jako stringi) (dodaj je posługując się metodą
        //Arrays.asList())
        //Przykład użycia Arrays.asList():
        //ArrayList<Integer> liczby = new ArrayList<>(Arrays.asList(23, 32, 44, 55, 677, 11, 33));
        //Podany przykład to tylko demonstracja metody Arrays.asList, zadanie należy
        //wykonać na liście String’ów.
        //- określ indeks elementu 138751 posługując się metodą indexOf
        //- sprawdź czy istnieje na liście obiekt 67888 metodą contains (wynik wypisz na ekran)
        //- sprawdź czy istnieje na liście obiekkt 67889 metodą contains (wynik wypisz na ekran)
        //- usuń z listy obiekt 67888 oraz 67889 (metoda remove)
        //- wykonaj ponownie powyższe sprawdzenia.- iteruj całą listę, wypisz elementy na ekran (a. w jednej linii, b. każdy element w
        //oddzielnej linii).
        //Sprawdź działanie aplikacji.
        //4.
        //Stwórz oddzielnego maina, a w nim kolejną listę String'ów. Wykonaj zadania:
        //- dodaj do listy losowe 100 elementów z zakresu 0-100. (​konwersja int na string to
        //String.valueOf())
        //- oblicz średnią liczb
        //- usuń wszystkie liczby powyżej średniej
        //- wypisz wszystkie liczby
        //- wykonaj kopię listy do tablicy
        //Sprawdź działanie aplikacji.
        //5. ​Stwórz klasę Student która posiada pola:
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
        //Wszystkie polecenia zrealizowane jako VarArgs.
    }

}
