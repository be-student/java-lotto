package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
    @DisplayName("getScore메서드는 계산된 점수를 바탕으로 당첨 횟수, 수익률을 계산한다")
    @Test
    void case1() {
        WinningLottery winningLottery = new WinningLottery(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningLottery.setBonusNumber(new BonusNumber(7));

        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(8, 9, 11, 12, 13, 14))
                )
        );
        LottoStatistic lottoStatistic = new LottoStatistic(winningLottery, lottos);
        LottoScoreDto scoreDto = lottoStatistic.getScore();
        assertThat(scoreDto.getSix()).isEqualTo(1);
        assertThat(scoreDto.getRate()).isEqualTo(LottoResult.SIX_CORRECT.money() / 20);
    }
}