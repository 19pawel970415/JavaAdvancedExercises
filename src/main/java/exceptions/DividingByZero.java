package exceptions;

public class DividingByZero {

    public static void main(String[] args) {

        try {
            double div = div(1, 0);
        } catch (ArithmeticException ae) {
            System.out.println("No dividing by 0 permitted!!!!");
        }

        div(1d, 0d);

        div(1f, 0f);

        try {
            doOneThing();
        } catch (CheckedEx checkedEx) {
            checkedEx.printStackTrace();
        }

        doOtherThing();
    }

    public static double div(int a, int b) {
        return a / b;
    }

    public static double div(double a, double b) {
        if (b == 0d) {
            System.err.println("No dividing by 0 permitted!!!!");
            return 0;
        } else {
            return a / b;
        }
    }

    public static double div(float a, float b) {
        if (b == 0f) {
            throw new DivideByZeroException();
        } else {
            return a / b;
        }
    }

    public static void doOneThing() throws CheckedEx {
        throw new CheckedEx("Checked exception thrown");
    }

    public static void doOtherThing() {
        throw new UncheckedEx("Unchecked exception thrown");
    }
}
