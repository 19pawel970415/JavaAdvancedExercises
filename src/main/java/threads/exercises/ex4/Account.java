package threads.exercises.ex4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Account {

    private float balance;

    public synchronized void transferIn(float amount) {
        balance += amount;
        System.out.println("Transfer in confirmed");
        notify();
    }

    public synchronized void transferOut(float amount) {
        while (amount > balance) {
            System.out.println("Not enough money!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Transfer out confirmed");
    }

}
