package OOP.exercises.ex6;

public class MainExercise6 {

    public static void main(String[] args) {

        //Zaimplementuj interfejs Movable , który będzie zawierać de¦nicję wspólnych
        //zachowań dla klas MovablePoint i MovableCircle . Będą to metody:
        //void moveUp()
        //void moveDown()
        //void moveLeft()
        //void moveRigth()
        //Klasa MovablePoint
        //Klasa MovablePoint powinna implementować interfejs Movable , a ponadto
        //powinna zawierać 4 pola typu int : x , y , xSpeed , ySpeed . Pola x , y powinny
        //de¦niować współrzędne punktu, natomiast pola xSpeed , ySpeed powinny
        //określać o ile powinny zmieniać się odpowiednie współrzędne.
        //metody moveUp() oraz moveDown() powinny każdorazowo
        //zwiększać/zmniejszać wartość współrzędnej y o wskazaną wartość:
        //ySpeed
        //metody moveLeft oraz moveRight() powinny każdorazowo
        //zwiększać/zmniejszać wartość współrzędnej x o wskazaną wartośćxSpeed
        //Klasa MovableCircle
        //Klasa MovableCircle powinna implementować interfejs Movable , a ponadto
        //powinna zawierać (na zasadzie kompozycji) instancję klasy MovablePoint .
        //Dodatkowo powinna zawierać pole niezbędne do określenia promienia koła.
        //metody moveUp() oraz moveDown() powinny każdorazowo
        //zwiększać/zmniejszać wartość współrzędnej y punktu MovablePoint o
        //wskazaną w nim wartość: ySpeed
        //metody moveLeft oraz moveRight() powinny każdorazowo
        //zwiększać/zmniejszać wartość współrzędnej x punktu MovablePoint o
        //wskazaną w nim wartość: xSpeed
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie. Dodatkowo
        //uwzględnij w przykładzie reprezentację polimor¦zmu

        MovablePoint point = new MovablePoint();
        point.setX(2);
        point.setY(3);
        point.setXSpeed(1);
        point.setYSpeed(1);

        System.out.println("Initial Point: " + point);
        point.moveUp();
        System.out.println("After moving up: " + point);
        point.moveLeft();
        System.out.println("After moving left: " + point);

        MovableCircle circle = new MovableCircle();
        circle.setMovablePoint(point);
        circle.setRadius(5);

        System.out.println("Initial Circle: " + circle);
        circle.moveDown();
        System.out.println("After moving down: " + circle);
        circle.moveRight();
        System.out.println("After moving right: " + circle);

        Movable[] movables = new Movable[2];
        movables[0] = point;
        movables[1] = circle;

        System.out.println("\nMoving all objects in the array:");
        for (Movable movable : movables) {
            movable.moveLeft();
            System.out.println(movable);
        }
    }
}
