package exceptions;

public class DivideByZeroException extends RuntimeException {
    public DivideByZeroException() {
        super("Do not divide by 0!!!!!!");
    }
}
