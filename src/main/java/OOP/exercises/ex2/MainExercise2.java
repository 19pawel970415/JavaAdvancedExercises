package OOP.exercises.ex2;

public class MainExercise2 {

    public static void main(String[] args) {

        //Klasa Person
        //Zaimplementuj klasę abstrakcyjną Person . Klasa powinna zawierać:
        //dwa pola typu String: name , address
        //konstruktor bezparametrowy ustawiający wartość pól name i address na
        //pusty String
        //konstruktor z dwoma parametrami: String name , String address
        //metody typu getter odpowiedzialne za zwracanie wartości zmiennej: name ,
        //address
        //metody typu setter odpowiedzialne za ustawianie wartości pól name ,
        //address
        //metoda toString powinna zwracać łańcuch tekstowy o następującym
        //formacie: ?->? , gdzie ? to odpowiednio imię i adres;
        //Klasa Student
        //Zaimplementuj klasę Student . Klasa ta powinna rozszerzać klasę Person .
        //Dodatkowo powinna zawierać:
        //trzy pola: typ studiów, rok studiów, koszt studiów
        //konstruktor z trzema parametrami: typ studiów, rok studiów, koszt studiów
        //metody typu getter dla zdeklarowanych pól
        //metody typu setter dla zdeklarowanych pól
        //metoda toString wyświetlająca szczegółowe informacje o studencie
        //Klasa Staff
        //Zaimplementuj klasę Lecturer . Klasa ta powinna rozszerzać klasę Person .
        //Dodatkowo powinna zawierać:
        //dwa pola: specjalizacja oraz wynagrodzenie
        //konstruktor z dwoma parametrami: specjalizacja, wynagrodzenie
        //metody typu getter dla zdeklarowanych pól
        //metody typu setter dla zdeklarowanych pól
        //metodę toString wyświetlającą szczegółowe informacje o wykładowcy
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie.

        Person person = new Person("John Doe", "123 Main St");
        System.out.println("Person:");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("toString(): " + person.toString());
        System.out.println();

        Lecturer lecturer = new Lecturer("Computer Science", 5000.0f);
        lecturer.setName("Dr. Smith");
        lecturer.setAddress("456 University Ave");
        System.out.println("Lecturer:");
        System.out.println("Name: " + lecturer.getName());
        System.out.println("Address: " + lecturer.getAddress());
        System.out.println("Field: " + lecturer.getField());
        System.out.println("Salary: " + lecturer.getSalary());
        System.out.println("toString(): " + lecturer.toString());
        System.out.println();

        Student student = new Student("Bachelor", "2nd year", 2000.0f);
        student.setName("Alice Johnson");
        student.setAddress("789 College Rd");
        System.out.println("Student:");
        System.out.println("Name: " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Degree Type: " + student.getDegreeType());
        System.out.println("Year of Course: " + student.getYearOfCourse());
        System.out.println("Price of Course: " + student.getPriceOfCourse());
        System.out.println("toString(): " + student.toString());

    }

}
