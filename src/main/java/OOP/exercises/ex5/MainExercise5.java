package OOP.exercises.ex5;

import OOP.exercises.ex1.Point2d;

public class MainExercise5 {

    public static void main(String[] args) {

        //Zadanie 5
        // Zaimplementuj klasę Line , która będzie zawierać (na zasadzie kompozycji)
        //instancję dwóch obiektów Point2D z zadania nr 1. Punkty te będą punktem
        //początkowym oraz końcowym odcinka. Ponadto klasa ta powinna
        //implementować:
        //konstruktor przyjmujący dwa punkty: początkowy i końcowykonstruktor przyjmujący 4 parametry: współrzędne punktu początkowego
        //oraz końcowego
        //metody typu getter odpowiedzialne za zwracanie punktów: początkowego
        //i końcowego
        //metody typu setter odpowiedzialne za ustalanie punktów: początkowego i
        //końcowego
        //metodę odpowiedzialną za obliczanie długości linii na podstawie
        //ustawionych punktów
        //metodę odpowiedzialną za zwracanie współrzędnych punktu będącego
        //środkiem stworzonej prostej
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie

        Point2d point1 = new Point2d(1, 2);
        Point2d point2 = new Point2d(4, 6);
        Line line1 = new Line(point1, point2);

        System.out.println("Length of line1: " + line1.getLength());

        Point2d midpoint1 = line1.getTheMidpoint();
        System.out.println("Midpoint of line1: " + midpoint1);

        Line line2 = new Line(2, 3, 5, 8);

        System.out.println("Length of line2: " + line2.getLength());

        Point2d midpoint2 = line2.getTheMidpoint();
        System.out.println("Midpoint of line2: " + midpoint2);

    }

}
