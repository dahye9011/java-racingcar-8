package racingcar;

import java.util.List;

public class OutputView {
    public void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.positionToHyphen());
        }

        // 회차 단위 공백 구분
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winners);
    }
}