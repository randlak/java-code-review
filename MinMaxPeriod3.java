import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxPeriod3 {
    private Double minValue;
    private Double maxValue;

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public static List<MinMaxPeriod3> removeEmptyPeriods(List<MinMaxPeriod3> minMaxPeriods) {
        List<MinMaxPeriod3> resultPeriods = new ArrayList<>();

        for (MinMaxPeriod3 minMaxPeriod : minMaxPeriods) {
            if (minMaxPeriod.getMaxValue() == null) {
                continue;
            }
            if (minMaxPeriod.getMinValue() == null) {
                continue;
            }
            resultPeriods.add(minMaxPeriod);
        }

        //or

        resultPeriods = minMaxPeriods.stream()
                .filter(minMaxPeriod -> minMaxPeriod.getMinValue() != null && minMaxPeriod.getMaxValue() != null)
                .collect(Collectors.toList());

        return resultPeriods;
    }
}
