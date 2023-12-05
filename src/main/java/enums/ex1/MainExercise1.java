package enums.ex1;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zadanie 1
        //Stwórz klasę enum Weekday ze stałymi MONDAY , TUESDAY , ... SUNDAY . Enum
        //powinien zawierać metody boolean isWeekDay oraz boolean isHoliday .
        //Metoda isHoliday powinna zwracać rezultat przeciwny od rezultuatu
        //wywołania metody isWeekDay . Dodatkowo w ramach klasy enum powinna być
        //zadeklarowana i zaimplementowana metoda whichIsGreater . Metoda ta
        //powinna przyjmować obiekt typu Weekday . Metoda ta powinna wyświetlać
        //informacje o tym, że wskazany dzień tygodnia jest poprzednikiem bądź
        //następnikiem dnia tygodnia przekazanego w argumencie. W tym celu skorzystaj
        //z metody compareTo .
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie


        Weekday monday = Weekday.MONDAY;
        System.out.println(monday + " is weekday: " + monday.isWeekday());
        System.out.println(monday + " is holiday: " + monday.isHoliday());

        Weekday saturday = Weekday.SATURDAY;
        System.out.println(saturday + " is weekday: " + saturday.isWeekday());
        System.out.println(saturday + " is holiday: " + saturday.isHoliday());

        Weekday wednesday = Weekday.WEDNESDAY;
        monday.whichIsGreater(wednesday);

        Weekday friday = Weekday.FRIDAY;
        friday.whichIsGreater(saturday);

        saturday.whichIsGreater(monday);

        Weekday sunday = Weekday.SUNDAY;
        sunday.whichIsGreater(sunday);

    }

}
