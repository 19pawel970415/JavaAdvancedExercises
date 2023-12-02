package OOP.coffees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //1. Stwórz enum RodzajKawy (ARABICA, LIBERICA, ROBUSTA), oraz enum
    //    //PochodzenieKawy (COLUMBIA, BRASIL, INDIE), oraz klasę Kawa.
    //    //a. Klasa Kawa powinna mieć pola:
    //    //i. nazwa,
    //    //ii. data parzenia,
    //    //iii. rodzaj kawy (pole rodzaju RodzajKawy),
    //    //iv. pochodzenie kawy (pole rodzaju PochodzenieKawy)
    //    //b. Stwórz listę, dodaj do niej kilka rodzajów kawy (na “sztywno”)
    //    //c. * stwórz Scanner i pozwól używkonikowi podać dane swojej ulubionej kawy
    //    //(formularz, niech wpisze wszystkie pola niezbędne do stworzenia instancji
    //    //obiektu Kawa). Po stworzeniu instancji, dodaj go do listy. Przeiteruj listę i
    //    //wypisz na ekran wszystkie (pozostałe) kawy które są tego samego
    //    //rodzaju, ale innego pochodzenia.

    public static void main(String[] args) {

        Coffee coffee = new Coffee("Inka", LocalDate.of(2023, 12, 4), CoffeeType.ARABICA, CoffeeOrigin.BRAZIL);
        Coffee coffee1 = new Coffee("Tchibo", LocalDate.of(2022, 1, 5), CoffeeType.LIBERICA, CoffeeOrigin.COLUMBIA);
        Coffee coffee2 = new Coffee("SEGAFREDO INTERMEZZO", LocalDate.of(2021, 2, 6), CoffeeType.ROBUSTA, CoffeeOrigin.INDIA);

        List<Coffee> coffeeList = new ArrayList<Coffee>();

        coffeeList.add(coffee);
        coffeeList.add(coffee1);
        coffeeList.add(coffee2);


        Coffee coffeeFromUser = new Coffee();
        int yearFromUser = 0;
        int monthFromUser = 1;
        int dayFromUser = 1;

        for (int i = 0; i < 6; i++) {
            Scanner scanner = new Scanner(System.in);
            switch (i) {
                case 0:
                    System.out.println("Enter the name of your favourite coffee: ");
                    String name = scanner.nextLine();
                    coffeeFromUser.setName(name);
                    continue;
                case 1:
                    System.out.println("Enter the year of brewing of your favourite coffee: ");
                    yearFromUser = scanner.nextInt();
                    continue;
                case 2:
                    System.out.println("Enter the month of brewing of your favourite coffee: ");
                    monthFromUser = scanner.nextInt();
                    continue;
                case 3:
                    System.out.println("Enter the day of brewing of your favourite coffee: ");
                    dayFromUser = scanner.nextInt();
                    continue;
                case 4:
                    System.out.println("Enter the type of your favourite coffee (ARABICA, LIBERICA or ROBUSTA): ");
                    String type = scanner.nextLine();
                    coffeeFromUser.setType(CoffeeType.valueOf(type.toUpperCase()));
                    continue;
                case 5:
                    System.out.println("Enter the origin of your favourite coffee (COLUMBIA, BRAZIL, INDIA): ");
                    String origin = scanner.nextLine();
                    coffeeFromUser.setOrigin(CoffeeOrigin.valueOf(origin.toUpperCase()));
                    continue;
            }
        }
        LocalDate dateFromUser = LocalDate.of(yearFromUser, monthFromUser, dayFromUser);
        coffeeFromUser.setBrewingDate(dateFromUser);

        coffeeList.add(coffeeFromUser);

        for (Coffee c : coffeeList) {
            if (c == coffeeFromUser) {
                continue;
            } else if (c.getType() == coffeeFromUser.getType() && c.getOrigin() != coffeeFromUser.getOrigin()) {
                System.out.println(c.toString());
            }
        }
    }
}
