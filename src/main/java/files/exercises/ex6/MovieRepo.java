package files.exercises.ex6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static files.exercises.ex6.MainExercise6.parseFromCSV;
import static files.exercises.ex6.MainExercise6.parseToCSV;

public class MovieRepo {

    public void addMovie(Movie movie) {
        String fileName = "movies.txt";
        File file = new File(fileName);

        {
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                fileWriter.write(parseToCSV(movie));
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Movie> getMoviesFromFile() {
        String fileName = "movies.txt";
        File file = new File(fileName);
        List<Movie> movies = new ArrayList<Movie>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                movies.add(parseFromCSV(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
