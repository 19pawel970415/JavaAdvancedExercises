package OOP.exercises.ex1;

import java.util.Arrays;

public class MainExercise1 {

    public static void main(String[] args) {
        //Zadanie 1
        //Klasa Point2D
        //Zaimplementuj klasę Point2D . Klasa powinna zawierać:
        //dwa pola typu §oat: x , y
        //konstruktor bezparametrowy ustawiający wartość pól x i y na 0
        //konstruktor z dwoma parametrami: float x , float y
        //metody typu getter odpowiedzialne za zwracanie wartości zmiennej: x , y
        //metodę getXY zwracającą współrzędne x i y w postaci tablicy
        //dwuelementowej
        //metody typu setter odpowiedzialne za ustawianie wartości pól x , y
        //metodę setXY ustawiającą współrzędne x i y
        //metoda toString powinna zwracać łańcuch tekstowy o następującym
        //formacie: (x, y)
        //Klasa Point3D
        //Na podstawie klasy Point2D zaimplementuj klasę Point3D. Klasa ta powinna
        //rozszerzać klasę Point2D oraz dodawać następującą implementację:
        //pole prywatne typu §oat: z
        //konstruktor przyjmujący wartości dla pól: x , y , z
        //metodę typu getter odpowiedzialną za zwracanie wartości zmiennej z
        //metodę getXYZ zwracającą współrzędne x , y , z w postaci tablicy
        //trzyelementowej
        //metodę typu setter odpowiedzialną za ustawianie zmiennej z
        //metodę setXYZ ustawiającą wartości dla zmiennych x , y , z
        //metoda toString powinna zwracać łańcuch tekstowy o następującym
        //formacie: (x, y, z) ;
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie

        Point2d point = new Point2d(1, 2);
        Point2d point1 = new Point2d();
        point1.setY(4);
        System.out.println(point.getX());
        System.out.println(point.getY());

        System.out.println();

        System.out.println(point1.getX());
        System.out.println(point1.getY());

        System.out.println();

        System.out.println(Arrays.toString(point.getXY()));
        System.out.println(Arrays.toString(point1.getXY()));

        System.out.println();

        System.out.println(point.toString());
        System.out.println(point1.toString());

        Point3d point3d = new Point3d(1, 2, 3);
        Point3d point3d1 = new Point3d();
        point3d1.setX(4);
        point3d1.setY(5);
        point3d1.setZ(6);

        System.out.println(point3d.getX());
        System.out.println(point3d.getY());
        System.out.println(point3d.getZ());

        System.out.println();

        System.out.println(point3d1.getX());
        System.out.println(point3d1.getY());
        System.out.println(point3d1.getZ());

        System.out.println(Arrays.toString(point3d.getXYZ()));
        System.out.println(Arrays.toString(point3d1.getXYZ()));

        System.out.println();

        System.out.println(point3d.toString());
        System.out.println(point3d1.toString());
    }

}
