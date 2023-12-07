package generics.exercises.ex1;

import java.util.ArrayList;
import java.util.List;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zadanie 1
        //Zaprojektuj klasę Pair , która w oparciu o typy generyczne będzie umożliwiała
        //przechowanie dowolnej pary obiektów.

        Pair<String, Integer> surnameAge = new Pair<String, Integer>("Crane", 25);
        Pair<String, Integer> surnameAge1 = new Pair<String, Integer>("Smith", 90);
        Pair<String, Integer> surnameAge2 = new Pair<String, Integer>("Shovel", 11);
        Pair<String, Integer> surnameAge3 = new Pair<String, Integer>("Freeman", 34);
        Pair<String, Integer> surnameAge4 = new Pair<String, Integer>("Statham", 21);
        Pair<String, Integer> surnameAge5 = new Pair<String, Integer>("Pole", 20);

        List<Pair> list = new ArrayList<>();
        list.add(surnameAge);
        list.add(surnameAge1);
        list.add(surnameAge2);
        list.add(surnameAge3);
        list.add(surnameAge4);
        list.add(surnameAge5);

        list.stream()
                .forEach(System.out::println);

    }


}
