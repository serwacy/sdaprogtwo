package pl.sdacademy.prog.generics.fruits;

import pl.sdacademy.prog.generics.Fruit;

import java.util.Random;

public class Apple extends Fruit {
    public Apple(final Double weight, final boolean rotten) {
        super(weight, new Random().nextBoolean() ? "GREEN" : "RED", rotten);
    }
}
