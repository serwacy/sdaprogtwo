package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompressionTextConversionStrategy extends TextConversionStrategyTemplate{
    private static CompressionTextConversionStrategy instance;
    public static CompressionTextConversionStrategy getInstance(){
        if(isNull(instance)){
            instance = new CompressionTextConversionStrategy();
        }
        return instance;
    }
    @Override
    protected boolean handleNonAlphanumericChar(final char character, final StringBuilder builder) {
        return true;
    }
}
