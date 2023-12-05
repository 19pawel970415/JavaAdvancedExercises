package enums.ex3;

import java.util.Arrays;
import java.util.Optional;

public enum TemperatureConvert {

    C_F('C', 'F', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = (tempIn * 9 / 5) + 32;
            return result;
        }
    }),
    C_K('C', 'K', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = tempIn + 273.15f;
            return result;
        }
    }),
    K_C('K', 'C', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = tempIn - 273.15f;
            return result;
        }
    }),
    F_C('F', 'C', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = (tempIn - 32) * 5 / 9;
            return result;
        }
    }),
    F_K('F', 'K', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = (tempIn - 32) * 5 / 9 + 273.15f;
            return result;
        }
    }),
    K_F('K', 'F', new Converter() {
        @Override
        public float convert(float tempIn) {
            float result = (tempIn + 273.15f) * 9 / 5 + 32;
            return result;
        }
    });

    private Character inTemperatureUnit;
    private Character outTemperatureUnit;
    private Converter converter;

    TemperatureConvert(Character inTempUnit, Character outTempUnit, Converter converter) {
        this.inTemperatureUnit = inTempUnit;
        this.outTemperatureUnit = outTempUnit;
        this.converter = converter;
    }

    static float convertTemperature(Character inTempUnit, Character outTempUnit, float temperature) {
        Optional<TemperatureConvert> matchingEnumField = Arrays.stream(TemperatureConvert.values())
                .filter(c -> c.inTemperatureUnit.equals(inTempUnit) && c.outTemperatureUnit.equals(outTempUnit))
                .findAny();

        if (matchingEnumField.isPresent()) {
            float convertedTemp = matchingEnumField.get().converter.convert(temperature);
            return convertedTemp;
        } else {
            System.err.println("The conversion not supported");
            return 0f;
        }
    }
}
