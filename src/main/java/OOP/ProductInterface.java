package OOP;

import java.time.LocalDate;

public interface ProductInterface {

    double getPrice();

    boolean checkIfInStock(LocalDate date);

}
