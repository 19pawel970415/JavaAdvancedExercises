package files.writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class MainExercise3 {

    public static void main(String[] args) {

        //3.  Należy napisać aplikację która w pętli while czyta ze Scannera wejście użytkownika z
        //    konsoli, a następnie linia po linii wypisuje tekst do pliku 'output_3.txt'. Aplikacja ma się
        //    zamykać po wpisaniu przez użytkownika komendy "quit".
        //    Pętla powinna być w try a nie try w pętli.

        System.out.println("Enter the lines you want to save to the file. To end enter: quit.");

        String fileName = "output_3.txt";

        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file, true)) {
            while (true) {

                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                writer.write(line + "\n");
                writer.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
