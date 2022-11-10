package lotto.view;

import handler.MockOutputHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.List;

import static lotto.config.LottoConstants.FIVE_BONUS_CORRECT_PATTERN;
import static lotto.config.LottoConstants.FIVE_CORRECT_PATTERN;
import static lotto.config.LottoConstants.FOUR_CORRECT_PATTERN;
import static lotto.config.LottoConstants.INPUT_AMOUNT_MESSAGE;
import static lotto.config.LottoConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.config.LottoConstants.INPUT_WIN_NUMBERS_MESSAGE;
import static lotto.config.LottoConstants.PURCHASE_MESSAGE_PATTERN;
import static lotto.config.LottoConstants.SIX_CORRECT_PATTERN;
import static lotto.config.LottoConstants.STATISTIC_PERCENT_PATTERN;
import static lotto.config.LottoConstants.THREE_CORRECT_PATTERN;

public class OutputViewTest {
    private MockOutputHandler mockOutputView;

    @BeforeEach
    void setUp() {
        mockOutputView = new MockOutputHandler();
    }

    @DisplayName("printInputAMountMessage 메서드는 금액 입력 메시지를 출력한다")
    @Test
    void case1() {
        mockOutputView.setExpected(INPUT_AMOUNT_MESSAGE);
        new OutputView(mockOutputView).printInputAmountMessage();
    }

    @DisplayName("purchaseMessage 메서드는 n개를 구매했다는 메시지를 출력한다")
    @Test
    void case2() {
        mockOutputView.setExpected(MessageFormat.format(PURCHASE_MESSAGE_PATTERN, 3));
        new OutputView(mockOutputView).purchaseMessage(3);
    }

    @DisplayName("printLotto 메서드는 로또를 정해진 형식으로 출력합니다")
    @Test
    void case3() {
        Lotto result = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        mockOutputView.setExpected(result.printableString());
        new OutputView(mockOutputView).printLotto(result);
    }

    @DisplayName("printInputLotteryNumbers 메서드는 당첨 번호를 입력하라는 메시지를 출력합니다")
    @Test
    void case4() {
        mockOutputView.setExpected(INPUT_WIN_NUMBERS_MESSAGE);
        new OutputView(mockOutputView).printInputLotteryNumbers();
    }

    @DisplayName("printInputBonusNumbers 메서드는 보너스 번호를 입력하라는 메세지를 출력합니다")
    @Test
    void case5() {
        mockOutputView.setExpected(INPUT_BONUS_NUMBER_MESSAGE);
        new OutputView(mockOutputView).printInputBonusNumber();
    }

    @DisplayName("printStatistic 메서드는 로또 통계를 출력합니다")
    @Test
    void case6() {
        String three = MessageFormat.format(THREE_CORRECT_PATTERN, 3);
        String four = MessageFormat.format(FOUR_CORRECT_PATTERN, 4);
        String five = MessageFormat.format(FIVE_CORRECT_PATTERN, 5);
        String fiveBonus = MessageFormat.format(FIVE_BONUS_CORRECT_PATTERN, 6);
        String six = MessageFormat.format(SIX_CORRECT_PATTERN, 7);
        String rate = MessageFormat.format(STATISTIC_PERCENT_PATTERN, 3.53);

        LottoScoreDto dto = new LottoScoreDto(3, 4, 5, 6, 7, 3.53);
        mockOutputView.setExpected("\n당첨 통계", "---", three, four, five, fiveBonus, six, rate);
        new OutputView(mockOutputView).printStatistic(dto);
    }
}
