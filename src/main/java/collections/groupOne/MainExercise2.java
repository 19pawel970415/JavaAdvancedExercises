package collections.groupOne;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainExercise2 {

    public static void main(String[] args) {

        //1. Utwórz klasę abstrakcyjną Figura
        //2. Dodaj metodę abstrakcyjną obliczPole():double
        //3. Zaimplementuj interfejs Comparable tak aby sortować względem wielkości pola
        //4. Nadpisz metodę .toString() aby zwracać wielkość pola
        //5. Napisz klasy Kwadrat oraz Prostokąt dziedziczące po Figurze
        //6. Utwórz kilka obiektów typu Kwadrat i Prostokąt i umieść w Secie
        //przechowującym typ Figura
        //7. Wydrukuj wszystkie obiekty
        //8. Podmień implementację seta i zaobserwuj różnice
        //1. HashSet
        //2. LinkedHashSet
        //3. TreeSet

        Square square = new Square(5);
        Square square1 = new Square(6);
        Square square2 = new Square(7);
        Square square3 = new Square(8);
        Square square4 = new Square(9);

        Rectangle rectangle = new Rectangle(1,2);
        Rectangle rectangle1 = new Rectangle(3,4);
        Rectangle rectangle2 = new Rectangle(5,6);
        Rectangle rectangle3 = new Rectangle(7,8);
        Rectangle rectangle4 = new Rectangle(9,10);

        Set<Figure> figures = new HashSet<>();
        Set<Figure> figures1 = new TreeSet<>();
        Set<Figure> figures2 = new LinkedHashSet<>();

        figures.add(square);
        figures.add(square1);
        figures.add(square2);
        figures.add(square3);
        figures.add(square4);
        figures.add(rectangle);
        figures.add(rectangle1);
        figures.add(rectangle2);
        figures.add(rectangle3);
        figures.add(rectangle4);

        figures1.add(square);
        figures1.add(square1);
        figures1.add(square2);
        figures1.add(square3);
        figures1.add(square4);
        figures1.add(rectangle);
        figures1.add(rectangle1);
        figures1.add(rectangle2);
        figures1.add(rectangle3);
        figures1.add(rectangle4);

        figures2.add(square);
        figures2.add(square1);
        figures2.add(square2);
        figures2.add(square3);
        figures2.add(square4);
        figures2.add(rectangle);
        figures2.add(rectangle1);
        figures2.add(rectangle2);
        figures2.add(rectangle3);
        figures2.add(rectangle4);

        for (Figure figure : figures) {
            System.out.println(figure);
        }

        System.out.println();

        for (Figure figure : figures1) {
            System.out.println(figure);
        }

        System.out.println();

        for (Figure figure : figures2) {
            System.out.println(figure);
        }
    }

}
