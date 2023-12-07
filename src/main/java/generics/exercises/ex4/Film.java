package generics.exercises.ex4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private String title;
    private int releaseYear;
    private String directorSurname;

}
