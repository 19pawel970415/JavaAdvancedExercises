package generics.exercises.ex5;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Animal {

    private String name;
    private String breed;

}
