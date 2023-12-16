package OOP;

import threads.exercises.ex3.BubbleSort;

import java.time.LocalDate;
import java.util.*;

public class MainAdditionalExercises {

    public static void main(String[] args) {

        //Odwróć liczbę za pomocą pętli while.
        //Program poprosi użytkownika o wprowadzenie numeru, a następnie odwróci liczbę za
        //pomocą pętli while.

        System.out.println("Enter the number you want to reverse:");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int counter = line.length();

        while (counter > 0) {
            System.out.print(line.charAt(counter - 1));
            counter--;
        }

        //Napisz program, który odbiera rozmiar tablicy (n) od użytkownika (System.in). Następnie
        //odbierz n liczb od użytkownika i umieść je w tablicy. Zaimplementuj algorytm
        //sortowania bąbelkowego, aby posortować tę tablicę w porządku rosnącym.

        System.out.println();

        System.out.println("Enter the size of the array:");

        int length = scanner.nextInt();
        Integer[] array = new Integer[length];

        for (int i = 0; i < length; i++) {
            System.out.println("Enter number: ");
            array[i] = scanner.nextInt();
        }

        BubbleSort bubbleSort = new BubbleSort(array);
        try {
            String call = bubbleSort.call();
            System.out.println(call);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        for (Integer integer : array) {
            System.out.print(integer + " ");
        }

        //Utwórz aplikację imitującą sklep. Utwórz klasę Basket, która pozwoli dodawać, usuwać i
        //pobierać wszystkie elementy z koszyka. Każdy element jest instancją interfejsu Product,
        //który definiuje dwie metody: jedną, aby uzyskać cenę produktu, a drugą, aby sprawdzić
        //dostępność na podstawie podanej daty.
        //Utwórz klasę GenericProduct, która implementuje interfejs Product i będzie w
        //konstruktorze przyjmować Supplier używany do określania ceny i Function używany do
        //określania dostępności produktu na podstawie podanej daty.
        //Upewnij się, że Basket nie ujawnia swojej wewnętrznej listy przechowującej produkty
        //(co oznacza, że nie zwróci odniesienia do wewnętrznej listy, ale raczej kopię), wszystkie
        //operacje na tej liście powinny być wykonane metodami klasy Basket.
        //Dodaj kilka produktów do koszyka z zadania 11. Sprawdź, czy wszystko działa zgodnie z
        //oczekiwaniami.
        //Ulepsz koszyk, aby śledził także ilość określonego produktu i pozwalał na
        //zwiększanie lub zmniejszanie o określoną ilość.
        //Utwórz klasę OrderService, która akceptuje instancję klasy Basket z zadania 12 i zwraca
        //cenę całkowitą dla wszystkich dostępnych elementów w Basket. Pamiętaj o ilości -
        //będziesz musiał ponownie poprawić klasę Basket. Użyj strumieni.

        System.out.println();

        Basket basket = new Basket();
        basket.addProduct(new GenericProduct(() -> 10d, (d) -> LocalDate.now().isAfter(d)),10);
        basket.addProduct(new GenericProduct(() -> 20d, (d) -> true),15);
        ProductInterface product = new GenericProduct(() -> 30d, (d) -> false);
        basket.addProduct(product, 30);
        System.out.println(basket.getAllProducts());
        basket.removeProduct(product, 15);
        System.out.println(basket.getAllProducts());
        basket.removeProduct(product, 16);
        System.out.println(basket.getAllProducts());

        OrderService orderService = new OrderService();
        double priceOfAllBasket = orderService.calculatePrice(basket);
        System.out.println(priceOfAllBasket);
    }

}


