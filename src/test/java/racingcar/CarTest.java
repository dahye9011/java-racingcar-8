package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 구분한다.")
    void 자동차_이름_구분() {
        // given
        CarNameParser parser = new CarNameParser();
        String input = "a,b,c";

        // when
        List<String> result = parser.nameParse(input);

        // then
        assertThat(result).contains("a", "b", "c");
    }

    @ParameterizedTest
    @DisplayName("이동 값이 4 미만인 경우, 전진하지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void 전진_테스트(int input) {
        // given
        Car car = new Car("rye");

        // when
        car.move(input);

        // then
        assertEquals(car.getPosition(), 0);
    }

    @ParameterizedTest
    @DisplayName("이동 값이 4 이상인 경우, 전진한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_테스트(int input) {
        // given
        Car car = new Car("rye");

        // when
        car.move(input);

        // then
        assertEquals(car.getPosition(), 1);
    }
}
