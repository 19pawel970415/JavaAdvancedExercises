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
    }

}
