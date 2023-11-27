package files.writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainExercise1 {

    public static void main(String[] args) {

        // 1. Napisz aplikację która otwiera plik 'output_1.txt', zapisuje do niego "Hello World!" a następnie zamyka plik.

        String fileName = "output_1.txt";

        File file = new File(fileName);
        {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("Hello World!");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
