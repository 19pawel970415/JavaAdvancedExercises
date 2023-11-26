package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cityHeadquarters;
    private int employees;
    private List<Purchase> purchaseList;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", cityHeadquarters='" + cityHeadquarters + '\'' +
                ", employees=" + employees +
                '}';
    }
}
