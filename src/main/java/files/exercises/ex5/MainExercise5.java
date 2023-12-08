package files.exercises.ex5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainExercise5 {

    public static void main(String[] args) {

        //Zadanie 5
        //Napisz program, który będzie realizować funkcjonalność parsera CSV.
        //Z wykorzystaniem pliku flie.csv jego odczytanie powinno skutkować
        //zwróceniem listy trzyelementowej obiektów typu User o polach: imię, nazwisko,
        //wiek.

        List<User> users = new ArrayList<User>();
        String fileName = "file.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseUser(line);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.stream()
                .forEach(System.out::println);

    }

    public static User parseUser(String line) {
        String[] splitLine = line.split(",");
        return new User(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]));
    }

}
