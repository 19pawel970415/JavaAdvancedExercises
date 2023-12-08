package files.exercises.ex1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zadanie 1
        //Napisz program, który wyświetli wszystkie pliki/katalogi zawarte w danym
        //katalogu.

        //Show current dir for project:
        //String property = System.getProperty("user.dir");
        //System.out.println(property);


        System.out.println("Enter the path to the directory: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        File dir = new File(line);
        String[] list = dir.list();
        Arrays.stream(list).forEach(System.out::println);

    }

}
