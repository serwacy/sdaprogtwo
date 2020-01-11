package pl.sdacademy.prog.editor;

import java.util.TreeMap;

public class EditorTextMemento {
    private TreeMap<Integer, String> value;

    public EditorTextMemento(final EditorText editorText) {
        this.value = new TreeMap<>(editorText.getValue());
    }

    public TreeMap<Integer, String> getValue() {
        return value;
    }
}
