package OOP.exercises.ex3;

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

    public double getArea() {
        return x * y;
    }

    public double getPerimeter() {
        return 2 * x + 2 * y;
    }


    @Override
    public String toString() {
        return String.format("Rectangle with width = %f and length = %f which is a subclass off %s", x, y , super.toString());
    }
}
