package OOP;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenericProduct implements ProductInterface {

    private final Supplier<Double> priceSupplier;
    private final Function<LocalDate, Boolean> purchaseDateFunction;

    public GenericProduct(Supplier<Double> priceSupplier, Function<LocalDate, Boolean> purchaseDateFunction) {
        this.priceSupplier = priceSupplier;
        this.purchaseDateFunction = purchaseDateFunction;
    }

    @Override
    public double getPrice() {
        return priceSupplier.get();
    }

    @Override
    public boolean checkIfInStock(LocalDate date) {
        return purchaseDateFunction.apply(date);
    }
}
