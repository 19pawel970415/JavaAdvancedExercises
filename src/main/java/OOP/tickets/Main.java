package OOP.tickets;

import java.util.Scanner;

public class Main {

    //2. Stwórz enum Bilet.:
    //a. Rodzaje biletów:
    //i. NORMLANY_GODZINA, - cena 1.70
    //ii. ULGOWY_STUDENCKI, - cena 0.90
    //iii. NORMALNY_CALODNIOWY. - cena 5.30
    //iv. ULGOWY_EMERYT, - cena 0.30
    //b. Stwórz aplikację w rodzaju formularza. Zapytaj użytkownika o rodzaj biletu i
    //po wpisaniu odpowiedniej wartości wyświetl mu cenę.
    //c. Rozwiń program. Zapytaj również o ilość, a następnie przekalkuluj cenę.
    //d. Rozwiń program, zpytaj ile użytkownik ma zamiar zapłacić (np. do zapłaty jest
    //33.20 zł, a użytkownik odpowiada (na pytanie ile zapłaci) 50 zł. Wtedy my
    //wypisujemy resztę). Jeśli użytkownik poda zbyt małą kwotę, (np. 20zł, a do
    //zapłaty jest 30) to wypisujemy “a co pan sobie tutaj tera, jakieś jaja robi?” i
    //wymuś ponowne wpisanie kwoty. Próbę powtórz maksymalnie 3 razy.

    public static void main(String[] args) {

        boolean inputIsValid = false;
        do {
            System.out.println("Enter the type of ticket you want to buy: \n" +
                    "NORMLANY GODZINOWY \n" +
                    "ULGOWY STUDENCKI \n" +
                    "ULGOWY EMERYCKI \n" +
                    "NORMALNY CALODNIOWY");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            System.out.println("Entet the number of tickets you want to buy: ");
            float number = scanner.nextFloat();
            for (int i = 0; i < 3; i++) {
                System.out.println("How much are you going to pay?");
                float payment = scanner.nextFloat();
                if (line.equalsIgnoreCase("NORMLANY GODZINOWY")) {
                    if (payment >= Ticket.NORMLANY_GODZINA.getPrice() * number) {
                        System.out.println("The price is: " + (Ticket.NORMLANY_GODZINA.getPrice() * number) + " and you are paying " + payment + ". Your change is " + (payment - Ticket.NORMLANY_GODZINA.getPrice() * number));
                        break;
                    } else {
                        System.out.println("You will have to pay more! This amount is not enough!");
                    }
                    inputIsValid = true;
                } else if (line.equalsIgnoreCase("ULGOWY STUDENCKI")) {
                    if (payment >= Ticket.ULGOWY_STUDENCKI.getPrice() * number) {
                        System.out.println("The price is: " + (Ticket.ULGOWY_STUDENCKI.getPrice() * number) + " and you are paying " + payment + ". Your change is " + (payment - Ticket.ULGOWY_STUDENCKI.getPrice() * number));
                        break;
                    } else {
                        System.out.println("You will have to pay more! This amount is not enough!");
                    }
                    inputIsValid = true;
                } else if (line.equalsIgnoreCase("ULGOWY EMERYCKI")) {
                    if (payment >= Ticket.ULGOWY_EMERYT.getPrice() * number) {
                        System.out.println("The price is: " + (Ticket.ULGOWY_EMERYT.getPrice() * number) + " and you are paying " + payment + ". Your change is " + (payment - Ticket.ULGOWY_EMERYT.getPrice() * number));
                        break;
                    } else {
                        System.out.println("You will have to pay more! This amount is not enough!");
                    }
                    inputIsValid = true;
                } else if (line.equalsIgnoreCase("NORMALNY CALODNIOWY")) {
                    if (payment >= Ticket.NORMALNY_CALODNIOWY.getPrice() * number) {
                        System.out.println("The price is: " + (Ticket.NORMALNY_CALODNIOWY.getPrice() * number) + " and you are paying " + payment + ". Your change is " + (payment - Ticket.NORMALNY_CALODNIOWY.getPrice() * number));
                        break;
                    } else {
                        System.out.println("You will have to pay more! This amount is not enough!");
                    }
                    inputIsValid = true;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        } while (!inputIsValid);
    }

}
