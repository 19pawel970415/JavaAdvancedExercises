package OOP.exercises.ex4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Shape {

    protected String colour;
    protected boolean isFilled;

    public Shape() {
        this.colour = "Unknown";
        this.isFilled = false;
    }

    @Override
    public String toString() {
        return String.format("Shape with colour %s and %s", colour, isFilled ? "filled" : "not filled");
    }

    public abstract float getArea();

    public abstract float getPerimeter();
}
