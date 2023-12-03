package collections.groupTwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student6 {

    private String name;
    private String surname;
    private List<Double> marks;
    private String StudentsCardNumber;

}
