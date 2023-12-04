package OOP.exercises.ex4;

import OOP.exercises.ex3.Circle;
import OOP.exercises.ex3.Rectangle;
import OOP.exercises.ex3.Shape;
import OOP.exercises.ex3.Square;

public class MainExercise4 {

    public static void main(String[] args) {

        // Zadanie4
        // Zmody¦kuj implementację przygotowaną w ramach Zadania nr 3. W tym celu
        //dokonaj następującej refaktoryzacji:
        //zmody¦kuj klasę Shape tak by była to klasa abstrakcyjna
        //pola klasy Shape powinny być oznaczone mody¦katorem dostępu typu
        //protected
        //klasa Shape powinna zawierać metody abstrakcyjne getArea i
        //getPerimeter
        //Wszystkie klasy dziedziczące bezpośrednio lub pośrednio po klasie Shape
        //powinny nadpisywać metody abstrakcyjne z klasy nadrzędnej.
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie


        OOP.exercises.ex3.Shape shape = new Shape("Red", true);
        System.out.println("Shape:");
        System.out.println("Colour: " + shape.getColour());
        System.out.println("Is Filled: " + shape.isFilled());
        System.out.println("toString(): " + shape.toString());
        System.out.println();

        OOP.exercises.ex3.Circle circle = new Circle("Blue", false, 5.0f);
        System.out.println("Circle:");
        System.out.println("Colour: " + circle.getColour());
        System.out.println("Is Filled: " + circle.isFilled());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("toString(): " + circle.toString());
        System.out.println();

        OOP.exercises.ex3.Rectangle rectangle = new Rectangle("Green", true, 4.0, 6.0);
        System.out.println("Rectangle:");
        System.out.println("Colour: " + rectangle.getColour());
        System.out.println("Is Filled: " + rectangle.isFilled());
        System.out.println("Width: " + rectangle.getX());
        System.out.println("Length: " + rectangle.getY());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println("toString(): " + rectangle.toString());
        System.out.println();

        OOP.exercises.ex3.Square square = new Square("Yellow", false, 3.0);
        System.out.println("Square:");
        System.out.println("Colour: " + square.getColour());
        System.out.println("Is Filled: " + square.isFilled());
        System.out.println("Width/Length: " + square.getX());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("toString(): " + square.toString());
    }

}
