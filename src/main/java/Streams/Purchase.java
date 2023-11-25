package Streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Purchase {
    private Product product;
    private LocalDate purchaseDate;
    private double quantity;
    private UNIT unit;
}

