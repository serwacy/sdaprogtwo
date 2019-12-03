package pl.sdacademy.prog.generics;

import java.util.Random;

public abstract class Fruit {
    private Double weight;
    private String color;
    private boolean rotten;

    protected Fruit(final Double weight, final String color, final boolean rotten){
        this.weight = weight;
        this.color = color;
        this.rotten = rotten;
    }

    public Double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean isRotten() {
        if(rotten){
            return true;
        }
        rotten = new Random().nextBoolean();
        return rotten;
    }
}
