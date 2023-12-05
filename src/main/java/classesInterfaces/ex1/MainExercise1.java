package classesInterfaces.ex1;

import java.util.List;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zadanie 1
        // Zaimplementuj klasę UserValidator , która w ramach metody validateEmails
        //będzie odpowiedzialna za walidację danych użytkownika: email, email
        //alternatywny. W ramach metody validateEmails zadeklaruj klasę lokalną
        //Email , która będzie odpowiedzialna za formatowanie wskazanego adresu email
        //uwzględniając następujące reguły:
        //jeśli wskazany adres email jest pusty, bądź jest nullem należy ustawić mu
        //wartość unknown
        //jeśli wskazany adres email nie spełnia założeń adresu email, należy ustawić
        //wartość unknown (skorzystaj w tym celu z wyrażeń regularnych

        UserValidator userValidator = new UserValidator();
        List<String> emails = userValidator.validateEmails("pual.crane@gmail.com", "pual.crane@wp.pl");
        emails.stream().forEach(System.out::println);
    }

}
