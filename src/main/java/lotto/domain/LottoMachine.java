package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoRandom lottoRandom;

    public LottoMachine(InputView inputView, OutputView outputView, LottoRandom lottoRandom) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoRandom = lottoRandom;
    }

    public void run() {
        Money amount = getInputAmount();

        int count = amount.getTotalLottos();
        Lottos lottos = generateLottos(count);

        WinningLottery winningLottery = getWinningNumbers();

        printStatistics(lottos, winningLottery);
    }

    private Money getInputAmount() {
        outputView.printInputAmountMessage();
        return inputView.inputAmount();
    }

    private Lottos generateLottos(int count) {
        Lottos lottos = Lottos.from(LottoGenerator.getInstance(lottoRandom)
                .generateLotto(count));
        outputView.purchaseMessage(count);
        outputView.printLotto(lottos);
        return lottos;
    }

    private WinningLottery getWinningNumbers() {
        WinningLottery winningLottery = WinningLottery.create(inputView.inputLotto());
        outputView.printInputBonusNumber();
        winningLottery.setBonusNumber(inputView.inputBonus());
        return winningLottery;
    }

    private void printStatistics(Lottos lottos, WinningLottery winningLottery) {
        LottoStatistic statistic = LottoStatistic.calculate(lottos, winningLottery);
        outputView.printStatistic(statistic.getScore());
    }
}
