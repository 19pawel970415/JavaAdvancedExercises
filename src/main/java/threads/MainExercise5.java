package threads;

import java.util.Scanner;

public class MainExercise5 implements Runnable {


//5. Stwórz aplikację "timery". Wątek główny przyjmuje w linii liczbę. Liczba oznacza czas do
// wybudzenia. Po wpisaniu liczby (np. 50000) aplikacja ma startować nowy wątek, który ma
//się wybudzić za ten czas (np. za 50 s.) i wypisze komunikat: (To Twój timer 50 s. - wake up!)
//5B. Na komendę quit główny wątek ma opuścić pętle i poczekać na wszystkie rozpoczęte
//zadania (join()). Jeśli jakieś trwają to zatrzymaj wykonanie i wypisz ile wątków pracuje (zlicz
//tylko wątki isAlive()) a następnie poczekaj na ich zakończenie

    private static Integer countDown;
    private static boolean quitRequested = false;

    public static void main(String[] args) {

        MainExercise5 mainExercise5 = new MainExercise5();
        Thread thread = new Thread(mainExercise5);

        System.out.println("Set up your alarm clock, enter the number of seconds after which it should go off: ");
        Scanner scanner = new Scanner(System.in);
        countDown = 1000 * Integer.valueOf(scanner.nextLine());

        thread.start();

        while (true) {
            System.out.println("Enter 'quit' to stop the program or set up your alarm clock by entering the number of seconds: ");
            Scanner scanner1 = new Scanner(System.in);
            String input = scanner1.nextLine();

            if ("quit".equalsIgnoreCase(input)) {
                quitRequested = true;
                break;
            } else {
                countDown = 1000 * Integer.valueOf(input);
            }
        }

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program terminated. Number of active threads: " + Thread.activeCount());
    }

    @Override
    public void run() {
        try {
            while (!quitRequested) {
                Thread.sleep(countDown);
                System.out.println("To Twój timer " + (int) (countDown / 1000) + "s. - wake up!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}