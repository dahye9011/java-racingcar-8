package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<String> carNames) {
        validateDuplicate(carNames);
        this.cars = createCarsFromNames(carNames);
    }

    public void raceOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> findWinnerNames() {
        Car furthestCar = cars.stream()
                .reduce((c1, c2) -> c1.isFurtherThan(c2) ? c1 : c2)
                .orElseThrow();

        return cars.stream()
                .filter(c -> c.isWinnerPositionSameAs(furthestCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    public List<String> getRoundResultStrings() {
        return cars.stream()
                .map(Car::toResultString)
                .collect(Collectors.toList());
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
