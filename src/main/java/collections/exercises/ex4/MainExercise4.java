package collections.exercises.ex4;

import collections.exercises.ex2.Author;
import collections.exercises.ex2.Book;
import collections.exercises.ex2.BookService;
import collections.exercises.ex2.Genre;
import files.writing.Gender;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainExercise4 {

    public static void main(String[] args) {

        //Zadanie 4
        //Na podstawie zadania nr 2 zaimplementuj metodę, która będzie odpowiedzialna
        //za zwracanie unikalnych par: klucz, wartość. Kluczem powinien być gatunek
        //książki, a wartością jej tytuł.

        Author author1 = new Author("John", "Doe", Gender.MALE);
        Author author2 = new Author("Jane", "Smith", Gender.FEMALE);
        Author author3 = new Author("Bob", "Johnson", Gender.MALE);

        Genre fantasyGenre = Genre.FANTASY;
        Genre mysteryGenre = Genre.MYSTERY;
        Genre biographyGenre = Genre.BIOGRAPHY;
        Genre foodAndDrinkGenre = Genre.FOOD_AND_DRINK;

        Book book1 = new Book("The Fantasy Book", 29.99f, 2020, Arrays.asList(author1, author2, author3), fantasyGenre);
        Book book2 = new Book("Mysterious Secrets", 19.99f, 1995, Arrays.asList(author3), mysteryGenre);
        Book book3 = new Book("Enchanted Forest", 39.99f, 2015, Arrays.asList(author2), foodAndDrinkGenre);
        Book book4 = new Book("Lost in the Shadows", 14.99f, 2002, Arrays.asList(author1, author3), biographyGenre);

        BookService bookService = new BookService();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);

        Map<Genre, String> mapOfBooks = getMapOfBooks(bookService.getBooks());

        for (Map.Entry<Genre, String> genreStringEntry : mapOfBooks.entrySet()) {
            System.out.println(genreStringEntry);
        }


    }

    public static Map<Genre, String> getMapOfBooks(List<Book> books) {
        return books.stream()
                .collect(Collectors.toMap(b -> b.getGenre(), b -> b.getTitle()));
    }
}
