package classesInterfaces.ex3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String name;
    private String type;

    @Getter
    class Engine {

        private String engineType;

        public void setEngineType() {
            if (type.equals("economy")) {
                engineType = "diesel";
            } else if (type.equals("luxury")) {
                engineType = "electric";
            } else {
                engineType = "petrol";
            }
        }
    }
}
