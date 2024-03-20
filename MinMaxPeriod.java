import java.util.ArrayList;
import java.util.List;

public class MinMaxPeriod {
    private String minValue;
    private String maxValue;

    public String getMinValue() {
        return minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public static List<MinMaxPeriod> cleanEmptyPeriods(List<MinMaxPeriod> minMaxPeriods) {
        List<MinMaxPeriod> cleanedMinMaxPeriod = new ArrayList<>();

        for (MinMaxPeriod minMaxPeriod : minMaxPeriods) {
            if ((!minMaxPeriod.getMinValue().equals("") && !minMaxPeriod.getMinValue().equals(" ") && !minMaxPeriod.getMinValue().equals("0")) ||
                    (!minMaxPeriod.getMaxValue().equals("") && !minMaxPeriod.getMaxValue().equals(" ") && !minMaxPeriod.getMaxValue().equals("0"))) {
                cleanedMinMaxPeriod.add(minMaxPeriod);
            }
        }
        return cleanedMinMaxPeriod;
    }
}