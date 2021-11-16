package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    public List<Car> result(List<Car> cars) {
        List<Car> ordered = cars.stream().sorted(Comparator.comparing(Car::getTotalMovement).reversed())
                .collect(Collectors.toList());

        Car firstPlaceCar = ordered.get(0);
        int firstPlaceMovement = firstPlaceCar.getTotalMovement();

        return ordered.stream()
                .filter(car -> car.getTotalMovement() == firstPlaceMovement)
                .collect(Collectors.toList());
    }
}
