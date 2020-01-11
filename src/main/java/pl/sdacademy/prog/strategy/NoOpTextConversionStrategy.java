package pl.sdacademy.prog.strategy;

public enum NoOpTextConversionStrategy implements TextConversionStrategy {
    INSTANCE;

    @Override
    public String modify(final String textToModify) {
        return textToModify;
    }
}
