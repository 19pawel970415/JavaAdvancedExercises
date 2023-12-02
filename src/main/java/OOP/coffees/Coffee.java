package OOP.coffees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {

    private String name;
    private LocalDate brewingDate;
    private CoffeeType type;
    private CoffeeOrigin origin;

}
