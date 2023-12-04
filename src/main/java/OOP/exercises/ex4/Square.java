package OOP.exercises.ex4;

public class Square extends Rectangle {

    public Square(String colour, boolean isFilled, double x) {
        super(colour, isFilled, x, x);
    }

    @Override
    public void setX(double x) {
        super.setX(x);
        super.setY(x);
    }

    @Override
    public void setY(double y) {
        super.setX(y);
        super.setY(y);
    }

    @Override
    public String toString() {
        return String.format("Square with width = %f and length = %f which is a subclass off %s", super.getX(), super.getY() , super.toString());
    }
}
