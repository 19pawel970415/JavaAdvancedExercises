package OOP.exercises.ex7;

public class MainExercise7 {

    public static void main(String[] args) {

        //Zaimplementuj interfejs GeometricObject , który będzie zawierać de¦nicję
        //wspólnych zachowań dla klas pochodnych:
        //double getPerimeter()
        //double getArea()
        //Klasa Circle
        //Klasa Circle powinna implementować interfejs GeometricObject , a ponadto
        //zawierać pole: promień. Metody interfejsu GeometricObject powinny zostać
        //zaimplementowane zgodnie z de¦nicjami metematycznymi.
        //Interfejs Resizable
        //Interfejs Resizable powinien deklarować metodę resize(int percent) , która
        //ma być odpowiedzialna za przeskalowanie obiektów implementującychtworzony interfejs.
        //Klasa ResizableCircle
        //Klasa ResizableCircle powinna implementować interfejs Resizable . Metoda
        //resize interfejsu powinna zmniejszać procentowo promień koła.
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie.

        Circle circle = new Circle(14);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle);
        Resizable resizable = new ResizableCircle(40);
        resizable.resize(30);
        System.out.println(resizable);

    }

}
