package generics.exercises.ex4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Newspaper {

    private String name;
    private int releasedFromYear;
    private String editorSurname;

}
