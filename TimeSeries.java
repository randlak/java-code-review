import java.util.List;

public class TimeSeries {
    private List<Value> values;
    private boolean hasBeenMultiplied;
    private Double multiplicationFactor;

    public TimeSeries(List<Value> values, boolean hasBeenMultiplied, Double multiplicationFactor) {
        this.values = values;
        this.hasBeenMultiplied = hasBeenMultiplied;
        this.multiplicationFactor = multiplicationFactor;
    }

    public void multiplyValues() {
        if (multiplyValues() == true) {
            if (values != null) {
                for (Value value : values) {
                    if (value != null) {
                        value.setValue(value.getValue() * multiplicationFactor);
                    }
                }
                hasBeenMultiplied = true;
            }
        }
    }

    //values cannot be multiplied if they have already been multiplied or multiplication factor is missing
    private boolean multiplyValues() {
        return !(hasBeenMultiplied == true || multiplicationFactor == null);
    }
}

class Value {
    private double value;

    public Value(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}