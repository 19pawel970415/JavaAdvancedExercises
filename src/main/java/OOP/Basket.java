package OOP;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Basket {

    private Map<ProductInterface, AtomicInteger> products = new HashMap<>();

    public void addProduct(ProductInterface product, Integer number) {
        if (products.containsKey(product)) {
            products.get(product).getAndAdd(number);
        } else {
            products.put(product, new AtomicInteger(number));
        }
    }

    public void removeProduct(ProductInterface product, Integer number) {
        if (products.containsKey(product)) {
            products.get(product).getAndAdd(-number);
            if (products.get(product).get() <= 0) {
                products.remove(product);
            }
        }
    }

    public List<String> getAllProducts() {
        return new ArrayList<String>(Collections.singleton(products.keySet() + " : " + products.values()));
    }

}
