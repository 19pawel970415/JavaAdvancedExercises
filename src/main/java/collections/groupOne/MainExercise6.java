package collections.groupOne;

import java.util.*;
import java.util.stream.Collectors;

public class MainExercise6 {

    public static void main(String[] args) {

        //1. Napisz program do tworzenia skorowidzu liter
        //2. Utwórz metode skorowidzLiterowy(String tekst):Map<String, Set<Integer>>
        //1. Metoda rozdziela zadany tekst na pojedyncze litery
        //2. Następnie iteruje od 0 do n pojedynczych liter
        //3. Aktualizuje indeksy wystąpień dla każdej litery
        //4. Zwraca mapę w postaci :
        //1. litera -> [indeksy wystąpień]
        //3. Wyświetla wynik w postaci :
        //1. [a -> [2, 3, 5], b- > [1,4]]
        //4. Np.
        //1. Dla tekstu „Hello”: [e-> [1], l -> [2, 3], o -> [4] , H->[0]]

        Map<String, Set<Integer>> helloExample = pinpointIndexesOfLetters("Hello");
        Map<String, Set<Integer>> stringSetMap = pinpointIndexesOfLetters("I do not like it in here");

        for (Map.Entry<String, Set<Integer>> entry : helloExample.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        System.out.println();

        for (Map.Entry<String, Set<Integer>> entry : stringSetMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    public static Map<String, Set<Integer>> pinpointIndexesOfLetters(String txt) {
        String s = txt.replaceAll("\\p{Punct}", "");
        String s1 = s.replaceAll("\\s", "");
        String[] letters = s1.split("");
        Set<String> distinctLetters = Arrays.stream(letters).distinct().collect(Collectors.toSet());
        Map<String, Set<Integer>> finalMap = new TreeMap<String, Set<Integer>>();

        for (String distinctLetter : distinctLetters) {
            finalMap.put(distinctLetter, new LinkedHashSet<>());
        }

        for (int i = 0; i < letters.length; i++) {
            if (finalMap.containsKey(letters[i])) {
                finalMap.get(letters[i]).add(i);
            }
        }

        return finalMap;
    }

}
