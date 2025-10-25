package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .collect(Collectors.toList());
    }

    // getName()으로 직접 가져오지 않도록 리팩터링
    private void validateDuplicate(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            String carName = car.getName();
            if (!carNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
