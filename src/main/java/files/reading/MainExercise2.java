package files.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class MainExercise2 {

    public static void main(String[] args) {
        //2. Stwórz aplikację która odczyta plik 'output_2.txt' i wczyta z niego linię, a następnie
        //wypisze ją na ekran: 1 raz "toUpperCase", 1 raz "toLowerCase", 1 raz "trim".


        String filename = "output_2.txt";

        Path path = Paths.get(filename);

        boolean fileExists = Files.exists(path);

        if (fileExists) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line.toUpperCase(Locale.ROOT));
                    System.out.println(line.toLowerCase(Locale.ROOT));
                    System.out.println(line.trim());
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
