package files.exercises.ex4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainExercise4 {

    public static void main(String[] args) {

        //Zadanie 4
        //Napisz program, który jest odpowiedzialny za zwrócenie najdłuższego słowa we
        //wskazanym pliku tekstowym.

        String theLongestWord = getTheLongestWord();
        System.out.println(theLongestWord);


    }

    public static String getTheLongestWord() {
        System.out.println("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        List<String> lines = new ArrayList<String>();

        if (file.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no such file!");
        }

        List<String> clearLines = new ArrayList<>();

        for (String line : lines) {
            String s = line.replaceAll("[^a-zA-Z0-9\\s]", "");
            clearLines.add(s);
        }


        Optional<String> max = clearLines.stream()
                .flatMap(l -> Arrays.stream(l.split("\\s")))
                .max(Comparator.comparingInt(w -> w.length()));

        if (max.isPresent()) {
            return max.get();
        } else {
            System.out.println("No words in the file");
            return null;
        }
    }
}

