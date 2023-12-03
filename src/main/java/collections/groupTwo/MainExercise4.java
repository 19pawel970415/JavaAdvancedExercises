package collections.groupTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MainExercise4 {

    public static void main(String[] args) {

        //        //4.
        //        //Stwórz oddzielnego maina, a w nim kolejną listę String'ów. Wykonaj zadania:
        //        //- dodaj do listy losowe 100 elementów z zakresu 0-100.
        //        //- oblicz średnią liczb
        //        //- usuń wszystkie liczby powyżej średniej
        //        //- wypisz wszystkie liczby
        //        //- wykonaj kopię listy do tablicy
        //        //Sprawdź działanie aplikacji.

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int rand = random.nextInt(100 + 0);
            strings.add(String.valueOf(rand));
        }

        for (String string : strings) {
            System.out.print(string + " ");
        }

        System.out.println();

        int sum = 0;
        for (String string : strings) {
            sum += Integer.valueOf(string);
        }
        double average = (double) sum / (double) strings.size();

        System.out.println(average);

        List<String> stringsSmallerThanAverage = strings.stream()
                .filter(string -> Integer.parseInt(string) <= average)
                .collect(Collectors.toList());

        for (String s : stringsSmallerThanAverage) {
            System.out.print(s + " ");
        }

        System.out.println();

        String[] stringsArray = new String[strings.size()];
        for (int i = 0; i < stringsArray.length; i++) {
            stringsArray[i] = strings.get(i);
        }
        for (String s : stringsArray) {
            System.out.print(s + " ");
        }
        System.out.println();


        String[] stringsSmallerThanAverageArray = new String[stringsSmallerThanAverage.size()];
        for (int i = 0; i < stringsSmallerThanAverageArray.length; i++) {
            stringsSmallerThanAverageArray[i] = stringsSmallerThanAverage.get(i);
        }
        for (String s : stringsSmallerThanAverageArray) {
            System.out.print(s + " ");
        }
    }

}
