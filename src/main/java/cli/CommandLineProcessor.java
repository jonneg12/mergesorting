package cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class CommandLineProcessor {
    private String[] args;
    private CommandLineParser parser;
    private CommandLinePattern pattern;

    public CommandLineProcessor(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Command line arguments are absent");
            }
            this.args = args;
            this.pattern = new CommandLinePattern();
            this.parser = new DefaultParser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public CommandLineArguments process() {
        CommandLine line = null;
        try {
            line = parser.parse(pattern.getOptions(), args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return new CommandLineArguments(
                line.hasOption('a'),
                line.hasOption('d'),
                line.hasOption('s'),
                line.hasOption('i'),
                line.getArgList()
        );
    }
}
