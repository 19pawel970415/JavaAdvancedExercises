package files.exercises.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    private String title;
    private String genre;
    private String directorsSurname;
    private String releaseYear;

}
