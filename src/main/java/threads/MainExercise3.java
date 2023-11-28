package threads;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

public class MainExercise3 implements Runnable {

    private static int sizeOfDirectory = 0;
    private static Optional<String> pathString = Optional.empty();
    private static boolean pathChanged = false;

    public static void main(String[] args) {
        MainExercise3 mainExercise3 = new MainExercise3();
        Thread thread = new Thread(mainExercise3);
        thread.start();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            pathString = Optional.ofNullable(line);
            pathChanged = true;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (pathString.isPresent()) {
                File folder = new File(pathString.get());
                File[] files = folder.listFiles();
                int temp = 0;
                if (files != null) {
                    if (!pathChanged) {
                        temp = files.length;
                        if (temp > sizeOfDirectory) {
                            System.out.println("A file was added");
                        } else if (temp < sizeOfDirectory) {
                            System.out.println("A file was deleted");
                        }
                        sizeOfDirectory = files.length;
                        pathChanged = false;
                    } else {
                        temp = files.length;
                        sizeOfDirectory = files.length;
                        pathChanged = false;
                    }
                }
            }
        }
    }
}