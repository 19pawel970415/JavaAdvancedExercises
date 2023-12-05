package classesInterfaces.ex2;

public class MainExercise2 {

    public static void main(String[] args) {

        //Klasa Movie
        //Zaimplementuj klasę Movie , która będzie zawierać pola reprezentujące
        //informacje takie jak: tytuł, reżyser, rok wydania, gatunek, wydawca. Klasa ta
        //powinna zawierać domyślny konstruktor oraz metody typu getter i setter ,
        //oraz nadpisaną metodę toString , która będzie odpowiedzialna za zwracanie
        //informacji o właściwościach konkretnego ¦lmu.
        //Klasa MovieCreator
        //Zaimplementuj klasę zagnieżdżoną statyczną MovieCreator . Klasa ta powinna:
        //zawierać pola klasy takie same jak klasa Movie
        //zawierać metody umoliżwiające ustawianie konkretnych właściwości ¦lmu.
        //Każda z metod powinna zwracać instancję obiektu, na rzecz którego
        //wywoływana jest metodametodę createMovie , która na podstawie ustawionych parametrów stworzy
        //instancję klasy Movie i zwróci ją w rezultacie działania metody


        Movie.MovieCreator movieCreator = new Movie.MovieCreator();
        Movie movie = movieCreator
                .setTitle("Inception")
                .setDirector("Christopher Nolan")
                .setReleaseYear(2010)
                .setGenre("Science Fiction")
                .setStudio("Warner Bros.")
                .createMovie();

        System.out.println(movie.toString());

        movie.setTitle("The Dark Knight");
        movie.setReleaseYear(2008);

        System.out.println(movie.toString());

    }

}
