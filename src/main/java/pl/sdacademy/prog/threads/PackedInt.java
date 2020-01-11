package pl.sdacademy.prog.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PackedInt {
    private AtomicInteger value;

    public PackedInt(final AtomicInteger value) {
        this.value = value;
    }

    public AtomicInteger getValue() {
        return value;
    }

    public void increment(){
        value.incrementAndGet();
    }
}
