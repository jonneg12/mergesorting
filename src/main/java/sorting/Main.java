package sorting;

import algorithm.SortSettings;
import algorithm.Sorting;
import cli.CommandLineConverter;
import cli.CommandLineProcessor;

public class Main {

    public static void main(String[] args) {

        CommandLineProcessor processor = new CommandLineProcessor(args);
        CommandLineConverter converter = new CommandLineConverter(processor.process());
        SortSettings settings = converter.convert();
        new Sorting(settings).sort();
    }
}
