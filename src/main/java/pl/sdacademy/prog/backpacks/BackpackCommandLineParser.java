package pl.sdacademy.prog.backpacks;

import org.apache.commons.cli.*;
import pl.sdacademy.prog.stra.GenericException;

public class BackpackCommandLineParser {
    private static final String BACKPACK_ARG_NAME = "n";
    private static final String INPUT_FILE_ARG_NAME = "f";
    private static final String OUTPUT_DIR_ARG_NAME = "o";
    private static final char SEPARATOR = '=';

    private CommandLine commandLine;

    public void parse (final String[] args) {
        final CommandLineParser commandLineParser = new DefaultParser();
        try {
            commandLine = commandLineParser.parse(createOptions(), args);
        } catch (final ParseException exp) {
            throw new GenericException("Could not parse command line. " + exp.getMessage(), exp);
        }
    }
    public Integer getBackpacksArgValue () {
        return Integer.parseInt(commandLine.getOptionValue(BACKPACK_ARG_NAME));
    }
    public String getInputFileArgNameValue () {
        return commandLine.getOptionValue(INPUT_FILE_ARG_NAME);
    }
    public String getOutputDirArgNameValue () {
        return commandLine.getOptionValue(OUTPUT_DIR_ARG_NAME);
    }
    private Options createOptions() {
        return new Options()
                .addOption(createBackpackNumOption())
                .addOption(createInputFileOption())
                .addOption(createOutputDirectoryOption());
    }
    private Option createMandatoryOptionArgument (final String argName) {
        return Option.builder()
                .hasArg()
                .argName(argName)
                .longOpt(argName)
                .valueSeparator(SEPARATOR)
                .required()
                .build();
    }
    private Option createBackpackNumOption (){
        return createMandatoryOptionArgument(BACKPACK_ARG_NAME);
    }
    private Option createInputFileOption (){
        return createMandatoryOptionArgument(INPUT_FILE_ARG_NAME);
    }
    private Option createOutputDirectoryOption (){
        return createMandatoryOptionArgument(OUTPUT_DIR_ARG_NAME);
    }
}
