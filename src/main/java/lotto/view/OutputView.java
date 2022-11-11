package lotto.view;

import handler.OutputHandler;
import lotto.domain.LottoScoreDto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String INPUT_LOTTERY_NUMBERS = "\n 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_TITLE = "\n당첨 통계";
    private static final String LINE_FEED = "---";
    private static final String THREE_CORRECT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_CORRECT = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_CORRECT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_CORRECT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String EARN_RATE = "총 수익률은 %.1f%%입니다.\n";
    private final OutputHandler outputHandler;

    private OutputView(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public static OutputView createWithHandler(OutputHandler outputHandler) {
        return new OutputView(outputHandler);
    }

    public void printInputAmountMessage() {
        outputHandler.println(INPUT_AMOUNT);
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> outputHandler.println(lotto.getLottoPrint()));
    }

    public void printBoughtAmount(int count) {
        outputHandler.printf(BOUGHT_COUNT, count);
    }

    public void printInputLotteryNumbers() {
        outputHandler.println(INPUT_LOTTERY_NUMBERS);
    }

    public void printInputBonusNumber() {
        outputHandler.println(INPUT_BONUS);
    }

    public void printStatistics(LottoScoreDto score) {
        printStatisticsTitle();
        printStatisticsContent(score);
    }

    private void printStatisticsTitle() {
        outputHandler.println(STATISTIC_TITLE);
        outputHandler.println(LINE_FEED);
    }

    private void printStatisticsContent(LottoScoreDto score) {
        outputHandler.printf(THREE_CORRECT, score.getThreeCorrect());
        outputHandler.printf(FOUR_CORRECT, score.getFourCorrect());
        outputHandler.printf(FIVE_CORRECT, score.getFiveCorrect());
        outputHandler.printf(FIVE_BONUS_CORRECT, score.getFiveBonusCorrect());
        outputHandler.printf(SIX_CORRECT, score.getSixCorrect());
        outputHandler.printf(EARN_RATE, score.getRate());
    }
}
