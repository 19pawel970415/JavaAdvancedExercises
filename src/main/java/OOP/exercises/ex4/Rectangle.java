package OOP.exercises.ex4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape {

    private double x;
    private double y;

    public Rectangle() {
        super();
        this.x = 1d;
        this.y = 1d;
    }

    public Rectangle(String colour, boolean isFilled, double x, double y) {
        super(colour, isFilled);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Rectangle with width = %f and length = %f which is a subclass off %s", x, y, super.toString());
    }

    @Override
    public float getArea() {
        return (float) (x * y);
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * x + 2 * y);
    }
}
