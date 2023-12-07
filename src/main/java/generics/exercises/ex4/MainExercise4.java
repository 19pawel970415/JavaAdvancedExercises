package generics.exercises.ex4;

public class MainExercise4 {

    public static void main(String[] args) {

        //Zadanie 4
        //Zaprojektuj klasę, która będzie zachowywać się jak biblioteka dla następujących
        //rodzajów mediów:
        //książek
        //gazet
        //filmów
        //Zaproponuj rozwiązanie w oparciu o typy generyczne. W celu przechowywania
        //danych skorzystaj z tablic, bądź dowolnego API służącego do przechowywania
        //danych.

        Book book = new Book("The Great Gatsby", 1925, "Fitzgerald");
        Film film = new Film("Inception", 2010, "Nolan");
        Newspaper newspaper = new Newspaper("Daily News", 2000, "Smith");

        Repository<Book> bookRepository = new Repository<>();
        Repository<Film> filmRepository = new Repository<>();
        Repository<Newspaper> newspaperRepository = new Repository<>();

        bookRepository.addElement(book);
        filmRepository.addElement(film);
        newspaperRepository.addElement(newspaper);

        System.out.println("Books in the repository:");
        bookRepository.getElements().forEach(System.out::println);

        System.out.println("\nFilms in the repository:");
        filmRepository.getElements().forEach(System.out::println);

        System.out.println("\nNewspapers in the repository:");
        newspaperRepository.getElements().forEach(System.out::println);

        bookRepository.removeElement(book);

        System.out.println("\nBooks in the repository after removal:");
        bookRepository.getElements().forEach(System.out::println);

    }
}
