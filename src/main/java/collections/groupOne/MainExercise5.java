package collections.groupOne;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainExercise5 {

    //Napisz program do zliczania wystąpień słów w tekście, w tym celu:
    //2. Dodaj metodę zliczWystapieniaSlow(String tekst):Map<String, Long>
    //1. Metoda pobiera tekst
    //2. Następnie rozdziela go na wystąpienia słów
    //3. Tworzy mapę ‚słowo’  ilość wystąpień
    //4. Iteruje po wszystkich słowach w zadanym tekscie
    //5. Dla każdego słowa wyciąga ilość zliczonych słów z mapy i dorzuca
    //kolejne wystąpienie
    //3. Program wyświetla wszystkie odkryte słowa wraz z ich liczebnością
    //4. * Program wyświetla wszystkie odkryte słowa wraz z ich liczebnością
    //w kolejności od najczęściej występującego do najrzadziej
    //występującego

    public static void main(String[] args) {

        String s = "I love cats. You love cats. He loves cats. She loves cats. It loves cats. We love cats. You love cats. They love cats.";
        Map<String, Long> stringLongMap = countWordsAndThierNumber(s);
        Map<String, Long> sortedMap = stringLongMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (e1, e2) -> e1,
                        () -> new LinkedHashMap<>()));

        System.out.println(sortedMap);
    }

    public static Map<String, Long> countWordsAndThierNumber(String txt) {
        String s = txt.replaceAll("\\p{Punct}", "");
        String[] split = s.split("\\s+");

        List<String> listOfWords = Arrays.asList(split);

        Map<String, Long> finalMap = listOfWords.stream()
                .collect(Collectors.groupingBy(word -> word.toString(), Collectors.counting()));

        return finalMap;
    }
}
