package OOP.exercises.ex4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape {

    private float radius;

    public Circle() {
        super();
        this.radius = 1f;
    }

    public Circle(String colour, boolean isFilled, float radius) {
        super(colour, isFilled);
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public float getPerimeter() {
        return (float) (2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return String.format("Circle with radius= %f which is a subclass off %s", radius, super.toString());
    }

}
