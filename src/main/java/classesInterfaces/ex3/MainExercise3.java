package classesInterfaces.ex3;

public class MainExercise3 {

    public static void main(String[] args) {

        //Klasa Car
        //Zaimplementuj klasę Car , która będzie przechowywać informacje o nazwie i
        //typie samochodu. Klasa ta powinna zwierać metody typu getter i setter .
        //Klasa Engine
        //Zaimplementuj klasę Engine , która będzie zagnieżdzoną klasą niestatyczną w
        //ramach klasy Car . Klasa ta powinna zawierać pole: typ silnika oraz metodę
        //setEngine , która ustawi odpowiedni typ na podstawie typu samochodu. Jeśli
        //typ samochodu będzie równy economy , to typ silnika powinien zostać ustawiony
        //na diesel . Jeśli typ samochodu bedzie równy luxury , to typ silnika powinien
        //zostać zde¦niowany jako electric . W innym przypadku typ silnika powinien
        //być równy petrol .

        Car car1 = new Car();
        car1.setName("Toyota");
        car1.setType("economy");

        Car.Engine engine1 = car1.new Engine();
        engine1.setEngineType();
        System.out.println("Car: " + car1.getName() + ", Type: " + car1.getType() + ", Engine Type: " + engine1.getEngineType());

        Car car2 = new Car();
        car2.setName("Mercedes");
        car2.setType("luxury");

        Car.Engine engine2 = car2.new Engine();
        engine2.setEngineType();
        System.out.println("Car: " + car2.getName() + ", Type: " + car2.getType() + ", Engine Type: " + engine2.getEngineType());

        Car car3 = new Car();
        car3.setName("Ford");
        car3.setType("other");

        Car.Engine engine3 = car3.new Engine();
        engine3.setEngineType();
        System.out.println("Car: " + car3.getName() + ", Type: " + car3.getType() + ", Engine Type: " + engine3.getEngineType());
    }

}

