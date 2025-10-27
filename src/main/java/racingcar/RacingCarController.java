package racingcar;

import java.util.List;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    RacingCarController(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void run() {
        String carNameInput = inputView.readCarNameInput();
        String tryCountInput = inputView.readTryCountInput();

        List<String> carNames = parser.nameParse(carNameInput);
        int tryCount = parser.parseTryCount(tryCountInput);

        Cars cars = new Cars(carNames);

        outputView.printResultTitle();

        for (int i = 0; i < tryCount; i++) {
            cars.raceOneRound();
            outputView.printRoundResult(cars.getRoundResultStrings());
        }

        List<String> winnerNames = cars.findWinnerNames();
        outputView.printWinners(winnerNames);
    }
}
