package pl.sdacademy.prog.generics;

import pl.sdacademy.prog.generics.fruits.AlwaysYellowBanana;
import pl.sdacademy.prog.generics.fruits.Apple;
import pl.sdacademy.prog.generics.fruits.MagicalGrapefruit;

public class FruitBoxDemo {
    public static void main(String[] args) {
        final Container<Fruit> fruitBox = new Container<>();
        fruitBox.addFruit(new AlwaysYellowBanana(22.0, false));
        fruitBox.addFruit(new Apple(55.1, false));
        fruitBox.addFruit(new MagicalGrapefruit(10000000.0, "PINK"));

        fruitBox.getFruits().forEach(System.out::println);
        fruitBox.removeRottenFruits();
        fruitBox.getFruits().forEach(System.out::println);
    }
}
