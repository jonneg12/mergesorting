package algorithm;

import java.util.Map;

public class SortingStrings extends SortingAlgorithm {

    public SortingStrings(boolean isAscending) {
        super(isAscending);
    }

    @Override
    protected Map.Entry<String, String> getPeak(Map<String, String> elements) {
        if (isAscending) {
            return elements
                    .entrySet()
                    .stream()
                    .min(Map.Entry.comparingByValue())
                    .get();
        } else {
            return elements
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get();
        }
    }

    @Override
    protected boolean isElementsOrdered(String tempLine, String tempPeak) {
        int compare = tempLine.compareTo(tempPeak);
        if (isAscending) {
            return compare >= 0;
        } else {
            return compare <= 0;
        }
    }

}
