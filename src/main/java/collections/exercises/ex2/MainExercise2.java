package collections.exercises.ex2;

import files.writing.Gender;

import java.util.Arrays;
import java.util.List;

public class MainExercise2 {

    public static void main(String[] args) {

        //Zadanie 2
        //Klasa Author
        //Zaimplementuj klasę Author , która będzie zawierać pola: imię, nazwisko, płeć.
        //Uwzględnij wszystkie niezbędne meotody oraz parametry konstruktora.
        //Zaimplementuj klasę hashCode i equals .
        //Klasa Book
        //Zaimplementuj klasę Book , która będzie zawierać pola: tytuł, cena, rok wydania
        //oraz lista autorów, gatunek (reprezentowany jako klasa enum). Uwzględnij
        //wszystkie niezbędne metody oraz parametry konstruktora. Zaimplementuj klasę
        //hashCode i equals .
        //Klasa BookService
        //Zaimplementuj klasę BookService , która będzie zawierać w sobie listę książek,
        //oraz będzie realizować poniższe metody:
        //dodawanie książek do listyusuwanie książek z listy
        //zwracanie listy wszystkich książek
        //zwracanie książek typu Fantasy
        //zwracanie książek wydanych przed rokiem 1999
        //zwracanie najdroższej książki
        //zwracanie najtańszej książki
        //zwracanie książki z conajmniej 3 autorów
        //zwracanie listy wszystkich książek posortowanych zgodnie z przekazanym
        //parametrem: rosnąco/malejąco
        //sprawdzanie czy konkretna książka znajduje się na liście
        //zwracanie listy książek napisanych przez konkretnego autora

        Author author1 = new Author("John", "Doe", Gender.MALE);
        Author author2 = new Author("Jane", "Smith", Gender.FEMALE);
        Author author3 = new Author("Bob", "Johnson", Gender.MALE);

        Genre fantasyGenre = Genre.FANTASY;
        Genre mysteryGenre = Genre.MYSTERY;

        Book book1 = new Book("The Fantasy Book", 29.99f, 2020, Arrays.asList(author1, author2, author3), fantasyGenre);
        Book book2 = new Book("Mysterious Secrets", 19.99f, 1995, Arrays.asList(author3), mysteryGenre);
        Book book3 = new Book("Enchanted Forest", 39.99f, 2015, Arrays.asList(author2), fantasyGenre);
        Book book4 = new Book("Lost in the Shadows", 14.99f, 2002, Arrays.asList(author1, author3), mysteryGenre);

        BookService bookService = new BookService();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);

        List<Book> allBooks = bookService.getBooks();
        System.out.println("All Books:");
        allBooks.forEach(System.out::println);

        List<Book> fantasyBooks = bookService.getFantasyBooks();
        System.out.println("\nFantasy Books:");
        fantasyBooks.forEach(System.out::println);

        List<Book> booksBefore1999 = bookService.getBooksBefore1999();
        System.out.println("\nBooks before 1999:");
        booksBefore1999.forEach(System.out::println);

        Book mostExpensiveBook = bookService.getMostExpensiveBook();
        System.out.println("\nMost Expensive Book:");
        System.out.println(mostExpensiveBook);

        Book cheapestBook = bookService.getCheapestBook();
        System.out.println("\nCheapest Book:");
        System.out.println(cheapestBook);

        List<Book> booksWithAtLeast3Authors = bookService.getBooksWithAtLeast3Authors();
        System.out.println("\nBooks with at least 3 authors:");
        booksWithAtLeast3Authors.forEach(System.out::println);

        List<Book> sortedBooksAsc = bookService.getSortedBooks("ASC");
        System.out.println("\nSorted Books (Asc):");
        sortedBooksAsc.forEach(System.out::println);

        List<Book> sortedBooksDesc = bookService.getSortedBooks("DESC");
        System.out.println("\nSorted Books (Desc):");
        sortedBooksDesc.forEach(System.out::println);

        boolean isOnTheList = bookService.isOnTheList(book1);
        System.out.println("\nIs the book on the list? " + (isOnTheList ? "Yes" : "No"));

        List<Book> booksByAuthor = bookService.getBooksBy("Doe");
        System.out.println("\nBooks by John Doe:");
        booksByAuthor.forEach(System.out::println);
    }

}
