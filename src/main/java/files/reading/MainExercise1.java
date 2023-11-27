package files.reading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainExercise1 {

    public static void main(String[] args) {
        //1. Stwórz aplikację która służy do odczytywania danych z plików które zapisaliśmy, stwórz
        //main'a w którym sprawdzaj że w katalogu w którym uruchomiłeś program jest plik o nazwie
        //'output_1.txt' który posiada treść "Hello World!". Jeśli pliku nie ma lub posiada inną
        //zawartość napisz odpowiedni komunikat.

        String filename = "output_1.txt";

        Path path = Paths.get(filename);

        boolean fileExists = Files.exists(path);

        if (fileExists) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.equals("Hello World!")) {
                        System.out.println("The content of the file is different from expected: " + line);
                    } else {
                        System.out.println("The content of the file is as expected: " + line);
                    }
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
