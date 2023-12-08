package files.exercises.ex3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainExercise3 {

    public static void main(String[] args) {

        //Zadanie 3
        //Napisz program, który doda do wskazanego pliku dowolny łańcuch tekstowy.

        System.out.println("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Enter the line you want to add to the file: ");
        String line = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(line);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
