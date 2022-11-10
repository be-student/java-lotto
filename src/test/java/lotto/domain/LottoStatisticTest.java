package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
    private static final double THREE_MONEY = 5_000;
    private static final double FOUR_MONEY = 50_000;
    private static final double FIVE_MONEY = 1_500_000;
    private static final double FIVE_BONUS_MONEY = 30_000_000;
    private static final double SIX_MONEY = 2_000_000_000;
    private static final WinningLottery lottery = WinningLottery.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

    @BeforeAll
    static void setUp() {
        lottery.setBonusNumber(45);
    }

    @DisplayName("6개 일치 점수를 잘 계산한다")
    @Test
    void case1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos input = Lottos.from(List.of(lotto));
        LottoStatistic result = LottoStatistic.calculate(input, lottery);
        LottoScoreDto score = result.getScore();
        assertThat(score.getSix()).isEqualTo(1);
        assertThat(score.getRate()).isEqualTo(SIX_MONEY / 1000 * 100);
    }

    @DisplayName("5개 일치 점수를 잘 계산한다")
    @Test
    void case2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lottos input = Lottos.from(List.of(lotto));
        LottoStatistic result = LottoStatistic.calculate(input, lottery);
        LottoScoreDto score = result.getScore();
        assertThat(score.getSix()).isEqualTo(0);
        assertThat(score.getFive()).isEqualTo(1);
        assertThat(score.getRate()).isEqualTo(FIVE_MONEY / 1000 * 100);
    }

    @DisplayName("4개 일치 점수를 잘 계산한다")
    @Test
    void case3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 10, 9));
        Lottos input = Lottos.from(List.of(lotto));
        LottoStatistic result = LottoStatistic.calculate(input, lottery);
        LottoScoreDto score = result.getScore();
        assertThat(score.getSix()).isEqualTo(0);
        assertThat(score.getFive()).isEqualTo(0);
        assertThat(score.getFour()).isEqualTo(1);
        assertThat(score.getRate()).isEqualTo(FOUR_MONEY / 1000 * 100);
    }
}
