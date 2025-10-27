package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

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
        assertEquals("rye : ", car.toResultString());
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
        assertEquals("rye : -", car.toResultString());
    }

    @ParameterizedTest
    @DisplayName("전진한 횟수만큼 하이픈(-)을 출력한다")
    @ValueSource(ints = {1, 3, 5})
    void 하이픈_반환_테스트(int moveCount) {
        // given
        Car car = new Car("rye");

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move(4);
        }

        // then
        String expected = "rye : " + "-".repeat(moveCount);
        assertEquals(expected, car.toResultString());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자 초과인 경우, IllegalArgumentException이 발생한다.")
    @ValueSource(strings = {"123456", "ryerye", "verylongname"})
    void 이름_5자_초과_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    @DisplayName("자동차 이름이 null이거나 공백 또는 비어있는 경우, IllegalArgumentException이 발생한다.")
    void 이름__예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }
}
