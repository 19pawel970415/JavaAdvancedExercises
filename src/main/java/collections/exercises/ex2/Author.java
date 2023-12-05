package collections.exercises.ex2;

import files.writing.Gender;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String name;
    private String surname;
    private Gender gender;

}
