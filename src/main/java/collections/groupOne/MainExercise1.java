package collections.groupOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainExercise1 {

    public static void main(String[] args) {

        //1. Utwórz listę kilku elementów typu String, a następnie prześledź:
        //1. Działanie metody add(E e)
        //2. Działanie metody set(E e, int index)
        //3. Działanie metody indexOf(Object o)
        //4. Działanie metody lastIndexOf(Object o)
        //5. Działanie metody remove(Object o)
        //6. Działanie metody remove(index int)
        //2. Utwórz metodę do wyświetlania zduplikowanych elementów w liście
        //3. Utwórz metodę do usuwania zduplikowanych elementów w liści

        String string = "String one";
        String string1 = "String two";
        String string2 = "String three";
        String string3 = "String four";
        String string4 = "String five";

        List<String> strings = new ArrayList<String>();

        strings.add(string);
        strings.add(string1);
        strings.add(string2);
        strings.add(string3);
        strings.add(string4);

        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println();

        strings.set(0, "Init string");

        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println();

        System.out.println(strings.indexOf("String two"));

        strings.set(4, "Init string");

        System.out.println();

        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println();

        System.out.println(strings.lastIndexOf("Init string"));

        System.out.println();

        strings.remove("String two");
        strings.remove(1);

        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println();

        printDuplicates(strings);

        System.out.println();

        List<String> strings1 = removeDuplicates(strings);
        for (String s : strings1) {
            System.out.println(s);
        }

    }

    public static void printDuplicates(List<String> strings) {
        Set<String> uniqueElements = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        for (String s : strings) {
            if (!uniqueElements.add(s)) {
                duplicates.add(s);
            }
        }

        for (String duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }

    public static List<String> removeDuplicates(List<String> strings) {
        Set<String> uniqueElements = new HashSet<>();
        List<String> listNoDuplicates = new ArrayList<>();

        for (String s : strings) {
            if (uniqueElements.add(s)) {
                listNoDuplicates.add(s);
            }
        }

        return listNoDuplicates;
    }
}
