package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private InputView inputView;
    private OutputView outputView;

    public RacingCar(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        inputView.carNameSetting();
        List<Car> candidates = getReady(inputView.input());

        inputView.tryoutSetting();
        int tryout = Integer.parseInt(inputView.input());

        outputView.raceStart();
        while(0 < tryout) {
            race(candidates);
            outputView.feedRace(candidates);
            tryout --;
        }

        RacingResult rr = new RacingResult();
        List<Car> winners = rr.result(candidates);

        outputView.feedWinner(winners);
    }

    private List<Car> getReady(String cars) {
        List<Car> readyCars = new ArrayList<>();
        String[] candidates = cars.split(",");
        for(String candidate : candidates) {
            readyCars.add(new Car(candidate, new RandomFuelPower()));
        }
        return readyCars;
    }

    private void race(List<Car> cars) {
        cars.stream().forEach(Car::race);
    }
}
