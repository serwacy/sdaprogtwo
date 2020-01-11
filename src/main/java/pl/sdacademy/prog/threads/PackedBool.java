package pl.sdacademy.prog.threads;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PackedBool {
    private AtomicBoolean value;

    public PackedBool() {
        this.value = new AtomicBoolean(new Random().nextBoolean());
        System.out.println(this.value);
    }

    public AtomicBoolean isValue() {
        return value;
    }

    public void stateChanger(){ //synchronized or AtomicBoolean
        value.set(!value.get());
    }
}
