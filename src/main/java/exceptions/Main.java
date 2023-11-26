package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        askForNumber(scanner);

    }

    private static int askForNumber(Scanner scanner) {

        Integer value;

        do {
            try {
                System.out.println("Enter a number: ");
                value = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("The input is incorrect, enter a NUMBER: ");
                scanner.next();
                value = null;
            }
        } while (value == null);

        return value;
    }
}
