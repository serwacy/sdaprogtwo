package pl.sdacademy.prog.strategy;

public abstract class TextConversionStrategyTemplate implements TextConversionStrategy {
    @Override
    public String modify(final String textToModify) {
        final StringBuilder outputBuilder = new StringBuilder(textToModify.length());
        boolean shouldApplyActionBeforeNextWord = false;
        for(final Character character : textToModify.trim().toCharArray()){
            if (Character.isLetterOrDigit(character) || character == '\n'){
                shouldApplyActionBeforeNextWord =
                        handleAlphanumericChar(character, shouldApplyActionBeforeNextWord, outputBuilder);
            } else {
                shouldApplyActionBeforeNextWord = handleNonAlphanumericChar(character, outputBuilder);
            }
        }
        return outputBuilder.toString();
    }
    protected boolean handleAlphanumericChar (final char character, final boolean shouldApplyActionBeforeNextWord,
                                              final StringBuilder builder){
        if(shouldApplyActionBeforeNextWord){
            builder.append(Character.toUpperCase(character));
        } else {
            builder.append(character);
        }
        return false;
    }
    protected abstract boolean handleNonAlphanumericChar (final char character, final StringBuilder builder);
}
