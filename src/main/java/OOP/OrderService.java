package OOP;

public class OrderService {

    public double calculatePrice(Basket basket) {
        return basket.getProducts().entrySet().stream()
                .mapToDouble(e -> (e.getKey().getPrice() * e.getValue().get()))
                .sum();
    }

}
