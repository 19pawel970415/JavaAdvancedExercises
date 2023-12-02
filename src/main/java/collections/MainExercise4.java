package collections;

import java.util.*;

public class MainExercise4 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new TreeMap<>();
        Map<String, Integer> map2 = new LinkedHashMap<>();

        map.put("Paul", 25);
        map.put("Anna", 20);
        map.put("Nina", 19);
        map.put("Angelina", 40);
        map.put("Tom", 33);

        map1.put("Paul", 25);
        map1.put("Anna", 20);
        map1.put("Nina", 19);
        map1.put("Angelina", 40);
        map1.put("Tom", 33);

        map2.put("Paul", 25);
        map2.put("Anna", 20);
        map2.put("Nina", 19);
        map2.put("Angelina", 40);
        map2.put("Tom", 33);

        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);

//        map.put("Tom",20);

        for (String string : map.keySet()) {
            System.out.println(string);
        }

        System.out.println();

        for (String string : map1.keySet()) {
            System.out.println(string);
        }

        System.out.println();

        for (String string : map2.keySet()) {
            System.out.println(string);
        }


        //1. Utwórz klasę Main a w niej metodę psvm
        //2. Utwórz hashmapę gdzie kluczem będzie String – imię a wartościa int – wiek
        //3. Dodaj do mapy kilka wystąpień
        //4. Wyświetl mapę (sout)
        //5. Spróbuj dodać do mapy obecny już klucz z inna wartością – co się stanie?
        //6. Przeiteruj mapę za pomocą pętli for (.keySet())
        //7. Sprawdź zachowanie dla innych implementacji mapy:
        //1. LinkedHashMap
        //2. TreeMap

    }

}
