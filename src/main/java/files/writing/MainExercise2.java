package files.writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainExercise2 {

    public static void main(String[] args) {

        //2 Napisz aplikację w której:
        //- wczytaj od użytkownika jedną linię tekstu
        //- po wczytaniu linii otwórz plik o nazwie 'output_2.txt'
        //- zapisz do pliku linię pobraną od użytkownika
        //- zamknij plik

        System.out.println("Enter the line you want to save to the file: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String fileName = "output_2.txt";

        File file = new File(fileName);
        {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(line);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
