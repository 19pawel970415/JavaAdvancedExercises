package files.writing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainExercise4 {

    public static void main(String[] args) {

//4.    Napisz program, a w tym programie wczytaj jedną linię ze skanera od użytkownika.
////    Poproś użytkownika o 'adres pliku'. Po wpisaniu zweryfikuj czy wybrany plik/katalog istnieje,
////    czy jest plikiem/katalogiem, jaki jest jego: rozmiar, czas ostatniej modyfikacji i czy mamy
////    prawa do odczytu/zapisu do tego pliku/katalogu.

        System.out.println("Enter the path of the file: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Path path = Paths.get(line);

        boolean fileDirExists = Files.exists(path);
        if (fileDirExists) {

            System.out.println("File exists");
            boolean isFile = Files.isRegularFile(path);
            if (isFile) {
                System.out.println("It's a file");
            }
            boolean isDir = Files.isDirectory(path);
            if (isDir) {
                System.out.println("It's a directory");
            }
            long size;
            FileTime lastModifiedTime;
            boolean readable = Files.isReadable(path);
            if (readable) {
                System.out.println("It can be read");
            }
            boolean writable = Files.isWritable(path);
            if (writable) {
                System.out.println("It can be written to");
            }

            try {
                size = Files.size(path);
                System.out.println("It's size is: " + size);
                lastModifiedTime = Files.getLastModifiedTime(path);
                System.out.println(":Last time it was modified: " + lastModifiedTime);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("The file/dir doesn't exist");
        }
    }
}
