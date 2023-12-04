package OOP.exercises.ex1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Point3d extends Point2d {

    private float z;

    public Point3d(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = new float[]{super.getX(), super.getY(), z};
        return result;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", super.getX(), super.getY(), z);
    }
}
