package lotto.view;

import handler.InputHandler;
import lotto.domain.Lotto;

public class InputView {
    private final InputHandler inputHandler;

    private InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public static InputView createWithHandler(InputHandler inputHandler) {
        return new InputView(inputHandler);
    }

    public Lotto getPlayerLottery() {
        String input = inputHandler.readLine();
        return InputValidator.validateLotteryNumbers(input);
    }

    public int getPlayerAmount() {
        String input = inputHandler.readLine();
        return InputValidator.validateAmount(input);
    }

    public int getBonusNumber() {
        String input = inputHandler.readLine();
        return InputValidator.validateBonusNumber(input);
    }
}
