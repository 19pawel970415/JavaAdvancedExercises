package collections.exercises.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MainExercise3 {

    public static void main(String[] args) {

        //Zadanie 3
        //Na podstawie 100 elementowej tablicy z losowo wybranymi wartościami z
        //przedziału 0-50 zaimplementuj następujące funkcjonalności:
        //zwróć listę unikalnych elementów
        //zwróć listę elementów, które conajmniej raz powtórzyły się w
        //wygenerowanej tablicy

        Integer[] integers = new Integer[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int integer = random.nextInt(50);
            integers[i] = integer;
        }
        getDistinctValues(integers).stream()
                .forEach(i -> System.out.print(i + " "));

        System.out.println();

        getNotDistinctValues(integers).stream()
                .forEach(i -> System.out.print(i + " "));
    }

    private static List<Integer> getDistinctValues(Integer[] integers) {
        List<Integer> distinctValues = Arrays.stream(integers)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return distinctValues;
    }

    private static List<Integer> getNotDistinctValues(Integer[] integers) {
        List<Integer> notDistinctValues = Arrays.stream(integers)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return notDistinctValues;
    }

}
