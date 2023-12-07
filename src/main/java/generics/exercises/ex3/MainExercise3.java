package generics.exercises.ex3;

import java.util.Arrays;

public class MainExercise3 {

    public static void main(String[] args) {

        //Zadanie 3
        //Zaimplementuj generyczną metodę swap , która będzie odpowiedzialna za
        //zamianę pozycji wskazanych elementów tablicy.

        Integer[] integers = new Integer[]{-1, 1, -2, 2, -3, 3, 0};
        swap(integers, 0, 6);
        System.out.println(Arrays.toString(integers));
        swap(integers, 1, 2);
        System.out.println(Arrays.toString(integers));

    }

    public static <T> void swap(T[] elements, int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
