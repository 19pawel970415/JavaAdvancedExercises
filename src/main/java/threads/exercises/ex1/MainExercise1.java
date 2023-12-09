package threads.exercises.ex1;

import java.util.ArrayList;
import java.util.List;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zadanie 1
        //Napisz program, który równolegle znajdzie liczby parzyste w dwóch
        //przedziałach: 1000-2000 oraz 14300-17800 .

        List<Integer> even1 = new ArrayList<Integer>();
        List<Integer> even2 = new ArrayList<Integer>();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 2001; i++) {
                    if (i % 2 == 0) {
                        even1.add(i);
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 14300; i < 17801; i++) {
                    if (i % 2 == 0) {
                        even2.add(i);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        even1.stream()
                .forEach(System.out::println);

        even2.stream()
                .forEach(System.out::println);

    }

}
