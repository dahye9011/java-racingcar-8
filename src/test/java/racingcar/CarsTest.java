package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("여러 번의 시도 결과로 우승자를 찾는다")
    void 누적_시도_후_우승자_구하기_테스트() {
        // given
        Car car1 = new Car("rye");
        Car car2 = new Car("zero");
        Car car3 = new Car("hero");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        // 1회차 시도
        car1.move(5); // rye 전진 (position: 1)
        car2.move(3); // zero 정지 (position: 0)
        car3.move(3); // hero 정지 (position: 0)

        // 2회차 시도
        car1.move(5); // rye 전진 (position: 2)
        car2.move(3); // zero 정지 (position: 0)
        car3.move(4); // hero 전진 (position: 1)

        // 3회차 시도
        car1.move(5); // rye 전진 (position: 3)
        car2.move(3); // zero 정지 (position: 0)
        car3.move(4); // hero 전진 (position: 2)

        // 최종 상태: rye(3), zero(0), hero(2)

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners)
                .map(Car::getName)
                .containsExactlyInAnyOrder("rye");
    }

    @Test
    @DisplayName("모든 자동차가 전진하지 못하면, 모두 공동 우승한다")
    void 모두_전진하지_못한_경우_우승자_구하기_테스트() {
        // given
        Car car1 = new Car("rye");
        Car car2 = new Car("zero");
        Car car3 = new Car("hero");
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        car1.move(1);
        car2.move(2);
        car3.move(3);

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners)
                .map(Car::getName)
                .containsExactlyInAnyOrder("rye", "zero", "hero");
    }
}
