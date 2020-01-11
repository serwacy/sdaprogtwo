package pl.sdacademy.prog.editor;

import pl.sdacademy.prog.stra.GenericException;

import java.util.TreeMap;

public class EditorText {
    private TreeMap<Integer, String> value = new TreeMap<>();

    public TreeMap<Integer, String> getValue() {
        return value;
    }

    public void addText(final String line) {
        final int indexToAdd = value.size() + 1;
        value.put(indexToAdd, line);
    }

    public void addText(final String newText, final int lineNum, final WriteMode writeMode) {
        validateLineNumber(lineNum);
        if(lineNum > value.size()){
            handleNewLineCreation(newText, lineNum);
        } else {
            handleExistingLineModification(newText, lineNum, writeMode);
        }
    }

    private void validateLineNumber(final int lineNum) {
        if (lineNum <= 0) {
            throw new GenericException("Line number has to be positive");
        }
    }
    private void handleNewLineCreation (final String text, final int lineNum) {
        final int emptyLinesToAdd = lineNum - value.size() - 1;
        for (int emptyLineNum = 0; emptyLineNum < emptyLinesToAdd; emptyLineNum++) {
            addText("");
        }
        addText(text);
    }
    private void handleExistingLineModification (final String text, final int lineNum, final WriteMode writeMode) {
        if (writeMode == WriteMode.REPLACE){
            value.replace(lineNum, text);
        } else if (writeMode == WriteMode.APPEND){
            value.replace(lineNum, value.get(lineNum) + text);
        } else {
            throw new GenericException("Write Mode " + writeMode + " not supported");
        }
    }
    public void restoreFromMemento(final EditorTextMemento memento){
        value = new TreeMap<>(memento.getValue());
    }
}
