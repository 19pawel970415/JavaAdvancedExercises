package threads;

public class MainExercise1 {

    public static void main(String[] args) {

        //1. Stwórz aplikację, w niej uruchom wątek, którego zadaniem jest po 30 sekundach wypisać
        //komunikat "Juhuuuu!". Po tej czynności aplikacja ma się zamknąć.

        ThreadExercise1 threadExercise1 = new ThreadExercise1();
        Thread thread = new Thread(threadExercise1);
        thread.start();

    }

}
