package threads.exercises.ex4;

public class MainExercise4 {

    public static void main(String[] args) {

        //Zadanie 4
        //Napisz aplikację, która będzie synchronizować dostęp do rachunku bankowego.
        //W przypadku, gdy dowolna cykliczna usługa internetowa będzie chciała obciążyć
        //rachunek kwotą wyższą niż aktualnie dostępna, powinno nastąpić wstrzymanie
        //wątku. W momencie, gdy na rachunek zostaną przelane dodatkowe środki,
        //powinno nastąpić wzbudzenie wątku.

        Account account = new Account(1000);

        Thread withdrawalThread = new Thread(() -> {
            float withdrawalAmount = 1200;
            account.transferOut(withdrawalAmount);
        });

        Thread depositThread = new Thread(() -> {
            float depositAmount = 500;
            account.transferIn(depositAmount);
        });

        withdrawalThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        depositThread.start();

        try {
            withdrawalThread.join();
            depositThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
