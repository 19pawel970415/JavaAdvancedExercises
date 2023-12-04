package OOP.exercises.ex3;

public class MainExercise3 {

    public static void main(String[] args) {

        //Klasa Shape
        //Zaimplementuj klasę Shape . Klasa powinna zawierać:
        //pole odpowiedzialne za przechowywanie koloru
        //pole odpowiedzialne za przechowywanie informacji o tym czy kolor
        //powinien wypełniać ¦gurę czy nie
        //konstruktor bezparametrowy ustawiający wartość pola color na unknown i
        //isFilled na false
        //konstruktor przyjmujący parametry color i isFilled
        //metody typu getter odpowiedzialne za zwracanie wartości pól klasy
        //metody typu setter odpowiedzialne za ustawianie wartości pól klasy
        //nadpisaną metodę toString odpowiedzialną za wyświetlanie następującej
        //informacji: Shape with color of ? and filled/NotFilled , gdzie ?
        //oznacza wartość kolor, a wartość filled / not filled powinna zostać
        //zwracana w zależności od pola isFilled
        //Klasa Circle
        // Zaimplementuj klasę Circle , która będzie rozszerzać klasę Shape o
        //następujące cechy:
        //pole odpowiedzialne za przechowywanie wartości promienia
        //konstruktor bezparametrowy ustawiający wartość pola color na unknown i
        //isFilled na false oraz pola radius na 1
        //konstruktor przyjmujący parametry color , isFilled , radius
        //metodę typu getter odpowiedzialną za zwracanie wartości pola radius
        //metodę typu setter odpowiedzialną za ustawianie wartości pola radius
        //metodę getArea odpowiedzialną za obliczanie pola powierzchni
        //metodę getPerimeter odpowiedzialną za obliczanie obwodu
        //nadpisaną metodę toString odpowiedzialną za wyświetlanie następującej
        //informacji: Circle with radius=? which is a subclass off y , gdzie ?
        //oznacza wartość promienia, a wartość y powinna być rezultatem
        //wywołania metody toString z klasu bazowej
        //Klasa Rectangle
        //Zaimplementuj klasę Rectangle , która będzie rozszerzać klasę Shape o
        //następujące cechy:
        //pole szerokość oraz długość będące typem double
        //konstruktor bezparametrowy ustawiający wartość pola color na unknown i
        //isFilled na false oraz pola width i length na 1
        //konstruktor przyjmujący parametry color , isFilled , width i length
        //metody typu getter do zwracania wartości pól width , length
        //metody typu setter do ustawiania wartości pól width i length
        //metodę getArea odpowiedzialną za obliczanie pola powierzchni
        //metodę getPerimeter odpowiedzialną za obliczanie obwodu
        //nadpisaną metodę toString odpowiedzialną za wyświetlanie następującej
        //informacji: Rectangle with width=? and length=? which is a subclass
        //off y , gdzie ? oznacza wartość odpowiednio szerokości i długości, awartość y powinna być rezultatem wywołania metody toString z klasy
        //bazowej
        //Klasa Square
        //Zaimplementuj klasę Square , która będzie rozszerzać klasę Rectangle . Klasa
        //ta nie powinna wprowadzać nowych pól oraz funkcjonalności, ale powinna
        //wymuszać na klasie bazowej zachowanie kwadratu.
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie

        Shape shape = new Shape("Red", true);
        System.out.println("Shape:");
        System.out.println("Colour: " + shape.getColour());
        System.out.println("Is Filled: " + shape.isFilled());
        System.out.println("toString(): " + shape.toString());
        System.out.println();

        Circle circle = new Circle("Blue", false, 5.0f);
        System.out.println("Circle:");
        System.out.println("Colour: " + circle.getColour());
        System.out.println("Is Filled: " + circle.isFilled());
        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("toString(): " + circle.toString());
        System.out.println();

        Rectangle rectangle = new Rectangle("Green", true, 4.0, 6.0);
        System.out.println("Rectangle:");
        System.out.println("Colour: " + rectangle.getColour());
        System.out.println("Is Filled: " + rectangle.isFilled());
        System.out.println("Width: " + rectangle.getX());
        System.out.println("Length: " + rectangle.getY());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
        System.out.println("toString(): " + rectangle.toString());
        System.out.println();

        Square square = new Square("Yellow", false, 3.0);
        System.out.println("Square:");
        System.out.println("Colour: " + square.getColour());
        System.out.println("Is Filled: " + square.isFilled());
        System.out.println("Width/Length: " + square.getX());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("toString(): " + square.toString());

    }

}
