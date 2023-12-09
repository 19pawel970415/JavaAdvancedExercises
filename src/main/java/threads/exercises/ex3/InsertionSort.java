package threads.exercises.ex3;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class InsertionSort implements Callable<String> {

    private Integer[] integers;

    public void insertionSort(){

        int n = integers.length;

        for (int i = 1; i < n; i++) {
            int key = integers[i];
            int j = i - 1;

            while (j >= 0 && integers[j] > key) {
                integers[j + 1] = integers[j];
                j = j - 1;
            }
            integers[j + 1] = key;
        }

    }

    @Override
    public String call() throws Exception {
        insertionSort();
        return "Insertion sort!";
    }
}
