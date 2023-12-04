package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Shoe shoeLeft = new Shoe();
        Shoe shoeRight = new Shoe();
        Container<Shoe> shoes = new Container<>(shoeLeft, shoeRight);

        shoes.getLeft().setColour("Black");
        shoes.getRight().setColour("Black");
        shoes.getLeft().setSize(45);
        shoes.getRight().setSize(45);

        List<Container> listOfShoes = new ArrayList<>();
        listOfShoes.add(shoes);

        for (Container s : listOfShoes) {
            System.out.println(s.getRight().toString() + " " + s.getLeft().toString());
        }

        String result = (isShoe(shoeLeft) && isShoe(shoeRight)) ? "It's a pair of shoes" : "It's not a pair of shoes";
        System.out.println(result);
    }

    public static <T> boolean isShoe(T object) {
        return object.getClass() == Shoe.class;
    }
}
