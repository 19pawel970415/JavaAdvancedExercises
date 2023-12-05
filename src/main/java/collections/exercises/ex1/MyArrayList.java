package collections.exercises.ex1;


import java.util.Arrays;

public class MyArrayList<T> {

    private static final int INITIAL_SIZE = 5;
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[INITIAL_SIZE];
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return (T) elements[index];
    }

    public void add(T element) {
        if (size == this.elements.length) {
            increaseArraySize();
        }
        this.elements[size++] = element;
    }

    public void increaseArraySize() {
        elements = Arrays.copyOf(elements, elements.length - 1);
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Object removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        decreaseArraySize();
        return (T) removedElement;
    }

    public void decreaseArraySize() {
        elements = Arrays.copyOf(elements, elements.length - 1);
    }

    public void display() {
        for (Object element : elements) {
            System.out.println(element);
        }
    }

}
