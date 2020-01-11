package pl.sdacademy.prog.strategy;

public class ConversionStrategyProvider {
    public TextConversionStrategy getStrategy(final ConversionType type) {
        switch (type){
            case CAMEL_CASE:
                return CamelCaseTextConversionStrategy.getInstance();
            case KEBAB_CASE:
                return KebabCaseTextConversionStrategy.getInstance();
            case COMPRESSION:
                return CompressionTextConversionStrategy.getInstance();
            default:
                return NoOpTextConversionStrategy.INSTANCE;
        }
    }
}
