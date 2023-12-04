package OOP.exercises.ex6;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class MovablePoint implements Movable{

    private int x , y , xSpeed , ySpeed;

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x += xSpeed;
    }

    @Override
    public void moveRight() {
        x -= xSpeed;
    }
}
