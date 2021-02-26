package algorithm;

import java.util.List;
import java.util.Objects;

public class SortSettings {
    private boolean isAscending;
    private boolean isString;
    private List<String> inputFileNames;
    private String outputFileName;

    public SortSettings() {}

    public SortSettings(boolean isAscending, boolean isString, List<String> inputFileNames, String outputFileName) {
        this.isAscending = isAscending;
        this.isString = isString;
        this.inputFileNames = inputFileNames;
        this.outputFileName = outputFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortSettings settings = (SortSettings) o;
        return isAscending == settings.isAscending &&
                isString == settings.isString &&
                inputFileNames.equals(settings.inputFileNames) &&
                outputFileName.equals(settings.outputFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAscending, isString, inputFileNames, outputFileName);
    }

    public boolean isAscending() {
        return isAscending;
    }

    public void setAscending(boolean ascending) {
        isAscending = ascending;
    }

    public boolean isString() {
        return isString;
    }

    public void setString(boolean string) {
        isString = string;
    }

    public List<String> getInputFileNames() {
        return inputFileNames;
    }

    public void setInputFileNames(List<String> inputFileNames) {
        this.inputFileNames = inputFileNames;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public String toString() {
        return "SortSettings{" +
                "isAscending=" + isAscending +
                ", isString=" + isString +
                ", inputFileNames=" + inputFileNames +
                ", outputFileName='" + outputFileName + '\'' +
                '}';
    }
}
