package pl.sdacademy.prog.generics.fruits;

import pl.sdacademy.prog.generics.Fruit;

public class MagicalGrapefruit extends Fruit {
    public MagicalGrapefruit(final Double weight, final String color) {
        super(weight, color, false);
    }

    @Override
    public boolean isRotten() {
        return false;
    }
}
