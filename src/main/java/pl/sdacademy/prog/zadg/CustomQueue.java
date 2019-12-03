package pl.sdacademy.prog.zadg;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomQueue<T> extends AbstractQueue<T> {
    private LinkedList<T> content = new LinkedList<>();

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }

    @Override
    public int size() {
        return content.size();
    }

    @Override
    public boolean offer(final T t) {
        return content.add(t);
    }

    @Override
    public T poll() {
        return content.removeFirst();
    }

    @Override
    public T peek() {
        return content.getFirst();
    }
}
