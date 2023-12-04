package exceptions.exercises.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book findBookByTitle(String name) {
        Optional<Book> anyBookOfSameTitle = books.stream()
                .filter(b -> b.getTitle().equals(name))
                .findAny();

        if (anyBookOfSameTitle.isPresent()) {
            return anyBookOfSameTitle.get();
        } else {
            throw new NoBookFoundException(name);
        }
    }

    public Book findBookByIsbn(String id) {
        Optional<Book> anyBookOfSameTitle = books.stream()
                .filter(b -> b.getIsbn().equals(id))
                .findAny();

        if (anyBookOfSameTitle.isPresent()) {
            return anyBookOfSameTitle.get();
        } else {
            throw new NoBookFoundException(id);
        }
    }

    public void removeBookByIsbn(String id) {
        Optional<Book> any = books.stream()
                .filter(b -> b.getIsbn().equals(id))
                .findAny();

        if (!any.isPresent()) {
            throw new NoBookFoundException(id);
        } else {
            books.remove(any.get());
        }
    }
}
