package collections;

import static collections.Lottery.play;

public class MainExercise3 {

    public static void main(String[] args) {

        //Napisz program do losowania gry w lotto przy pomocy Seta
        //1. Utwórz Klasę LottoGra
        //2. Dodaj metodę zagraj():void, która najpierw odpyta użytkownika o 6 liczb w zakresie 1-49
        //i zapisze wynik w postaci Setu
        //3. Następnie wywoła metodę prywatną
        //przeprowadzLosowanie():Set<Integer>, która zwróci 6 losowo
        //wybranych liczb
        //4. Ostatecznie prześle oba sety do metody zwrocWynik(Set, Set):int
        //która przekaże ilość trafionych liczb
        //5. Na koniec wydrukuje wiadomość podsumowującą tj.
        //jakie liczby obstawił użytkownik a jakie wygenerował komputer
        //oraz liczbę trafień użytkownika

        play();


    }

}
