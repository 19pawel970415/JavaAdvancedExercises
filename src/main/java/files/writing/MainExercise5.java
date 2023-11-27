package files.writing;

public class MainExercise5 {

    public static void main(String[] args) {

//5.  Stwórz klasę formularz. Formularz reprezentuje odpowiedzi których udzielił użytkownik.
//    Aplikacja ma po uruchomieniu rozpocząć od zadawania pytań użytkownikowi. Po wpisaniu
//    danych(odpowiedzi na pytania) zapisz te odpowiedzi do pliku (output_form.txt) w
//    odpowiednim formacie (przez format mamy na myśli zawartość - np. oddziel pytania i
//            odpowiedzi tak, aby byly pisane w nowych liniach). Poproś użytkownika o: wiek, wzrost, płeć
//            (kobieta/mezczyzna), zarobki i zadaj dwa dodatkowe pytania. Po czynności zamknij plik i
//            program


        Form form = new Form();
        form.askQs();
        form.askQs();

    }

}
