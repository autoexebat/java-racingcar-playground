package racingcar.view;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void raceStart() {
        System.out.println("실행 결과");
    }

    public void feedRace(List<Car> cars) {
        System.out.println();
        for(Car car : cars) {
            String carName = car.getName();
            int totalMovement = car.getTotalMovement();
            String movementAsDash = dashAsSpeed(totalMovement);

            String format = String.format("%s : %s", carName, movementAsDash);
            System.out.println(format);
        }
        System.out.println();
    }

    public void feedWinner(List<Car> cars) {
        String winners = cars.stream().map(car -> car.getName()).collect(Collectors.joining(", "));
        String format = String.format("%s 최종 우승했습니다.", winners);
        System.out.println(format);
    }

    private String dashAsSpeed(int count) {
        StringBuilder dash = new StringBuilder();
        for(int i=0; i<count; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
