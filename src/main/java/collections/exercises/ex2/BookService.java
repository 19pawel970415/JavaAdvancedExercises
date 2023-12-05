package collections.exercises.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getFantasyBooks() {
        List<Book> fantasyBooks = books.stream()
                .filter(b -> b.getGenre().equals(Genre.FANTASY))
                .collect(Collectors.toList());

        return fantasyBooks;
    }

    public List<Book> getBooksBefore1999() {
        List<Book> toReturnBooks = books.stream()
                .filter(b -> b.getReleaseYear() < 1999)
                .collect(Collectors.toList());

        return toReturnBooks;
    }

    public Book getMostExpensiveBook() {
        Optional<Book> max = books.stream()
                .max(Comparator.comparingDouble(b -> b.getPrice()));

        if (max.isPresent()) {
            return max.get();
        } else {
            System.err.println("No books found!");
            return null;
        }
    }

    public Book getCheapestBook() {
        Optional<Book> min = books.stream()
                .min(Comparator.comparingDouble(b -> b.getPrice()));

        if (min.isPresent()) {
            return min.get();
        } else {
            System.err.println("No books found!");
            return null;
        }
    }


    public List<Book> getBooksWithAtLeast3Authors() {
        List<Book> toReturnBooks = books.stream()
                .filter(b -> b.getAuthors().size() >= 3)
                .collect(Collectors.toList());

        return toReturnBooks;
    }

    public List<Book> getSortedBooks(String ascDesc) {
        if (ascDesc.equalsIgnoreCase("ASC")) {
            return books.stream()
                    .sorted(Comparator.comparing(Book::getTitle))
                    .collect(Collectors.toList());
        } else if (ascDesc.equalsIgnoreCase("DESC")) {
            return books.stream()
                    .sorted(Comparator.comparing(Book::getTitle).reversed())
                    .collect(Collectors.toList());
        } else {
            System.err.println("Cannot sort, wrong input!");
            return null;
        }
    }

    public boolean isOnTheList(Book book) {
        return books.contains(book);
    }

    public List<Book> getBooksBy(String authorSurname) {
        return books.stream()
                .filter(b -> b.getAuthors().stream().anyMatch(a -> a.getSurname().equals(authorSurname)))
                .collect(Collectors.toList());
    }
}
