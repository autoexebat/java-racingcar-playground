package racingcar;

public class Car {
    private String name;
    private Raceable raceable;
    private int totalMovement;

    public Car(String name, Raceable raceable) {
        validName(name);
        this.name = name;
        this.raceable = raceable;
    }

    public String getName() {
        return name;
    }

    public int getTotalMovement() {
        return totalMovement;
    }

    public int getSpeed() {
        return raceable.power();
    }

    public void race() {
        totalMovement += getSpeed();
    }

    private void validName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
