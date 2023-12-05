package enums.ex3;

public class MainExercise3 {

    public static void main(String[] args) {

        //Zadanie 3
        //Stwórz klasę enum TemperatureConvert ze stałymi C_F , C_K , K_C , F_C , F_K ,
        //K_F . Enum powinien zawierać konstruktor przyjmujący trzy parametry:jednostkę temperatury na wejściu
        //jednostkę temperatury na wyjściu
        //instancję interfejsu Converter (z metodą float convert(float tempIn) ) -
        //instancja ta powinna de¦nować niezbędne obliczenia w celu konwersji
        //temperatury
        //Dodatkowo enum TemperatureConvert powinien zawierać metodę statyczną
        //convertTemperature , która przyjmuje następujące parametry:
        //jednostkę temperatury na wejściu
        //jednostkę temperatury na wyjściu
        //wartość temperatury
        //Metoda ta powinna zwracać skonwertowaną wartość. Do znalezienia
        //odpowiedniej stałej należy skorzystać z metody values() .

        float temperatureCelsius = 25.0f;
        float convertedToFahrenheit = TemperatureConvert.convertTemperature('C', 'F', temperatureCelsius);
        System.out.println(temperatureCelsius + " Celsius is " + convertedToFahrenheit + " Fahrenheit");

        float temperatureKelvin = 300.0f;
        float convertedToCelsius = TemperatureConvert.convertTemperature('K', 'C', temperatureKelvin);
        System.out.println(temperatureKelvin + " Kelvin is " + convertedToCelsius + " Celsius");

        float temperatureFahrenheit = 77.0f;
        float convertedToKelvin = TemperatureConvert.convertTemperature('F', 'K', temperatureFahrenheit);
        System.out.println(temperatureFahrenheit + " Fahrenheit is " + convertedToKelvin + " Kelvin");

        float temperatureInvalid = 100.0f;
        float convertedInvalid = TemperatureConvert.convertTemperature('A', 'B', temperatureInvalid);


    }

}
