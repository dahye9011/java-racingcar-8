package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @DisplayName("이동 값이 4 미만인 경우, 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void 전진_테스트(int input) {
        // given
        Car car = new Car("rye");

        // when
        car.move(input);

        // then
        assertEquals(0, car.getPosition());
    }

    @ParameterizedTest
    @DisplayName("이동 값이 4 이상인 경우, 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_테스트2(int input) {
        // given
        Car car = new Car("rye");

        // when
        car.move(input);

        // then
        assertEquals(1, car.getPosition());
    }
}
