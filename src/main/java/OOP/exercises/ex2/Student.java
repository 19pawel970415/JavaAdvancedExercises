package OOP.exercises.ex2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student extends Person {

    private String degreeType;
    private String yearOfCourse;
    private float priceOfCourse;

    public Student(String degreeType, String yearOfCourse, float priceOfCourse) {
        this.degreeType = degreeType;
        this.yearOfCourse = yearOfCourse;
        this.priceOfCourse = priceOfCourse;
    }
}
