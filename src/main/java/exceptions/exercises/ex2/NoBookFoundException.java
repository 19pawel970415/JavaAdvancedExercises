package exceptions.exercises.ex2;

public class NoBookFoundException extends RuntimeException{

    public NoBookFoundException(String elementsNotFound) {
        super(elementsNotFound + " not found.");
    }
}
