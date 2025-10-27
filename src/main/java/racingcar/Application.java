package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();

        RacingCarController controller = new RacingCarController(inputView, outputView, parser);

        controller.run();
    }
}
