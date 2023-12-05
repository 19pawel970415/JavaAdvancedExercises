package collections.exercises.ex1;

public class MainExercsie1 {

    public static void main(String[] args) {

        //Zaimplementuj klasę MyArrayList<T> , która będzie implementować logikę
        //ArrayList<T> . W tym celu zaimplementuj obsługę metod:
        //add
        //remove
        //get
        //display

        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);

        System.out.println("Initial List:");
        myList.display();

        int retrievedElement = myList.get(2);
        System.out.println("\nRetrieved element at index 2: " + retrievedElement);

        int removedElement = myList.remove(3);
        System.out.println("\nRemoved element at index 3: " + removedElement);
        System.out.println("List after removal:");
        myList.display();

        myList.add(60);
        System.out.println("\nList after adding a new element:");
        myList.display();
    }

}
