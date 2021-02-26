package cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLinePattern {
    private Options options;

    public CommandLinePattern() {
        Options options = new Options();
        Option asc = new Option("a", "ascending sorting");
        Option desc = new Option("d", "descending sorting");
        Option stringContent = new Option("s", "string sorting mode");
        Option intContent = new Option("i", "integer sorting mode");
        options.addOption(asc);
        options.addOption(desc);
        options.addOption(stringContent);
        options.addOption(intContent);
        this.options = options;
    }

    public Options getOptions() {
        return options;
    }
}
