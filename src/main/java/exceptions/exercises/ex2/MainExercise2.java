package exceptions.exercises.ex2;

public class MainExercise2 {

    public static void main(String[] args) {

        //Klasa BookRepository
        //Zaimplementuj klasę BookRepository , która będzie odpowiedzialna za:
        //dodawanie obiektów typu Book
        //usuwanie obiektów typu Book
        //wyszukiwanie obiektów typu Book o wskazanej nazwie
        //wyszukiwanie obiektu typu Book o wskazanym id
        //usuwanie obiektów typu Book na podstawie przekazanego id
        //Klasa Book
        //Klasa Book powinna zawierać poniższe pola:
        //isbn
        //tytuł
        //autor
        //rok wydania
        //NoBookFoundException
        // W przypadku braku jakichkolwiek rezultatów wyszukiwania, powinien zostać
        //wyrzucony wyjątek: NoBookFoundException . Wyjątek ten powinien być
        //własnoręcznie zaimplementowanym wyjątkiem, przyjmujący jako parametr
        //konstruktora obiekt typu String z informacją jakich elementów nie udało się
        //odszukać.

        Book book1 = new Book("123456789", "Java Programming", "John Doe", "2022");
        Book book2 = new Book("987654321", "Python Basics", "Jane Smith", "2021");
        Book book3 = new Book("111222333", "C# Essentials", "Bob Johnson", "2023");

        BookRepository bookRepository = new BookRepository();

        bookRepository.addBook(book1);
        bookRepository.addBook(book2);
        bookRepository.addBook(book3);

        try {
            Book foundBookByTitle = bookRepository.findBookByTitle("Java Programming");
            System.out.println("Found book by title: " + foundBookByTitle.getTitle());
        } catch (NoBookFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Book foundBookByIsbn = bookRepository.findBookByIsbn("987654321");
            System.out.println("Found book by ISBN: " + foundBookByIsbn.getTitle());
        } catch (NoBookFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bookRepository.removeBookByIsbn("111222333");
            System.out.println("Book with ISBN 111222333 removed.");
        } catch (NoBookFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bookRepository.findBookByIsbn("111222333");
        } catch (NoBookFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
