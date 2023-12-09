package threads.exercises.ex2;

public class Bridge {

    public synchronized void driveThrough(Car car) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
