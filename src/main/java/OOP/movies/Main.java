package OOP.movies;

import java.time.LocalDate;

public class Main {

    //1.
    //Movies database:
    //Stwórz enum MovieType który posiada opcje:
    //ACTION, DRAMA, COMEDY, HORROR
    //Stwórz model filmu, który : (klasa Movie)
    //- posiada pole nazwa filmu - String
    //- posiada pole typ filmu (enum)
    //- posiada pole data wydania filmu - data
    //- posiada pole nazwisko autora - String
    //1. Stwórz klasę MoviesDatabase która posiada:
    //- jako pole posiada mapę filmów. Mapa powinna mapować z wartości typu String
    //(będzie to nazwa filmu) na model (na obiekty klasy Movie)
    //- stwórz metodę dodawania do bazy danych filmów ( addMovie(Movie m)) która
    //dodaje do mapy film
    //- stwórz metodę wyszukiwania filmów z bazy danych, która przyjmuje jako parametr
    //nazwę filmu, a zwraca film który jest w bazie danych pod tą nazwą.
    //- stwórz metodę wypisywania wszystkich filmów. Metoda powinna iterować po
    //wartościach mapy i wypisywać informacje o filmie (nadpisz metodę toString w klasie ...[wiesz
    //jakiej?]). metoda printAllMovies().
    //- stwórz metodę o tej samej nazwie co powyższa, która przyjmuje jako parametr typ
    //filmu (MovieType) i również iteruje wartości, jedak wypisuje tylko te filmy których MovieType
    //odpowiada temu podanemu jako parametr.
    //2. Stwórz maina w którym będziesz testować tą funkcjonalność
    //dodawania/wyszuk
    //3. Dodaj kilka interface swojego autorstwa

    public static void main(String[] args) {
        Movie movie = new Movie("Good Will Hunting", MovieType.DRAMA, LocalDate.of(1997, 12, 02), "Gus Van Sant");
        Movie movie1 = new Movie("Beverly Hills Cop", MovieType.COMEDY, LocalDate.of(1984, 12, 5), "Martin Brest");
        Movie movie2 = new Movie("The Conjuring", MovieType.HORROR, LocalDate.of(2013, 7, 26), "James Wan");
        Movie movie3 = new Movie("The Expendables", MovieType.ACTION, LocalDate.of(2010, 8, 20), "Sylvester Stallone");

        movie.react();
        movie1.react();
        movie2.react();
        movie3.react();

        System.out.println();

        MovieDatabase movieDatabase = new MovieDatabase();

        movieDatabase.addMovie(movie);
        movieDatabase.addMovie(movie1);
        movieDatabase.addMovie(movie2);
        movieDatabase.addMovie(movie3);

        Movie good_will_hunting = movieDatabase.getMovie("Good Will Hunting");
        Movie beverly_hills_cop = movieDatabase.getMovie("Beverly Hills Cop");
        Movie the_conjuring = movieDatabase.getMovie("The Conjuring");
        Movie the_expendables = movieDatabase.getMovie("The Expendables");

        System.out.println(good_will_hunting.toString());
        System.out.println(beverly_hills_cop.toString());
        System.out.println(the_conjuring.toString());
        System.out.println(the_expendables.toString());

        System.out.println();

        movieDatabase.printAllMovies();

        System.out.println();

        movieDatabase.printAllMovies(MovieType.DRAMA);
    }

}
