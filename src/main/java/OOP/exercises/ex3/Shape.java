package OOP.exercises.ex3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Shape {

    private String colour;
    private boolean isFilled;

    public Shape() {
        this.colour = "Unknown";
        this.isFilled = false;
    }

    @Override
    public String toString() {
        return String.format("Shape with colour %s and %s", colour, isFilled ? "filled" : "not filled");
    }
}
