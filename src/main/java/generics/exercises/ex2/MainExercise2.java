package generics.exercises.ex2;

public class MainExercise2 {


    public static void main(String[] args) {

        //Zadanie 2
        //Zaimplementuj generyczną metodę countIf , która na podstawie tablicy
        //dowolnego typu oraz wskazanej funkcji zliczy liczbę elementów spełniających
        //warunek. Funkcją może być dowolony interfejs zaimplementowany anonimowo.

        Integer[] integers = new Integer[]{-1, 1, -2, 2, -3, 3, 0};
        int i = countIf(integers, new Validator<Integer>() {
            @Override
            public boolean validate(Integer element) {
                if (element > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        System.out.println(i);
    }

    interface Validator<T> {
        boolean validate(T element);
    }

    public static <T> int countIf(T[] elements, Validator <T> validator) {
        int counter = 0;
        for (T element : elements) {
            if (validator.validate(element)) {
                counter++;
            }
        }
        return counter;
    }
}
