package files.exercises.ex2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainExercise2 {

    public static void main(String[] args) {

        //Zadanie 2
        //Napisz program, który odczyta i wyświetli cały dowolny plik linia po linii.

        System.out.println("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);

        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no such file!");
        }
    }

}
