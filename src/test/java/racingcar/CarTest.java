package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @DisplayName("전진한 횟수만큼 하이픈(-) 문자열을 반환한다.")
    @CsvSource({"1, -", "3, ---", "5, -----"})
    void 하이픈_반환_테스트(int moveCount, String expected) {
        // given
        Car car = new Car("rye");

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move(4);
        }
        String result = car.positionToHyphen();

        // then
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 초과인 경우, IllegalArgumentException이 발생한다.")
    @ValueSource(strings = {"123456", "ryerye", "verylongname"})
    void 이름_5자_초과_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }

    @Test
    @DisplayName("자동차 이름이 null인 경우, IllegalArgumentException이 발생한다.")
    void 이름_null_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }
}
