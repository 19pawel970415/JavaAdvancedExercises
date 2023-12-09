package threads.exercises.ex5;

import java.util.concurrent.atomic.AtomicInteger;

public class Iterator<T> {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private T[] array;

    public Iterator(T[] array) {
        this.array = array;
    }

    public T next() {
        if (array.length > atomicInteger.get()) {
            return array[atomicInteger.getAndIncrement()];
        }
        throw new IllegalArgumentException("Over the range");
    }

    public T prev() {
        if (array.length > atomicInteger.get() && atomicInteger.get() > 0) {
            return array[atomicInteger.getAndDecrement()];
        }
        throw new IllegalArgumentException("Below the range");
    }
}
