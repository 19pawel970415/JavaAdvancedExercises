package exceptions.exercises.ex1;

public class MainExercise1 {

    public static void main(String[] args) {

        //Zaimplementuj metodę divide , która docelowo ma podzielić dwie liczby
        //będące atrybutami metody. W przypadku, gdy drugi parametr metody jest równy
        //0, powinien zostać wyrzucony niedomyślny wyjątek:
        //CannotDivideBy0Exception .

        float x = 1f;
        float y = 0f;
        float z = 4f;
        float a = 2.4f;

        float divideResult = divide(z, a);
        System.out.println(divideResult);
        divide(x, y);

    }

    public static float divide(float x, float y) {
        if (y == 0) {
            throw new CannotDivideBy0Exception();
        } else {
            return x / y;
        }
    }

}
