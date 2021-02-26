package algorithm;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Sorting {
    private SortingAlgorithm sortingAlgorithm;
    private final boolean isString;
    protected Map<String, BufferedReader> readers = new HashMap<>();
    protected BufferedWriter writer;

    public Sorting(SortSettings settings) {
        this.isString = settings.isString();

        if (this.isString) {
            this.sortingAlgorithm = new SortingStrings(settings.isAscending());
        } else {
            this.sortingAlgorithm = new SortingNumbers(settings.isAscending());
        }

        for (String fileName : settings.getInputFileNames()) {
            readers.put(fileName, createReader(fileName));
        }

        try {
            this.writer = new BufferedWriter(new FileWriter(settings.getOutputFileName()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void sort() {
        Map<String, String> elements = initialize();
        while (elements.size() != 0) {
            Map.Entry<String, String> peak = sortingAlgorithm.getPeak(elements);
            processPeak(peak, elements);
            sortingAlgorithm.getNextElement(peak, elements, readers);
        }
        close();
    }

    private Map<String, String> initialize() {
        Map<String, String> elements = new HashMap<>();
        for (Map.Entry<String, BufferedReader> reader : readers.entrySet()) {
            String line = sortingAlgorithm.getNextLine(reader.getValue());
            elements.put(reader.getKey(), line);
        }
        return elements;
    }

    protected void processPeak(Map.Entry<String, String> peak, Map<String, String> elements) {
        String peakLine = peak.getValue();
        String peakFileName = peak.getKey();
        writeToFile(peakLine);
        elements.remove(peakFileName);
    }

    protected void writeToFile(String line) {
        try {
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private BufferedReader createReader(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return reader;
    }

    private void close() {
        closeReaders();
        closeWriter();
    }

    private void closeReaders() {
        for (BufferedReader reader : readers.values()) {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    private void closeWriter() {
        try {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
