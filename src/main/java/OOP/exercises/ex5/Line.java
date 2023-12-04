package OOP.exercises.ex5;

import OOP.exercises.ex1.Point2d;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Line {

    private Point2d point2d1;
    private Point2d point2d2;

    public Line(Point2d point2d1, Point2d point2d2) {
        this.point2d1 = point2d1;
        this.point2d2 = point2d2;
    }

    public Line(float x, float y, float z, float a) {
        point2d1 = new Point2d(x, y);
        point2d2 = new Point2d(z, a);
    }

    public float getLength() {
        if (point2d1.getX() == point2d2.getX()) {
            return Math.abs(point2d1.getY() - point2d2.getY());
        } else if (point2d1.getY() == point2d2.getY()) {
            return Math.abs(point2d1.getX() - point2d2.getX());
        } else {
            return (float) Math.sqrt((Math.pow(point2d1.getX() - point2d2.getX(), 2)) + (Math.pow(point2d1.getY() - point2d2.getY(), 2)));
        }
    }

    public Point2d getTheMidpoint() {
        float midX = (point2d1.getX() + point2d2.getX()) / 2;
        float midY = (point2d1.getY() + point2d2.getY()) / 2;

        return new Point2d(midX, midY);
    }
}
