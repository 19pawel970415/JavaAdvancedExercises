package collections.exercises.ex2;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;
    private float price;
    private int releaseYear;
    private List<Author> authors;
    private Genre genre;

}
