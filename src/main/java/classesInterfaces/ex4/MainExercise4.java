package classesInterfaces.ex4;

public class MainExercise4 {

    public static void main(String[] args) {

        //Interfejs Validator
        //Zaimplementuj interfejs Validator, który będzie zawierać w swojej deklaracji
        //metodę boolean validate(T input) .
        //Klasa User
        //Zaimplementuj klasę User, która będzie zawierać: * pola: imię, nazwisko, wiek,
        //login, hasło * konstruktor bezparametrowy * metody typu setter i getter *
        //metody typu setter powinny przyjmować w swoim ciele odpowiednią wartość
        //pola oraz instancję klasy implementującej interfejs Validator * metody typu
        //setter powinny wywoływać metodę validate na podstawie instancji
        //przekazanego obiektu. Parametrem przekazywanym do metody validate
        //powinna być wartość pierwszego argumentuKlasy anoniowe
        //Mechanizmy walidujące klasy Validator powinny zostać zaimplementowane w
        //postaci klas anonimowych. Ponadto poszczególne klasy anonimowe powinny
        //wery¦kować poniższe zasady:
        //walidacja imienia: imię nie może być puste ani być nullem, powinno
        //zaczynać się od wielkiej litery
        //walidacja nazwiska: nazwisko nie może być puste ani być nullem, powinno
        //zaczynać się od wielkiej litery
        //walidacja wieku: wartość powinna mieścić się w przedziale o 0 do 150
        //login: wartość pola powinna składać się z 10 znaków
        //hasło: powinno zawierać znak !
        //Zaprezentuj zaimplementowane powyżej rozwiązanie na przykładzie

        User user = new User();
        user.setName("Paul", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && Character.isUpperCase(input.charAt(0))) ? true : false;
                return isValid;
            }
        });

        user.setSurname("Smith", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && Character.isUpperCase(input.charAt(0))) ? true : false;
                return isValid;
            }
        });

        user.setAge(25, new Validator<Integer>() {
            @Override
            public boolean validate(Integer input) {
                boolean isValid = (input != null && input >= 0 && input <= 150) ? true : false;
                return isValid;
            }
        });

        user.setLogin("kaopdunfju", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && input.length() == 10) ? true : false;
                return isValid;
            }
        });

        user.setPassword("!", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && input.contains("!")) ? true : false;
                return isValid;
            }
        });

        System.out.println(user.toString());

        User user1 = new User();
        user1.setName("paul", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && Character.isUpperCase(input.charAt(0))) ? true : false;
                return isValid;
            }
        });

        user1.setSurname("smith", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && Character.isUpperCase(input.charAt(0))) ? true : false;
                return isValid;
            }
        });

        user1.setAge(151, new Validator<Integer>() {
            @Override
            public boolean validate(Integer input) {
                boolean isValid = (input != null && input >= 0 && input <= 150) ? true : false;
                return isValid;
            }
        });

        user1.setLogin("kaopdunfj", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && input.length() == 10) ? true : false;
                return isValid;
            }
        });

        user1.setPassword("kas", new Validator<String>() {
            @Override
            public boolean validate(String input) {
                boolean isValid = (!input.isEmpty() && input != null && input.contains("!")) ? true : false;
                return isValid;
            }
        });

        System.out.println(user1.toString());
    }

}
