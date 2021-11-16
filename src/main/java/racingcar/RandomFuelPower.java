package racingcar;

import java.util.Random;

public class RandomFuelPower implements Raceable {
    private static final int MAX = 10;
    @Override
    public int power() {
        return new Random().nextInt(MAX);
    }
}
