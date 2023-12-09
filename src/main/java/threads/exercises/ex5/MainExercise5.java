package threads.exercises.ex5;

public class MainExercise5 {

    public static void main(String[] args) {

        //Zadanie 5
        //Napisz strukturę danych, która umożliwi poruszanie się po tablicy w dwóch
        //kierunkach:
        //do przodu ( next() )
        //do tyłu ( prev() )
        //Struktura danych powinna przechowywać aktualnie przeszukiwany index. Zadbaj
        //o jego dodatkową synchronizację.


        Integer[] integerArray = {1, 2, 3, 4, 5};
        Iterator<Integer> integerIterator = new Iterator<>(integerArray);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + " - Next: " + integerIterator.next());
                        Thread.sleep(1000);
                    }
                } catch (IllegalArgumentException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + " - Prev: " + integerIterator.prev());
                        Thread.sleep(1000);
                    }
                } catch (IllegalArgumentException | InterruptedException e) {
                    e.printStackTrace();
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
    }

}
