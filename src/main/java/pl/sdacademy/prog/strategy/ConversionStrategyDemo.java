package pl.sdacademy.prog.strategy;

public class ConversionStrategyDemo {
    public static void main(String[] args){
        final FileContentProvider fileContentProvider = new FileContentProvider();
        final CustomCommandLineParser parser = new CustomCommandLineParser();
        final ConversionStrategyProvider strategyProvider = new ConversionStrategyProvider();

        final TextProcessingFacade facade = new TextProcessingFacade(
                parser, fileContentProvider, strategyProvider);
        facade.process(args);
    }
}
