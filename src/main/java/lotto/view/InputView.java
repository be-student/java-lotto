package lotto.view;

import handler.InputHandler;
import lotto.domain.Lotto;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public int inputAmount() {
        return InputValidator.isAmountValidate(inputHandler.readLine());
    }

    public Lotto inputLotto() {
        return InputValidator.isLottoNumberValid(inputHandler.readLine());
    }

    public int inputBonus() {
        return InputValidator.isBonusNumberValid(inputHandler.readLine());
    }
}
