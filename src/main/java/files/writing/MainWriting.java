package files.writing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWriting {
    public static void main(String[] args) {
        String fileName = "file.txt";

        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file,true)) {
            writer.write("Line of txt \n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
