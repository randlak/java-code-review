import java.util.List;
import java.util.Objects;

public class TimeSeries2 {
    private List<Value> values;
    private boolean hasBeenMultiplied;
    private Double multiplicationFactor;

    public void multiplyValues() {
        if (!shouldMultiplyValues()) {
            return;
        }

        for (Value value : values) {
            if (value == null) {
                continue;
            }
            value.setValue(value.getValue() * multiplicationFactor);
        }
        hasBeenMultiplied = true;

        //or

        values.stream()
                .filter(Objects::nonNull)
                .forEach(value -> value.setValue(value.getValue() * multiplicationFactor));
        hasBeenMultiplied = true;
    }

    //values cannot be multiplied if they have already been multiplied or multiplication factor is missing
    private boolean shouldMultiplyValues() {
        if (hasBeenMultiplied) {
            return false;
        }
        if (multiplicationFactor == null) {
            return false;
        }
        return values != null;
    }
}
