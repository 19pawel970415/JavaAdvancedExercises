package generics.exercises.ex4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repository<T> {

    private List<T> elements = new ArrayList<T>();

    public void addElement(T element) {
        elements.add(element);
    }

    public void removeElement(T element) {
        elements.remove(element);
    }

}
