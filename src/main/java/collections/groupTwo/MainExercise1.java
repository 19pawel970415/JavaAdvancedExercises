package collections.groupTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainExercise1 {

    public static void main(String[] args) {

        //1.
        //Stwórz listę Integerów. Wykonaj zadania:
        //- dodaj do listy 5 elementów ze scannera
        //- dodaj do listy 5 elementów losowych
        //- wypisz elementy
        //Sprawdź działanie aplikacji.

        List<Integer> integers = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter " + (i + 1) + ". number: ");
            Integer integer = scanner.nextInt();
            integers.add(integer);
        }

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int integer = random.nextInt(1000) + 0;
            integers.add(Integer.valueOf(integer));
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}
