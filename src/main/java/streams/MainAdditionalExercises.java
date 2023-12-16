package streams;

import java.util.*;
import java.util.stream.Collectors;

public class MainAdditionalExercises {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        list.add(20);
        double averageFromList = getAverageFromList(list);
        System.out.println(averageFromList);

        List<String> listStrings = new ArrayList<String>();
        listStrings.add("hello");
        listStrings.add("Hi");
        listStrings.add("there");
        listStrings.add("what");
        listStrings.add("is");
        listStrings.add("your name?");
        List<String> upperCaseFromList = getUpperCaseFromList(listStrings);
        for (String s : upperCaseFromList) {
            System.out.println(s);
        }

        List<String> listStrings1 = new ArrayList<String>();
        listStrings1.add("hello");
        listStrings1.add("and");
        listStrings1.add("hi");
        listStrings1.add("how");
        listStrings1.add("do you");
        listStrings1.add("answer this question?");
        List<String> strings = getStartingWithSmallAAndThreeLettersLongList(listStrings1);
        for (String s : strings) {
            System.out.println(s);
        }

        String evenOddNumbersSeparatedString = getEvenOddNumbersSeparatedString(list);
        System.out.println(evenOddNumbersSeparatedString);

        //Utwórz klasę Employee z polami id, name oraz salary. Utwórz niezbędne metody i
        //konstruktor. Utwórz 3 instancje klasy Employee i dodaj je do listy. Korzystając ze
        //strumieni, znajdź pierwszego pracownika, który nie jest null i ma pensję co najmniej
        //30000. Jeśli nie zostanie znaleziony, rzuć wyjątek.

        Employee employee = new Employee(1, "Smith", 1000);
        Employee employee1 = new Employee(2, "Crane", 30000);
        Employee employee2 = new Employee(3, "Freeman", 1002);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);

        Employee employeeEarningAtLeast30000 = getEmployeeEarningAtLeast30000(employees);
        System.out.println(employeeEarningAtLeast30000);

        List<Employee> employeesSortedBySurname = getEmployeesSortedBySurname(employees);
        for (Employee emp : employeesSortedBySurname) {
            System.out.println(emp);
        }

        double employeesMaxSalary = getEmployeesMaxSalary(employees);
        System.out.println(employeesMaxSalary);

    }

    //Napisz metodę, która zwraca średnią z listy liczb całkowitych za pomocą strumieni

    public static double getAverageFromList(List<Integer> list) {
        OptionalDouble average = list.stream()
                .mapToDouble(i -> i.doubleValue())
                .average();

        if (average.isPresent()) {
            return average.getAsDouble();
        } else {
            System.out.println("The list is empty");
            return 0;
        }
    }

    //Napisz metodę, która konwertuje wszystkie ciągi z listy na wielkie litery za pomocą
    //strumieni.

    public static List<String> getUpperCaseFromList(List<String> list) {
        List<String> collectedList = list.stream()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());

        return collectedList;
    }

    //Mając listę stringów, napisz metodę, która zwraca listę wszystkich ciągów zaczynających
    //się na literę „a” (małe litery) i zawierających dokładnie 3 litery, użyj strumieni.

    public static List<String> getStartingWithSmallAAndThreeLettersLongList(List<String> list) {
        List<String> collectedList = list.stream()
                .filter(s -> (s.startsWith("a") && s.length() == 3))
                .collect(Collectors.toList());

        return collectedList;
    }

    //Napisz metodę, która zwraca łańcuch rozdzielany przecinkami na podstawie podanej
    //listy liczb całkowitych. Każdy element powinien być poprzedzony literą „e”, jeśli liczba
    //jest parzysta, i poprzedzona literą „o”, jeśli liczba jest nieparzysta. Na przykład, jeśli lista
    //danych wejściowych to (3,44), wynikiem powinno być „o3, e44”. Użyj strumieni.

    public static String getEvenOddNumbersSeparatedString(List<Integer> list) {
        String s = list.stream()
                .map(i -> (i % 2 == 0 ? ("e" + i) : ("o" + i)))
                .collect(Collectors.joining(","));
        return s;
    }

    public static Employee getEmployeeEarningAtLeast30000(List<Employee> employees) {
        Optional<Employee> first = employees.stream()
                .filter(e -> e.getSalary() >= 30000)
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        } else {
            throw new NoSuchElementException("No employee found");
        }
    }

    //Na podstawie listy pracowników z poprzedniego ćwiczenia za pomocą strumieni utwórz
    //nową listę z pracownikami posortowanymi według nazwisk
    public static List<Employee> getEmployeesSortedBySurname(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing((e -> e.getName())))
                .collect(Collectors.toList());
    }

    //Na podstawie listy pracowników z ćwiczenia 7, za pomocą strumieni zwróć liczbę
    //reprezentującą maksymalne wynagrodzenie wszystkich pracowników
    public static double getEmployeesMaxSalary(List<Employee> employees) {
        Optional<Double> aDouble = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(e -> e.getSalary());
        if (aDouble.isPresent()) {
            return aDouble.get();
        } else {
            throw new NoSuchElementException("No element found");
        }
    }
}
