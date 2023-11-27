package files.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainExercise4 {

    public static void main(String[] args) {

        //4. Napisz aplikację która czyta plik 'output_form.txt' i wypisuje zawartość formularzy.

        String filename = "output_form.txt";

        Path path = Paths.get(filename);

        boolean fileExists = Files.exists(path);

        if (fileExists) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
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

    }

}
