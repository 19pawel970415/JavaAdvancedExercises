package collections.groupTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainExercise3 {

    public static void main(String[] args) {

        ////3.
        //        //Stwórz oddzielnego maina, a w nim kolejną listę String'ów. Wykonaj zadania:
        //        //- dodaj do listy elementy 10030, 3004, 4000, 12355, 12222, 67888, 111200, 225355,
        //        //2222, 1111, 3546, 138751, 235912 (jako stringi)
        //        //- określ indeks elementu 138751 posługując się metodą indexOf
        //        //- sprawdź czy istnieje na liście obiekt 67888
        //        //- sprawdź czy istnieje na liście obiekkt 67889
        //        //- usuń z listy obiekt 67888 oraz 67889
        //        //- wykonaj ponownie powyższe sprawdzenia.
        //        - iteruj całą listę, wypisz elementy na ekran (a. w jednej linii, b. każdy element w
        //        //oddzielnej linii).
        //        //Sprawdź działanie aplikacji.

        List<String> strings = new ArrayList<>(Arrays.asList("10030", "3004", "4000", "12355", "12222", "67888", "111200", "225355", "2222", "1111", "3546", "138751", "235912"));

        int i = strings.indexOf("138751");

        System.out.println(i);

        boolean contains = strings.contains("67888");

        if (contains) {
            System.out.println("67888 is on the list");
        }

        boolean contains1 = strings.contains("67889");

        if (contains1) {
            System.out.println("67889 is on the list");
        }

        strings.remove("67888");
        strings.remove("67889");

        contains = strings.contains("67888");

        if (contains) {
            System.out.println("67888 is on the list");
        } else {
            System.out.println("Gone");
        }

        contains1 = strings.contains("67889");

        if (contains1) {
            System.out.println("67889 is on the list");
        } else {
            System.out.println("Gone");
        }

        for (String string : strings) {
            System.out.print(string + " ");
        }

        System.out.println();

        for (String string : strings) {
            System.out.println(string);
        }
    }

}
