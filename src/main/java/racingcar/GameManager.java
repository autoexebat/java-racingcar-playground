package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {
    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar(new InputView(), new OutputView());
        racingCar.play();
    }
}
