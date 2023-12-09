package threads.exercises.ex3;

import java.util.Random;

public class MainExercise3 {

    public static void main(String[] args) {

        //Zadanie 3
        //Napisz program, który na dwóch osobnych wątkach będzie wykonywać dwa
        //niezależne algorytmy sortowania. Celem programu jest zwrócenie informacji o
        //algorytmie, który wykonał się szybciej. Sortowana tablica 10000 powinna być
        //tablicą losowo wygenerowanych liczb.

        Integer[] randomInts1 = new Integer[10000];
        Integer[] randomInts2 = new Integer[10000];
        for (int i = 0; i < randomInts1.length; i++) {
            Random random = new Random();
            int rand = random.nextInt();
            randomInts1[i] = rand;
            randomInts2[i] = rand;
        }

        long startTimeBubbleSort = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                BubbleSort bubbleSort = new BubbleSort(randomInts1);
                try {
                    String call = bubbleSort.call();
                    System.out.println(call);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeBubbleSort = System.currentTimeMillis();
        long elapsedTimeBubbleSort = endTimeBubbleSort - startTimeBubbleSort;

        long startTimeInsertionSort = System.currentTimeMillis();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                InsertionSort insertionSort = new InsertionSort(randomInts2);
                try {
                    String call = insertionSort.call();
                    System.out.println(call);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        thread2.start();

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTimeInsertionSort = System.currentTimeMillis();
        long elapsedTimeInsertionSort = endTimeInsertionSort - startTimeInsertionSort;

        if (elapsedTimeBubbleSort < elapsedTimeInsertionSort) {
            System.out.println("BubbleSort is faster!");
        } else if (elapsedTimeBubbleSort > elapsedTimeInsertionSort) {
            System.out.println("InsertionSort is faster!");
        } else {
            System.out.println("Equally fast");
        }
    }
}
