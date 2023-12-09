package threads.exercises.ex2;

public class MainExercise2 {

    public static void main(String[] args) {

        //Zadanie 2
        //Napisz program, który ma za zadanie rozwiązać poniższy problem.
        //Na trasie pomiędzy miejscowościami A i B położony jest most, na którym
        //może znajdować się tylko i wyłącznie jeden samochód. Zaimplementuj
        //mechanizm, który umożliwi zsynchronizowany dostęp do obiektu klasy Bridge ,
        //obiektom klasy Car .
        //Klasa Car powinna zawierać poniższe informacje:
        //nazwa samochodu
        //typ samochodu
        //Klasa Bridge powinna zawierać metodę:
        //driveThrough, która przyjmie jako parametr obiekt klasy Car . Przejazd
        //powineń trwać 5s.

        Bridge bridge = new Bridge();
        Car car1 = new Car();
        Car car2 = new Car();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bridge.driveThrough(car1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bridge.driveThrough(car2);
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
