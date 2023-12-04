package OOP.exercises.ex1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point2d {

    private float x;
    private float y;

    public Point2d() {
        this.x = 0f;
        this.y = 0f;
    }

    public Point2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] result = new float[]{x,y};
        return result;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }
}
