package pl.sdacademy.prog.strategy;

import org.apache.commons.cli.*;
import pl.sdacademy.prog.stra.GenericException;

public class CustomCommandLineParser {
    private static final String FILE_PATH_ARG_NAME = "f";
    private static final String CONVERSION_TYPE_ARG_NAME = "t";
    private static final char VALUE_SEPARATOR = '=';

    private CommandLine commandLine;

    public void parse(final String[] args){
        try {
            final CommandLineParser parser = new DefaultParser();
            commandLine = parser.parse(buildOptions(), args);
        } catch (final ParseException exp) {
            throw new GenericException("Could not parse arguments", exp);
        }
    }
    private Options buildOptions(){
        return new Options()
                .addOption(buildConversionTypeArgument())
                .addOption(buildFilePathArgument());
    }
    private Option buildFilePathArgument(){
        return Option.builder()
                .required()
                .hasArg()
                .longOpt(FILE_PATH_ARG_NAME)
                .argName(FILE_PATH_ARG_NAME)
                .valueSeparator(VALUE_SEPARATOR)
                .build();
    }
    private Option buildConversionTypeArgument(){
        return Option.builder()
                .required()
                .hasArg()
                .longOpt(CONVERSION_TYPE_ARG_NAME)
                .argName(CONVERSION_TYPE_ARG_NAME)
                .valueSeparator(VALUE_SEPARATOR)
                .type(ConversionType.class)
                .build();
    }
    public String getFilePathArgValue(){
        return commandLine.getOptionValue(FILE_PATH_ARG_NAME);
    }
    public ConversionType getConversionTypeArgValue(){
        return ConversionType.valueOf(commandLine.getOptionValue(CONVERSION_TYPE_ARG_NAME));
    }
}
