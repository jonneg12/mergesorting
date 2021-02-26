package cli;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class CommandLineArguments {
    private final boolean isAscending;
    private final boolean isDescending;
    private final boolean isString;
    private final boolean isInteger;
    private final List<String> fileNames;
    private final String filePath;

    public CommandLineArguments(boolean isAscending, boolean isDescending, boolean isString, boolean isInteger,
                                List<String> fileNames) {
        this.isAscending = isAscending;
        this.isDescending = isDescending;
        this.isString = isString;
        this.isInteger = isInteger;
        this.fileNames = fileNames;
        this.filePath = new File("").getAbsolutePath(); // filePath;
    }

    public boolean isString() {
        return isString;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public boolean isAscending() {
        return isAscending;
    }

    public boolean isDescending() {
        return isDescending;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandLineArguments arguments = (CommandLineArguments) o;
        return isAscending == arguments.isAscending
                && isDescending == arguments.isDescending
                && isString == arguments.isString
                && isInteger == arguments.isInteger
                && fileNames.equals(arguments.fileNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAscending, isDescending, isString, isInteger, fileNames);
    }
}
