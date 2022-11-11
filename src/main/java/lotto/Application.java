package lotto;

import handler.InputHandler;
import handler.OutputHandler;
import handler.console.ConsoleInput;
import handler.console.ConsoleOutput;
import lotto.domain.LotteryMachine;
import lotto.domain.MissionRandom;
import lotto.domain.RandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void main(String[] args) {
        InputHandler inputHandler = ConsoleInput.INSTANCE;
        OutputHandler outputHandler = ConsoleOutput.INSTANCE;
        InputView inputView = InputView.createWithHandler(inputHandler);
        OutputView outputView = OutputView.createWithHandler(outputHandler);
        RandomNumbers randomNumbers = new MissionRandom();
        try {
            LotteryMachine lotteryMachine = new LotteryMachine(inputView, outputView, randomNumbers);
            lotteryMachine.run();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
    }
}
