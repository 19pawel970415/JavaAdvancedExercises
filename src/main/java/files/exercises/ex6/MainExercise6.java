package files.exercises.ex6;

import java.util.List;

public class MainExercise6 {

    public static void main(String[] args) {

        //Zadanie 6
        //Napisz program, który będzie realizować poniższe operacje na obiektach klasy
        //Movie :
        //dodawanie obiektów
        //wyświetlanie listy obiektów
        //Klasa Movie powinna zawierać pola: tytuł , gatunek , reżyser , rok wydania .
        //Dodawanie obiektów powinno przesyłać ich zserializowaną formę do pliku.
        //Wyświetlanie listy obiektów powinno umożliwiać deserializację pliku tekstowego
        //w celu konwersji poszczgólnych linii na obiekty


        Movie movie1 = new Movie("Inception", "Sci-Fi", "Christopher Nolan", "2010");
        Movie movie2 = new Movie("The Shawshank Redemption", "Drama", "Frank Darabont", "1994");
        Movie movie3 = new Movie("The Matrix", "Action", "Larry and Andy Wachowski", "1999");

        MovieRepo movieRepo = new MovieRepo();
        movieRepo.addMovie(movie1);
        movieRepo.addMovie(movie2);
        movieRepo.addMovie(movie3);

        List<Movie> moviesFromFile = movieRepo.getMoviesFromFile();

        for (Movie movie : moviesFromFile) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Director: " + movie.getDirectorsSurname());
            System.out.println("Release Year: " + movie.getReleaseYear());
            System.out.println();
        }

    }


    public static Movie parseFromCSV(String fileName) {
        String[] splitLine = fileName.split(",");
        return new Movie(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
    }

    public static String parseToCSV(Movie movie) {
        return new StringBuilder()
                .append(movie.getTitle()).append(",")
                .append(movie.getGenre()).append(",")
                .append(movie.getDirectorsSurname()).append(",")
                .append(movie.getReleaseYear()).append(",")
                .append("\n")
                .toString();
    }
}
