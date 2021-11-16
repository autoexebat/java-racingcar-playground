package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RandomFuelPowerTest {
    @Test
    @DisplayName("랜덤 속도 테스트")
    void power() {
        RandomFuelPower randomFuelPower = new RandomFuelPower();
        for(int i=0; i<10; i++) {
            assertThat(randomFuelPower.power()).isLessThan(10);
        }
    }
}
