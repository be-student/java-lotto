package lotto.view;

import handler.OutputHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreDto;
import lotto.domain.Lottos;

import java.text.MessageFormat;

import static lotto.config.LottoConstants.DIVISION_LINE;
import static lotto.config.LottoConstants.FIVE_BONUS_CORRECT_PATTERN;
import static lotto.config.LottoConstants.FIVE_CORRECT_PATTERN;
import static lotto.config.LottoConstants.FOUR_CORRECT_PATTERN;
import static lotto.config.LottoConstants.INPUT_AMOUNT_MESSAGE;
import static lotto.config.LottoConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.config.LottoConstants.INPUT_WIN_NUMBERS_MESSAGE;
import static lotto.config.LottoConstants.PURCHASE_MESSAGE_PATTERN;
import static lotto.config.LottoConstants.SIX_CORRECT_PATTERN;
import static lotto.config.LottoConstants.STATISTIC_PERCENT_PATTERN;
import static lotto.config.LottoConstants.STATISTIC_TITLE;
import static lotto.config.LottoConstants.THREE_CORRECT_PATTERN;

public class OutputView {
    private final OutputHandler outputHandler;

    public OutputView(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void printInputAmountMessage() {
        outputHandler.println(INPUT_AMOUNT_MESSAGE);
    }

    public void purchaseMessage(int count) {
        outputHandler.println(MessageFormat.format(PURCHASE_MESSAGE_PATTERN, count));
    }

    public void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            outputHandler.println(lotto.printableString());
        }
    }

    public void printInputLotteryNumbers() {
        outputHandler.println(INPUT_WIN_NUMBERS_MESSAGE);
    }

    public void printInputBonusNumber() {
        outputHandler.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printStatistic(LottoScoreDto lottoScoreDto) {
        printStatisticTitle();
        printScores(lottoScoreDto);
        printStatisticRate(lottoScoreDto.getRate());
    }

    private void printStatisticTitle() {
        outputHandler.println(STATISTIC_TITLE);
        outputHandler.println(DIVISION_LINE);
    }

    private void printScores(LottoScoreDto lottoScoreDto) {
        outputHandler.println(MessageFormat.format(THREE_CORRECT_PATTERN, lottoScoreDto.getThree()));
        outputHandler.println(MessageFormat.format(FOUR_CORRECT_PATTERN, lottoScoreDto.getFour()));
        outputHandler.println(MessageFormat.format(FIVE_CORRECT_PATTERN, lottoScoreDto.getFive()));
        outputHandler.println(MessageFormat.format(FIVE_BONUS_CORRECT_PATTERN, lottoScoreDto.getFiveBonus()));
        outputHandler.println(MessageFormat.format(SIX_CORRECT_PATTERN, lottoScoreDto.getSix()));
    }

    private void printStatisticRate(double rate) {
        outputHandler.println(MessageFormat.format(STATISTIC_PERCENT_PATTERN, rate));
    }
}
