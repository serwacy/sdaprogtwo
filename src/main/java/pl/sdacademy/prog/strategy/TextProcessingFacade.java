package pl.sdacademy.prog.strategy;

public class TextProcessingFacade {
    private final CustomCommandLineParser commandLineParser;
    private final FileContentProvider contentProvider;
    private final ConversionStrategyProvider strategyProvider;

    public TextProcessingFacade(final CustomCommandLineParser commandLineParser,
                                final FileContentProvider contentProvider,
                                final ConversionStrategyProvider strategyProvider) {
        this.commandLineParser = commandLineParser;
        this.contentProvider = contentProvider;
        this.strategyProvider = strategyProvider;
    }

    public void process (final String[] args){
        commandLineParser.parse(args);
        final String content =
                contentProvider.readContent(commandLineParser.getFilePathArgValue());
        final TextConversionStrategy conversionStrategy =
                strategyProvider.getStrategy(commandLineParser.getConversionTypeArgValue());
        System.out.println(conversionStrategy.modify(content));
    }
}
