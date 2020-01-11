package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CamelCaseTextConversionStrategy extends TextConversionStrategyTemplate {
    private static final CamelCaseTextConversionStrategy INSTANCE = new CamelCaseTextConversionStrategy();
    public static CamelCaseTextConversionStrategy getInstance(){
        return INSTANCE;
    }

    @Override
    protected boolean handleNonAlphanumericChar(final char character, final StringBuilder builder) {
        if (!Character.isWhitespace(character)){
            builder.append(character);
        }
        return true;
    }
}
