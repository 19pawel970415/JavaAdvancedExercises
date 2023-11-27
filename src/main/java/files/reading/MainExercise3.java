package files.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainExercise3 {

    public static void main(String[] args) {

        //3. Stwórz aplikację która czyta plik 'output_3.txt' i zlicza znaki i linie w tym pliku.

        String filename = "output_3.txt";

        Path path = Paths.get(filename);

        boolean fileExists = Files.exists(path);

        long linesCounter = 0;
        int signsCounter = 0;

        if (fileExists) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    signsCounter += length;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                linesCounter = reader.lines()
                        .count();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file");
        }

        System.out.println("The number of signs in the text: " + signsCounter);
        System.out.println("The number of lines in the text: " + linesCounter);
    }
}
