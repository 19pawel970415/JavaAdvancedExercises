package OOP.exercises.ex7;

public class ResizableCircle extends Circle implements Resizable{

    public ResizableCircle() {
    }

    public ResizableCircle(float radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        radius = radius - (percent / 100f) * radius;
    }

    @Override
    public String toString() {
        return "ResizableCircle{" +
                "radius=" + radius +
                '}';
    }
}
