package threads.exercises.ex3;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class BubbleSort implements Callable<String> {

    private Integer[] integers;

    public void bubbleSort(){

        int n = integers.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (integers[i - 1] > integers[i]) {
                    int temp = integers[i - 1];
                    integers[i - 1] = integers[i];
                    integers[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

    }

    @Override
    public String call() throws Exception {
        bubbleSort();
        return "Bubble sort!";
    }
}
