package collections;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle extends Figure{
    private double a;
    private double b;

    @Override
    public double countArea() {
        return a * b;
    }
}
