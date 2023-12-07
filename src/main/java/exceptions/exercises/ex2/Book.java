package exceptions.exercises.ex2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {

    private String isbn;
    private String title;
    private String author;
    private String releaseYear;
}
