package exceptions.exercises.ex1;

public class CannotDivideBy0Exception extends RuntimeException{
    public CannotDivideBy0Exception() {
        System.out.println("One cannot divide by 0!!!");
    }
}
