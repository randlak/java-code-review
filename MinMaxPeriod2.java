import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxPeriod2 {
    private String minValue;
    private String maxValue;

    public String getMinValue() {
        return minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public static List<MinMaxPeriod2> removeEmptyPeriods(List<MinMaxPeriod2> minMaxPeriods) {
        List<MinMaxPeriod2> resultPeriods = new ArrayList<>();

        for (MinMaxPeriod2 minMaxPeriod : minMaxPeriods) {
            boolean isValidMinValue = isValidValue(minMaxPeriod.getMinValue());
            boolean isValidMaxValue = isValidValue(minMaxPeriod.getMaxValue());

            if (isValidMinValue && isValidMaxValue) {
                resultPeriods.add(minMaxPeriod);
            }
        }

        //or

        resultPeriods = minMaxPeriods.stream()
                .filter(minMaxPeriod -> isValidValue(minMaxPeriod.getMinValue()) && isValidValue(minMaxPeriod.getMaxValue()))
                .collect(Collectors.toList());

        return resultPeriods;
    }

    static boolean isValidValue(String value) {
        if (value == null) {
            return false;
        }

        switch (value.trim()) {
            case "":
            case "0":
                return false;
            default:
                return true;
        }
    }
}
