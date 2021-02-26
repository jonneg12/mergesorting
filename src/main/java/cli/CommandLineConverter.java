package cli;

import algorithm.SortSettings;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommandLineConverter {
    private static final int MIN_NUMBER_OF_FILE_PARAMETERS = 2;
    private CommandLineArguments arguments;

    public CommandLineConverter(CommandLineArguments arguments) {
        this.arguments = arguments;
    }

    public SortSettings convert() {
        SortSettings settings = new SortSettings();
        try {
            settings.setAscending(isAscendingExtract(arguments));
            settings.setString(isStringExtract(arguments));
            settings.setOutputFileName(outputFileExtract(arguments));
            settings.setInputFileNames(inputFilesExtract(arguments));
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return settings;
    }

    private List<String> inputFilesExtract(CommandLineArguments arguments) throws IllegalArgumentException {
        List<String> fileNames = arguments.getFileNames();
        String filePath = arguments.getFilePath();

        for (String fileName : fileNames.subList(1, fileNames.size())) {
            File inputFile = new File(filePath, fileName);

            if (!inputFile.exists() || !inputFile.canRead()) {
                throw new IllegalArgumentException("Input file " + inputFile + " does not exist or can not be read");
            }
        }
        return fileNames.subList(1, fileNames.size());
    }

    private String outputFileExtract(CommandLineArguments arguments) throws IllegalArgumentException, IOException {
        List<String> fileNames = arguments.getFileNames();
        String filePath = arguments.getFilePath();

        if (fileNames.size() < MIN_NUMBER_OF_FILE_PARAMETERS) {
            throw new IllegalArgumentException("Too few files");
        }

        String outputFileName = fileNames.get(0);
        File outputFile = new File(filePath, outputFileName);

        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        if (!outputFile.canWrite()) {
            throw new IllegalArgumentException("Can not modify file " + outputFileName + ". Permission denied");
        }
        return outputFileName;
    }

    private boolean isStringExtract(CommandLineArguments arguments) throws IllegalArgumentException {
        if (arguments.isString() && arguments.isInteger()
                || !arguments.isString() && !arguments.isInteger()) {
            throw new IllegalArgumentException("Ambiguous data format parameter. Require one flag -s or -i");
        } else {
            return arguments.isString();
        }
    }

    private boolean isAscendingExtract(CommandLineArguments arguments) throws IllegalArgumentException {
        if (arguments.isAscending() && arguments.isDescending()) {
            throw new IllegalArgumentException("Ambiguous sort order parameters");
        } else if (!arguments.isAscending() && !arguments.isDescending()) {
            return true;
        }
        return arguments.isAscending();
    }


}
