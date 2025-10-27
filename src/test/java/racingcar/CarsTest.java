package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {
    @Test
    @DisplayName("여러 번의 시도 결과로 우승자를 찾는다.")
    void 누적_시도_후_우승자_구하기_테스트() {
        // given
        // 1회차(5, 3, 3) / 2회차(5, 3, 4) / 3회차(5, 3, 4)
        // 최종 상태: rye(3), zero(0), hero(2)
        final int[] randomNumbers = {5, 3, 3,  5, 3, 4,  5, 3, 4};

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList("rye", "zero", "hero"));

                    cars.raceOneRound(); // 1회차
                    cars.raceOneRound(); // 2회차
                    cars.raceOneRound(); // 3회차

                    List<String> winners = cars.findWinnerNames();

                    assertThat(winners)
                            .containsExactlyInAnyOrder("rye");
                },
                // raceOneRound()가 9번 호출할 Randoms 값을 순서대로 전달
                randomNumbers[0], randomNumbers[1], randomNumbers[2],
                randomNumbers[3], randomNumbers[4], randomNumbers[5],
                randomNumbers[6], randomNumbers[7], randomNumbers[8]
        );
    }

    @Test
    @DisplayName("모든 자동차가 전진하지 못하면, 모두 공동 우승한다.")
    void 모두_전진하지_못한_경우_우승자_구하기_테스트() {
        // given
        // 1, 2, 3 (모두 정지) 값 준비
        final int[] randomNumbers = {1, 2, 3};

        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = new Cars(Arrays.asList("rye", "zero", "hero"));

                    cars.raceOneRound();

                    List<String> winners = cars.findWinnerNames();

                    assertThat(winners)
                            .containsExactlyInAnyOrder("rye", "zero", "hero");
                },
                randomNumbers[0], randomNumbers[1], randomNumbers[2]
        );
    }
}
