package files.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainExercise5 {

    public static void main(String[] args) {

        //5. Napisz aplikację która czyta plik 'output_form.txt' i wypisuje ilość wypełnionych formularzy.

        String filename = "output_form.txt";

        Path path = Paths.get(filename);

        boolean fileExists = Files.exists(path);

        int numOfForms = 0;

        if (fileExists) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Student (enter YES or NO):")) {
                        numOfForms++;
                    }
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file");
        }

        System.out.println();
        System.out.println("The number of filled in forms is: " + numOfForms);

    }

}
