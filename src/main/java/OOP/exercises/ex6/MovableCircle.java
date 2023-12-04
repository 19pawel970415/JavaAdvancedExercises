package OOP.exercises.ex6;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class MovableCircle implements Movable{

    private MovablePoint movablePoint;
    private float radius;

    @Override
    public void moveUp() {
        movablePoint.moveUp();
    }

    @Override
    public void moveDown() {
        movablePoint.moveDown();
    }

    @Override
    public void moveLeft() {
        movablePoint.moveLeft();
    }

    @Override
    public void moveRight() {
        movablePoint.moveRight();
    }


}
