package pl.sdacademy.prog.strategy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KebabCaseTextConversionStrategy extends TextConversionStrategyTemplate {
    private static KebabCaseTextConversionStrategy instance;
    public static KebabCaseTextConversionStrategy getInstance(){
        if(isNull(instance)){
            synchronized (KebabCaseTextConversionStrategy.class){
                if(isNull(instance)){
                    instance = new KebabCaseTextConversionStrategy();
                }
            }
        }
        return instance;
    }

    @Override
    protected boolean handleNonAlphanumericChar(final char character, final StringBuilder builder) {
        return true;
    }

    @Override
    protected boolean handleAlphanumericChar(final char character, final boolean shouldApplyActionBeforeNextWord,
                                             final StringBuilder builder) {
        if(shouldApplyActionBeforeNextWord) {
            builder.append('-');
        }
        builder.append(Character.toLowerCase(character));
        return false;
    }
}
