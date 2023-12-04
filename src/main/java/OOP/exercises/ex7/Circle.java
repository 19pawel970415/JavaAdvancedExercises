package OOP.exercises.ex7;

public class Circle implements GeometricObject {
    protected float radius;

    public Circle() {
        this.radius = 1f;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
