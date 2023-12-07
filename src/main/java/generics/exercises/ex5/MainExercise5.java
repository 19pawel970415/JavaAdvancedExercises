package generics.exercises.ex5;

public class MainExercise5 {


    public static void main(String[] args) {

        //Zadanie 5
        //Zaprojektuj klasę, która będzie zachowywać się jak dom dla zwierząt:
        //kot
        //pies
        //Zaproponuj rozwiązanie w oparciu o typy generyczne. W celu przechowywania
        //danych skorzystaj z tablic, bądź dowolnego API służącego do przechowywania
        //danych.

        Dog dog1 = new Dog("Buddy", "Golden Retriever");
        Dog dog2 = new Dog("Max", "Labrador");

        Cat cat1 = new Cat("Whiskers", "Siamese");
        Cat cat2 = new Cat("Mittens", "Persian");

        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.addElement(dog1);
        animalRepository.addElement(dog2);
        animalRepository.addElement(cat1);
        animalRepository.addElement(cat2);

        System.out.println("Animals in the repository:");
        animalRepository.getElements().forEach(System.out::println);

        animalRepository.removeElement(dog1);

        System.out.println("\nAnimals in the repository after removal:");
        animalRepository.getElements().forEach(System.out::println);
    }

}
