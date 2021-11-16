package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"12345", "1234"})
    @DisplayName("유효한 자동차 이름 검사")
    void validName(String name) {
        Car car = new Car(name, new FixedFuelPower(5));
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "123467"})
    @DisplayName("유효하지 않은 자동차 이름 검사")
    void invalidName(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name, new FixedFuelPower(5)));

    }

    @ParameterizedTest
    @CsvSource(value = {"5:10", "1:5", "2:3"}, delimiter = ':')
    @DisplayName("race 동작 체크")
    void race(int speed, int tryout) {
        Car car = new Car("race", new FixedFuelPower(speed));

        for(int i=0; i<tryout; i++) {
            car.race();
        }

        assertThat(car.getTotalMovement()).isEqualTo(speed * tryout);

    }
}
