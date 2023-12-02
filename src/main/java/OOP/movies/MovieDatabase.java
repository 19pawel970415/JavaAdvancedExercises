package OOP.movies;

import java.util.HashMap;
import java.util.Map;

public class MovieDatabase {

    private Map<String, Movie> namesMovies = new HashMap<String, Movie>();

    public void addMovie(Movie m) {
        namesMovies.put(m.getName(), m);
    }

    public Movie getMovie(String name) {
        return namesMovies.get(name);
    }

    public void printAllMovies() {
        for (Movie m : namesMovies.values()) {
            System.out.println(m.toString());;
        }
    }

    public void printAllMovies(MovieType type) {
        for (Movie m : namesMovies.values()) {
            if (m.getType() == type) {
                System.out.println(m.toString());;
            }
        }
    }

}
