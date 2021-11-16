package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    @Test
    @DisplayName("race 승자 찾기")
    void result() {
        Car c1 = new Car("11", new FixedFuelPower(5));
        Car c2 = new Car("22", new FixedFuelPower(1));
        Car c3 = new Car("33", new FixedFuelPower(2));
        Car c4 = new Car("44", new FixedFuelPower(5));

        List<Car> cars = Arrays.asList(c1, c2, c3, c4);

        for (int i = 0; i < 5; i++) {
            for(Car car : cars) {
                car.race();
            }
        }

        RacingResult racingResult = new RacingResult();
        List<Car> result = racingResult.result(Arrays.asList(c1, c2, c3, c4));
        List<String> carNames = result.stream().map(c -> c.getName()).collect(Collectors.toList());

        assertThat(carNames.size()).isEqualTo(2);
        assertThat(carNames).contains("11");
        assertThat(carNames).contains("44");
    }
}
