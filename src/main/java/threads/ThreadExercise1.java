package threads;

public class ThreadExercise1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            System.out.println("Juhuuuu!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
