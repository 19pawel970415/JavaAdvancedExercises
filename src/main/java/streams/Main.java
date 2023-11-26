package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //    1.Napisz klasę person, która ma pola: firstName, lastName, age oraz isMale.
//    Mając listę osób i korzystając ze streamów:
//    a) uzyskaj listę mężczyzn
//    b) uzyskaj listę dorosłych kobiet (filter)
//    c) uzyskaj Optional<Person> z dorosłym Jackiem
//    d) uzyskaj listę wszystkich nazwisk osób, które są w przedziale wiekowym: 15-19
//    e)* uzyskaj sumę wieku wszystkich osób
//    f)* uzyskaj średnią wieku wszystkich mężczyzn
//    g)** znajdź nastarszą osobę w liście

    //2. Stwórz klasę Programmer, która ma klasę Person jako pole. Poza tym, posiada listę
    //języków, którymi się posługuje. Mogą być one reprezentowane przez klasę String.
    //Mając listę programistów i korzystając ze streamów:
    //a) uzyskaj listę programistów, którzy są mężczyznami
    //b) uzyskaj listę niepełnoletnich programistów (obydwóch płci), którzy piszą w Cobolu
    //c) uzyskaj listę programistów, którzy znają więcej, niż jeden język programowania
    //d) uzyskaj listę programistek, które piszą w Javie i Cpp
    //e) uzyskaj listę męskich imion
    //f) uzyskaj set wszystkich języków opanowanych przez programistów
    //g) uzyskaj listę nazwisk programistów, którzy znają więcej, niż dwa języki
    //h) sprawdź, czy istnieje chociaż jedna osoba, która nie zna żadnego języka
    //i)* uzyskaj ilość wszystkich języków opanowanych przez programistki


    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);
        List<Person> people = (Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9));
        System.out.println(people);
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java;Python".split(";"));
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers =
                Arrays.asList(programmer1, programmer2, programmer3, programmer4,
                        programmer5, programmer6, programmer7, programmer8, programmer9);
        System.out.println(programmers);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Exercise 1");

        //1a

        List<Person> malePeople = people.stream()
                .filter(Person::isMale)
                .collect(Collectors.toList());

        System.out.println(malePeople);

        //1b

        List<Person> femaleAdultPeople = people.stream()
                .filter(person -> (!person.isMale()) && person.getAge() >= 18)
                .collect(Collectors.toList());

        System.out.println(femaleAdultPeople);

        //1c

        Optional<Person> adultJacek = people.stream()
                .filter(person -> (person.getFirstName().equals("Jacek")) && (person.getAge() >= 18))
                .findFirst();

        if (adultJacek.isPresent()) {
            System.out.println(adultJacek);
        } else {
            System.out.println("No adult Jacek on the list");
        }

        //1d

        List<String> surnames15to19 = people.stream()
                .filter(person -> (person.getAge() >= 15) && (person.getAge() <= 19))
                .map(Person::getLastName)
                .collect(Collectors.toList());

        System.out.println(surnames15to19);

        //1e

        int sumOfAges = people.stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println(sumOfAges);

        //1f

        OptionalDouble averageOfMaleAge = people.stream()
                .filter(Person::isMale)
                .mapToInt(Person::getAge)
                .average();

        if (averageOfMaleAge.isPresent()) {
            System.out.println(averageOfMaleAge);
        } else {
            System.out.println("No men on the list");
        }

        //1g

        Optional<Person> theOldestPerson = people.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);

        System.out.println(theOldestPerson);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Exercise 2");

        //2a

        List<Programmer> maleProgrammers = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());

        System.out.println(maleProgrammers);

        //2b

        List<Programmer> cobolYoungProgrammers = programmers.stream()
                .filter(programmer -> (programmer.getPerson().getAge() < 18) && programmer.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());

        System.out.println(cobolYoungProgrammers);


        //2c

        List<Programmer> programmersKnowingMoreThan1Lang = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 1)
                .collect(Collectors.toList());

        System.out.println(programmersKnowingMoreThan1Lang);

        //2d

        List<Programmer> womenKnowingJavaAndCpp = programmers.stream()
                .filter(programmer -> (!programmer.getPerson().isMale())
                        && (programmer.getLanguages().contains("Java"))
                        && (programmer.getLanguages().contains("Cpp")))
                .collect(Collectors.toList());

        System.out.println(womenKnowingJavaAndCpp);

        //2e

        List<String> maleNames = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .map(programmer -> programmer.getPerson().getFirstName())
                .collect(Collectors.toList());

        System.out.println(maleNames);

        //2f

        Set<String> languagesSet = programmers.stream()
                .map(Programmer::getLanguages)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        System.out.println(languagesSet);

        //2g

        List<String> surnamesKnowingMoreThanTwoLanguages = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 2)
                .map(programmer -> programmer.getPerson().getLastName())
                .collect(Collectors.toList());

        System.out.println(surnamesKnowingMoreThanTwoLanguages);

        //2h

        Optional<Programmer> programmerKnowingNoLang = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() == 0)
                .findAny();

        if (programmerKnowingNoLang.isPresent()) {
            System.out.println("There is a person not knowing any language");
        } else {
            System.out.println("Ever programmer knows at least one language");
        }

        //2i

        long numOfLangsKnownByFemaleProgrammers = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .map(Programmer::getLanguages)
                .flatMap(Collection::stream)
                .distinct()
                .count();

        System.out.println(numOfLangsKnownByFemaleProgrammers);


        Product productFiat = new Product("Fiat Fullback", 82000);
        Product productSkoda = new Product("Skoda Octavia", 45000);
        Product productAudi = new Product("Audi A4", 90000);
        Product productFord = new Product("Ford mustang", 20000);
        Product productFiatTipo = new Product("Fiat Tipo", 52000);
        Product productCatering = new Product("Catering for event", 1300);
        Product productOfficeRent = new Product("Office rent", 25000);
        Product productFuelGasoline = new Product("Fuel, gasoline 95", 5.13);
        Product productFuelON = new Product("Fuel, oil", 5.02);
        Product productScrew = new Product("Screw", 3.2);
        Product productHammer = new Product("Hammer", 15.99);
        Product productPowerbank = new Product("Power bank", 15.99);
        Product productPhoneSamsung = new Product("Samsung Phone", 999.0);
        Product productPhoneApple = new Product("Apple Phone", 1299.99);
        Product productLaptopDell = new Product("Laptop, Dell Latitude", 1399.0);
        Product productLaptopApple = new Product("Laptop, Apple MacBook Pro", 1799.0);
        Product productServerDellPrecision = new Product("Server, Server Dell Precision", 2490.0);
        Product productPC = new Product("PC, Asus", 790.0);
        Product productCase = new Product("Case", 500.0);
        Product productSwitch = new Product("Network Switch", 130.0);
        Product productCoffeA = new Product("Coffee, Arabica", 29.99);
        Product productCoffeR = new Product("Coffee, Robusta", 39.99);
        Product productMug = new Product("Mug", 5.00);
        Product productPen = new Product("Pen", 0.99);
        Product productPencil = new Product("Pencil", 0.50);
        Product productClip = new Product("Clip", 2.49);
        Product productPuncher = new Product("Puncher", 0.79);
        Product productPaper = new Product("Paper", 9.99);
        Product productScisors = new Product("Scissors", 0.99);
        Product productFlour = new Product("Flour", 1.39);
        Product productSugar = new Product("Sugar", 1.87);
        Product productChocolate = new Product("Chocolate", 1.99);

        Company companyFallen = new Company("Fallen", "Detroit", 320, new ArrayList<>(Arrays.asList(
                new Purchase(productFiat, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 4), 18.1, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 9), 23.9, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 18), 41.8, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 23), 37.2, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 30), 7.3, UNIT.UNIT),
                new Purchase(productHammer, LocalDate.of(2018, 1, 29), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 2), 21.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 3), 43.3, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 10), 13.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 5), 25.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 13), 38.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 19), 111.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 20), 59.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 21), 230.3, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 26), 18.3, UNIT.UNIT),

                new Purchase(productCoffeA, LocalDate.of(2018, 2, 15), 10.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 20), 10.0, UNIT.UNIT)
        )));

        Company companyPetersWifesCookies = new Company("Peters wifes cookies", "London", 12, new ArrayList<>(Arrays.asList(
                new Purchase(productFlour, LocalDate.of(2018, 1, 1), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 1), 25, UNIT.KILOGRAM),

                new Purchase(productFlour, LocalDate.of(2018, 1, 7), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 14), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 21), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 1, 28), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 21), 25, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 1), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 7), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 14), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 21), 7, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 28), 7, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 15), 25, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 6), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 13), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 20), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 27), 10, UNIT.KILOGRAM),
                new Purchase(productFlour, LocalDate.of(2018, 2, 28), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 6), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 13), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 20), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 27), 10, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 28), 10, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 28), 25, UNIT.KILOGRAM)
        )));

        Company companyTheOffice = new Company("Dunder Mifflin", "Detroit", 17, new ArrayList<>(Arrays.asList(
                new Purchase(productPaper, LocalDate.of(2018, 1, 1), 20.0, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 2), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 3), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 4), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 5), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 6), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 7), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 8), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 10), 20.0, UNIT.UNIT),
                new Purchase(productScisors, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 1, 10), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 10), 20, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 11), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 12), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 13), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 14), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 15), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 16), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 17), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 18), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 19), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 20), 13.0, UNIT.UNIT),

                new Purchase(productScisors, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 1, 20), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 20), 20, UNIT.KILOGRAM),

                new Purchase(productPaper, LocalDate.of(2018, 1, 21), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 22), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 23), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 24), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 25), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 26), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 27), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 28), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 29), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 30), 20.0, UNIT.UNIT),

                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 1), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 2), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 3), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 4), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 5), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 6), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 7), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 8), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 9), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 10), 20.0, UNIT.UNIT),

                new Purchase(productScisors, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPuncher, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productClip, LocalDate.of(2018, 2, 10), 50, UNIT.UNIT),
                new Purchase(productMug, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 10), 20, UNIT.KILOGRAM),

                new Purchase(productPaper, LocalDate.of(2018, 2, 11), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 12), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 13), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 14), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 15), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 16), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 17), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 18), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 19), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 20), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 21), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 22), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 23), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 24), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 25), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 26), 13.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 27), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 20.0, UNIT.UNIT)
        )));

        Company transporting = new Company("Take me home", "London", 5, new ArrayList<>(Arrays.asList(
                new Purchase(productSkoda, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productFiatTipo, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productAudi, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 1), 330.32, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 2.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 3), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 5), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 7), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 9), 325.13, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 11), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 13), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 15), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 17), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 19), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 21), 330.32, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 23), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 25), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 27), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 29), 325.13, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 2.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 1), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 3), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 5), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 7), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 9), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 11), 325.17, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 13), 325.18, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 15), 302.82, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 17), 321.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 19), 395.93, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 21), 330.32, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 23), 327.58, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 25), 317.44, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 27), 332.11, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 325.13, UNIT.UNIT)
        )));

        Company companyTonysHardware = new Company("Tony's hardware", "Detroit", 2, new ArrayList<>(Arrays.asList(
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productScrew, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productHammer, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productFord, LocalDate.of(2018, 2, 20), 2, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 20), 70.0, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 13), 20.0, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 35.0, UNIT.UNIT)
        )));

        Company companyTailor = new Company("Tailor Swift", "New York City", 3, new ArrayList<>(Arrays.asList(
                new Purchase(productScisors, LocalDate.of(2018, 1, 1), 3, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 3, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 1), 3, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 2, UNIT.KILOGRAM),

                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 2, UNIT.UNIT),
                new Purchase(productPen, LocalDate.of(2018, 1, 13), 3, UNIT.UNIT),
                new Purchase(productPencil, LocalDate.of(2018, 1, 18), 3, UNIT.UNIT)
        )));

        Company companyGoogleDublin = new Company("Google", "Dublin", 91, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 91, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 91, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 20), 50.0, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 3), 20, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 91, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 91, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 5, UNIT.UNIT)
        )));


        Company companyGoogleLondon = new Company("Google", "London", 76, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 20, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 76, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 76, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 28), 50.0, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 76, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 4, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 4, UNIT.UNIT)
        )));


        Company companyGoogleKijev = new Company("Google", "Kijev", 23, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 5), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 15), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 30), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 5), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 15), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 28), 23, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 10, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 3), 30.0, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT)
        )));


        Company companyFintech = new Company("Fintech", "London", 9, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 1), 23, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 5), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT)
        )));

        Company companyFintechNewYork = new Company("Fintech", "New York City", 19, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 5), 10, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 5), 7, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 23, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 2, 1), 23, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productPowerbank, LocalDate.of(2018, 1, 1), 10, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 2, 1), 15.0, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 10), 3, UNIT.UNIT),
                new Purchase(productPhoneSamsung, LocalDate.of(2018, 2, 10), 4, UNIT.UNIT),
                new Purchase(productPhoneSamsung, LocalDate.of(2018, 2, 10), 4, UNIT.UNIT),
                new Purchase(productCase, LocalDate.of(2018, 1, 15), 2, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT)
        )));

        Company bakeryDetroit = new Company("Detroit Bakery", "Detroit", 11, new ArrayList<>(Arrays.asList(
                new Purchase(productFlour, LocalDate.of(2018, 1, 1), 200, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 1), 50, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 1, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 1), 132.53, UNIT.UNIT),
                new Purchase(productFlour, LocalDate.of(2018, 2, 1), 190, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 62, UNIT.KILOGRAM),
                new Purchase(productSugar, LocalDate.of(2018, 2, 1), 79, UNIT.KILOGRAM)
        )));

        Company baltimoreFishing = new Company("Fisz", "Baltimore", 5, new ArrayList<>(Arrays.asList(
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 3), 500, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 15), 500, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 15), 100, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 1, 30), 500, UNIT.UNIT),
                new Purchase(productPC, LocalDate.of(2018, 1, 20), 500, UNIT.UNIT),
                new Purchase(productSwitch, LocalDate.of(2018, 1, 20), 500, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 15), 500, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 15), 100, UNIT.UNIT),
                new Purchase(productFuelGasoline, LocalDate.of(2018, 2, 28), 500, UNIT.UNIT)
        )));

        Company solwit = new Company("Solwit", "Kijev", 68, new ArrayList<>(Arrays.asList(
                new Purchase(productAudi, LocalDate.of(2018, 1, 2), 2, UNIT.UNIT),
                new Purchase(productPC, LocalDate.of(2018, 1, 2), 5, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 2), 89, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 12), 73.13, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 1, 29), 67.33, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 13), 91.44, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 25), 47.12, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 1), 1, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 2), 1, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 3), 1, UNIT.UNIT),
                new Purchase(productPaper, LocalDate.of(2018, 1, 23), 20.0, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 2, 4), 1, UNIT.UNIT),
                new Purchase(productFuelON, LocalDate.of(2018, 2, 25), 47.12, UNIT.UNIT)

        )));

        Company solwitGda = new Company("Solwit", "Gdansk", 68, new ArrayList<>(Arrays.asList(
                new Purchase(productPC, LocalDate.of(2018, 1, 2), 5, UNIT.UNIT),
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 10), 20.0, UNIT.UNIT),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 7), 1.0, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 1.0, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 2, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 2, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 15, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 15, UNIT.UNIT)
        )));

        Company intelD = new Company("Intel", "Detroit", 755, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 1), 100, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 1, 10), 10, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 1), 100, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 3), 23.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 100, UNIT.KILOGRAM),
                new Purchase(productLaptopDell, LocalDate.of(2018, 1, 15), 10, UNIT.UNIT),
                new Purchase(productCase, LocalDate.of(2018, 2, 20), 10, UNIT.UNIT)
        )));

        Company intelGda = new Company("Intel", "Gdansk", 161, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 5), 50, UNIT.KILOGRAM),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 10, UNIT.KILOGRAM)

        )));

        Company intelKij = new Company("Intel", "Kijev", 161, new ArrayList<>(Arrays.asList(
                new Purchase(productServerDellPrecision, LocalDate.of(2018, 1, 1), 50, UNIT.UNIT),
                new Purchase(productLaptopApple, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productPhoneApple, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productCatering, LocalDate.of(2018, 1, 1), 5, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 1, 1), 100, UNIT.UNIT),
                new Purchase(productOfficeRent, LocalDate.of(2018, 2, 1), 100, UNIT.UNIT),
                new Purchase(productCoffeA, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productCoffeA, LocalDate.of(2018, 2, 5), 50, UNIT.KILOGRAM),
                new Purchase(productChocolate, LocalDate.of(2018, 2, 1), 15, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 1, 5), 30, UNIT.KILOGRAM),
                new Purchase(productPaper, LocalDate.of(2018, 1, 9), 20.0, UNIT.UNIT),
                new Purchase(productCoffeR, LocalDate.of(2018, 2, 1), 10, UNIT.KILOGRAM)

        )));

        List<Company> companies = new ArrayList<>(Arrays.asList(
                companyFallen,
                companyPetersWifesCookies,
                companyTheOffice,
                transporting,
                companyTonysHardware,
                companyTailor,
                companyGoogleDublin,
                companyGoogleLondon,
                companyGoogleKijev,
                companyFintech,
                companyFintechNewYork,
                bakeryDetroit,
                baltimoreFishing,
                solwitGda,
                solwit,
                intelD,
                intelGda,
                intelKij
        ));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Exercise 3");

// Polecenie 3:
// Dane to Firmy oraz ich zakupy z miesiąca styczeń/luty 2018.

// 1. Wylistuj (system out println) wszystkie firmy

        System.out.println(companies);

// 2. Wylistuj wszystkie firmy które są z Detroit

        List<Company> detroitCompanies = companies.stream()
                .filter(company -> company.getCityHeadquarters().equals("Detroit"))
                .collect(Collectors.toList());

        System.out.println(detroitCompanies);

// 3. Wylistuj wszystkie firmy z Londynu, posortuj je po ilości pracowników (rosnąco).

        List<Company> londonCompniesSortedByEmpsAsc = companies.stream()
                .filter(company -> company.getCityHeadquarters().equals("London"))
                .sorted((company1, company2) -> Integer.compare(company1.getEmployees(), company2.getEmployees()))
                .collect(Collectors.toList());

        System.out.println(londonCompniesSortedByEmpsAsc);

// 4. Wylistuj wszystkie firmy z Detroit. Posortuj je po ilości zakupów (rosnąco) i ilości pracowników (malejąco).

        List<Company> detroitCompaniesSortedByNumOfPurchaseAscAndNumOfEmplsDesc = companies.stream()
                .filter(company -> company.getCityHeadquarters().equals("Detroit"))
                .sorted((company1, company2) -> Integer.compare(company1.getPurchaseList().size(), company2.getPurchaseList().size()))
                .sorted((company1, company2) -> Integer.compare(company2.getEmployees(), company1.getEmployees()))
                .collect(Collectors.toList());

        System.out.println(detroitCompaniesSortedByNumOfPurchaseAscAndNumOfEmplsDesc);

// 5. Zwróć firmę z największą ilością pracowników, która pochodzi z Kijowa.

        Optional<String> kijevBiggestCompany = companies.stream()
                .filter(company -> company.getCityHeadquarters().equals("Kijev"))
                .max((company1, company2) -> Integer.compare(company1.getEmployees(), company2.getEmployees()))
                .map(Company::getName);

        if (kijevBiggestCompany.isPresent()) {
            System.out.println(kijevBiggestCompany);
        } else {
            System.out.println("No company from Kiev");
        }

// 6. Zwróć firmę z najkrótszą nazwą

        Optional<String> comWithShortestName = companies.stream()
                .min((company1, company2) -> Integer.compare(company1.getName().length(), company2.getName().length()))
                .map(Company::getName);

        if (comWithShortestName.isPresent()) {
            System.out.println(comWithShortestName);
        } else {
            System.out.println("No companies on the list");
        }

// 7. Zwróć firmę która nie pochodzi z Kijowa, Londynu i Detroit, która ma najmniej kupionych produktów.

        Optional<Company> companyNotFromKievLondonDetroitWithSmallestNumOfPurchases = companies.stream()
                .filter(company -> (!company.getName().contains("Kijew")) && (!company.getName().contains("London")) && (!company.getName().contains("Detroit")))
                .min((company1, company2) -> Integer.compare(company1.getPurchaseList().size(), company2.getPurchaseList().size()));

        System.out.println(companyNotFromKievLondonDetroitWithSmallestNumOfPurchases);

// 8. Każdej firmie dodaj po 1 pracowniku, jeśli pochodzi z Kijowa lub Detroit

        for (Company company : companies) {
            if (company.getCityHeadquarters().equals("Kijew") || company.getCityHeadquarters().equals("Detroit")) {
                company.setEmployees(company.getEmployees() + 1);
            }
        }

// 9. ** Zwróć MAPĘ w której kluczem jest nazwa firmy, a wartością ilość pracowników w tej firmie (https://howtodoinjava.com/java8/collect-stream-to-map/)

        Map<String, Integer> companyEmployeeMap = companies.stream()
                .collect(Collectors.groupingBy(
                        Company::getName,
                        Collectors.summingInt(Company::getEmployees)
                ));

        System.out.println(companyEmployeeMap);


// 10.** Zwróć Mapę w której kluczem jest miejscowość a wartością jest LISTA FIRM z tamtej miejscowości (Map<String, List<Company>) (https://stackoverflow.com/questions/24917053/collecting-hashmapstring-liststring-java-8)

        Map<String, List<Company>> companiesInTheCity = companies.stream()
                .collect(Collectors.groupingBy(
                        Company::getCityHeadquarters,
                        Collectors.toList()
                ));

        System.out.println(companiesInTheCity);
// 11. Zwróć firmę która dokonała zakupów na największą kwotę

        Optional<Company> maxBillCompany = companies.stream()
                .max(Comparator.comparingDouble(company -> company.getPurchaseList().stream()
                        .mapToDouble(purchase -> (purchase.getQuantity() * purchase.getProduct().getPrice()))
                        .sum()));

        if (maxBillCompany.isPresent()) {
            System.out.println(maxBillCompany);
        } else {
            System.out.println("No company on the list");
        }

// 12. Zwróć firmę która kupiła najwięcej produktów za kwotę wyższą niż 10 k

        Map<Double, List<Company>> firmOrFirmsBuyingGreatestNumOfProductsOver10k = companies.stream()
                .collect(Collectors.groupingBy((company -> company.getPurchaseList().stream()
                        .filter(purchase -> (purchase.getQuantity() * purchase.getProduct().getPrice()) > 10000)
                        .mapToDouble(purchase -> purchase.getQuantity())
                        .sum())));
        System.out.println(firmOrFirmsBuyingGreatestNumOfProductsOver10k);

// 13. *Zwróć miejscowość która wydała najwięcej pieniędzy. Stwórz mapę Map<String, Double> gdzie kluczem jest miejscowość, a wartością jest kwota wydana przez firmy pochodzące z tamtej miejscowości

        Map<String, Double> cityExpenses = companies.stream()
                .collect(Collectors.groupingBy(company -> company.getCityHeadquarters(),
                        Collectors.summingDouble(company -> company.getPurchaseList().stream()
                                .mapToDouble(purchase -> purchase.getQuantity() * purchase.getProduct().getPrice())
                                .sum())));

// 14. Wypisz firmy które 15 stycznia 2018 kupiły "Network Switch"

        List<Company> companiesBuyingNetworkSwitchOn15012018 = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch((purchase -> purchase.getProduct().getName().equals("Network Switch"))))
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch((purchase -> (purchase.getPurchaseDate().getYear() == 2018) && (purchase.getPurchaseDate().getMonthValue() == 1) && (purchase.getPurchaseDate().getDayOfMonth() == 15))))
                .collect(Collectors.toList());

        System.out.println(companiesBuyingNetworkSwitchOn15012018);

// 15. Znajdź firmę która kupuje najwięcej kawy

        Optional<Company> companyBuyingMaxCoffee = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase -> purchase.getProduct().getName().contains("Coffee")))
                .max(Comparator.comparingDouble(company -> company.getPurchaseList().stream()
                        .filter(purchase -> purchase.getProduct().getName().contains("Coffee"))
                        .mapToDouble(purchase -> purchase.getQuantity())
                        .sum()));

        if (companyBuyingMaxCoffee.isPresent()) {
            System.out.println(companyBuyingMaxCoffee);
        } else {
            System.out.println("No company buys coffee");
        }

// 16. Wypisz ile łącznie zostało kupionej kawy Arabica w miesiącu styczniu

        Double numOfArabica = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase -> (purchase.getPurchaseDate().getMonthValue() == 1) && (purchase.getProduct().getName().contains("Arabica"))))
                .map(Company::getPurchaseList)
                .flatMap(Collection::stream)
                .map(Purchase::getQuantity)
                .reduce(Double.valueOf(0), (sum, quantity) -> sum + quantity);

        System.out.println(numOfArabica);

// 17. Wypisz ile łącznie kawy (Arabica i Roubsta) zostało kupionej w dni parzyste.

        Double numOfArabicaRobustaBoughtOnEvenDays = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase -> (purchase.getPurchaseDate().getDayOfMonth() % 2 == 0) &&
                                ((purchase.getProduct().getName().contains("Arabica")) || (purchase.getProduct().getName().contains("Robusta")))))
                .map(Company::getPurchaseList)
                .flatMap(Collection::stream)
                .map(Purchase::getQuantity)
                .reduce(Double.valueOf(0), (sum, quantity) -> sum + quantity);

        System.out.println(numOfArabicaRobustaBoughtOnEvenDays);

// 18. Zwróć Mapę (Map<Product, Set<Company>>) w której kluczem jest typ kawy (powinny być dwie, Arabica i Robusta) i wartością są listy firm które kupiły podaną kawę chociaż raz.

        Map<Product, Set<String>> coffeeAndCompanyBuyingIt = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase -> purchase.getProduct().getName().contains("Coffee")))
                .flatMap(company -> company.getPurchaseList().stream()
                        .filter(purchase -> purchase.getProduct().getName().contains("Coffee"))
                        .map(purchase -> Map.entry(purchase.getProduct(), company.getName())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));

        System.out.println(coffeeAndCompanyBuyingIt);

// 19. Zwróć firmę która w styczniu kupiła najwięcej paliwa (ropy)

        Optional<Company> companyBuyingMaxOil = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase -> purchase.getProduct().getName().contains("oil")))
                .max(Comparator.comparingDouble(company -> company.getPurchaseList().stream()
                        .filter(purchase -> purchase.getProduct().getName().contains("oil"))
                        .mapToDouble(purchase -> purchase.getQuantity())
                        .sum()));

        if (companyBuyingMaxOil.isPresent()) {
            System.out.println(companyBuyingMaxCoffee);
        } else {
            System.out.println("No company buys oil");
        }

// 20. Zwróć firmę której proporcja wydanych pieniędzy do ilości pracowników jest najwyższa

        Optional<Company> maxMoneyWithRegardToNumOfEmpls = companies.stream()
                .max(Comparator.comparingDouble((company -> company.getPurchaseList().stream()
                        .mapToDouble(purchase -> (purchase.getQuantity() * purchase.getProduct().getPrice()))
                        .sum() / company.getEmployees())));

        System.out.println(maxMoneyWithRegardToNumOfEmpls);


// 21. Zwróć firme która najwięcej wydaje na artykuły biurowe

        Optional<Company> maxSpentOnOfficeSupplies = companies.stream()
                .filter(company -> company.getPurchaseList().stream()
                        .anyMatch(purchase ->
                                (purchase.getProduct().getName().equals("Pen")) ||
                                        (purchase.getProduct().getName().equals("Pencil")) ||
                                        (purchase.getProduct().getName().equals("Clip")) ||
                                        (purchase.getProduct().getName().equals("Puncher")) ||
                                        (purchase.getProduct().getName().equals("Paper")) ||
                                        (purchase.getProduct().getName().equals("Scissors"))))
                .max(Comparator.comparingDouble(company -> company.getPurchaseList().stream()
                        .filter(purchase -> purchase.getProduct().getName().equals("Pen") ||
                                (purchase.getProduct().getName().equals("Pencil")) ||
                                (purchase.getProduct().getName().equals("Clip")) ||
                                (purchase.getProduct().getName().equals("Puncher")) ||
                                (purchase.getProduct().getName().equals("Paper")) ||
                                (purchase.getProduct().getName().equals("Scissors")))
                        .map(purchase -> (purchase.getQuantity() * purchase.getProduct().getPrice()))
                        .reduce(Double.valueOf(0), (sum, expense) -> sum + expense)));

        if (maxSpentOnOfficeSupplies.isPresent()) {
            System.out.println(maxSpentOnOfficeSupplies);
        } else {
            System.out.println("No company buys office supplies");
        }

    }
}
