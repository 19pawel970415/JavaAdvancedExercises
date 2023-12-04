package OOP.exercises.ex2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Lecturer extends Person {

    private String field;
    private float salary;

    public Lecturer(String field, float salary) {
        this.field = field;
        this.salary = salary;
    }
}
