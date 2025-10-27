package racingcar.view;

import java.util.List;

public class OutputView {
    public void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winners);
    }
}