package lotto;

import handler.InputHandler;
import handler.OutputHandler;
import handler.console.ConsolePrinter;
import handler.console.ConsoleScanner;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRandom;
import lotto.domain.MissionRandom;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = ConsoleScanner.INSTANCE;
        OutputHandler outputHandler = ConsolePrinter.INSTANCE;
        InputView inputView = new InputView(inputHandler);
        OutputView outputView = new OutputView(outputHandler);
        LottoRandom lottoRandom = new MissionRandom();
        LottoMachine lottoMachine = new LottoMachine(inputView, outputView, lottoRandom);

        try {
            lottoMachine.run();
        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
