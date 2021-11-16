package racingcar;

public class FixedFuelPower implements Raceable{
    private int power = 0;
    public FixedFuelPower(int power) {
        this.power = power;
    }

    @Override
    public int power() {
        return this.power;
    }

}
