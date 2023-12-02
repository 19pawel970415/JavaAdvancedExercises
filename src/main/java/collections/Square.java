package collections;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square extends Figure{

    private double a;

    @Override
    public double countArea() {
        return a * a;
    }
}
