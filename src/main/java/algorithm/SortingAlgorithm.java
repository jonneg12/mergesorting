package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public abstract class SortingAlgorithm {
    protected boolean isAscending;

    public SortingAlgorithm(boolean isAscending) {
        this.isAscending = isAscending;
    }

    protected abstract Map.Entry<String, String> getPeak(Map<String, String> elements);

    protected abstract boolean isElementsOrdered(String tempLine, String tempPeak);

    protected boolean isValid(String line) {
        return !line.isEmpty();
    }

    protected String getNextLine(BufferedReader reader) {
        String line = null;
        try {
            do {
                line = reader.readLine();
                if (line == null) {
                    return null;
                }
            } while (!isValid(line.trim()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return line.trim();
    }

    protected void getNextElement(Map.Entry<String, String> peak, Map<String, String> elements,
                                  Map<String, BufferedReader> readers) {
        String line;
        do {
            line = getNextLine(readers.get(peak.getKey()));
            if (line == null) {
                return;
            }
        } while (!isElementsOrdered(line, peak.getValue()));

        elements.put(peak.getKey(), line);
    }
}
