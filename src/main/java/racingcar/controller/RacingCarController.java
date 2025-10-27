package racingcar.controller;

import java.util.List;
import racingcar.Parser;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    public RacingCarController(InputView inputView, OutputView outputView, Parser parser) {
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
