package threads;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MainExercise2 implements Runnable {

    private static String txt = "tekst";
    int counter = 1;

    public static void main(String[] args) {

        //2. Stwórz aplikację a w niej wątek który raz na 5 sekund wypisuje na ekran:
        //1. Hello World! - tekst
        //2. Hello World!! - tekst
        //3. Hello World!!! - tekst
        //Główny wątek powinien przyjmować tekst który ma występować po hello world. np. jeśli
        //wpisze:
        //"Michałki"
        //wątek powinien wypisywać:
        //...
        //4. Hello World!!!! - Michałki
        //...

        MainExercise2 main = new MainExercise2();
        Thread thread = new Thread(main);
        thread.start();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            setTxt(line);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(5000);
                System.out.print("Hello World");
                for (int i = 0; i < counter; i++) {
                    System.out.print("!");
                }
                System.out.println(" - " + txt);
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setTxt(String txt) {
        MainExercise2.txt = txt;
    }
}
