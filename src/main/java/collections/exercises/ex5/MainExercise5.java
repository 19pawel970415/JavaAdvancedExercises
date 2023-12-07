package collections.exercises.ex5;

import collections.exercises.ex2.Author;
import collections.exercises.ex2.Book;
import collections.exercises.ex2.BookService;
import collections.exercises.ex2.Genre;
import files.writing.Gender;

import java.util.*;
import java.util.stream.Collectors;

public class MainExercise5 {

    public static void main(String[] args) {

        //Zadanie 5
        //Na podstawie zadania nr 2 zaimplementuj metodę, która będzie odpowiedzialna
        //stworzenie stosu książek posortowanych od ceny najwyższej do najniższej.

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

        Stack<List<Book>> stackOfBooks = getStackOfBooks(bookService.getBooks());
        System.out.println(stackOfBooks);

    }

    public static Stack<List<Book>> getStackOfBooks(List<Book> books) {
        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .collect(Collectors.toList());
        Stack<List<Book>> stack = new Stack<>();
        stack.push(sortedBooks);
        return stack;
    }
}
