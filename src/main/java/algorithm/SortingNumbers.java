package algorithm;

import java.util.Comparator;
import java.util.Map;

public class SortingNumbers extends SortingAlgorithm {

    public SortingNumbers(boolean isAscending) {
        super(isAscending);
    }

    @Override
    protected Map.Entry<String, String> getPeak(Map<String, String> elements) {
        if (isAscending) {
            return elements.entrySet()
                    .stream()
                    .min(Comparator.comparingInt(x -> Integer.parseInt(x.getValue())))
                    .get();
        } else {
            return elements.entrySet()
                    .stream()
                    .max(Comparator.comparingInt(x -> Integer.parseInt(x.getValue())))
                    .get();
        }
    }

    @Override
    protected boolean isElementsOrdered(String tempLine, String tempPeak) {
        try {
            int intTempPeak = Integer.parseInt(tempPeak);
            int intTempLine = Integer.parseInt(tempLine);
            if (isAscending) {
                return intTempLine >= intTempPeak;
            } else {
                return intTempLine <= intTempPeak;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected boolean isValid(String line) {
        return super.isValid(line) && IsNumber(line);
    }

    private boolean IsNumber(String line){
        try {
            Integer.parseInt(line);
        }   catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
