package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LotteryMachine {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbers randomNumbers;

    public LotteryMachine(InputView inputView, OutputView outputView, RandomNumbers randomNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumbers = randomNumbers;
    }

    public void run() {
        outputView.printInputAmountMessage();
        int lottoCount = inputView.getPlayerAmount() / 1000;
        Lottos lottos = new LottoGenerator(randomNumbers).createLottos(lottoCount);
        outputView.printBoughtAmount(lottoCount);
        outputView.printLottos(lottos);

        outputView.printInputLotteryNumbers();
        WinningLottery winningLottery = new WinningLottery(inputView.getPlayerLottery());
        outputView.printInputBonusNumber();
        int bonusNumber = inputView.getBonusNumber();
        winningLottery.setBonusNumber(bonusNumber);

        LottoScoreDto score = new LottoStatistic(winningLottery, lottos).getScore();
        outputView.printStatistics(score);
    }
}
