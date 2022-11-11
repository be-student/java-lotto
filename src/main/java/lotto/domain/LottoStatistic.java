package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.LottoConstants.FIVE_BONUS_CORRECT_MONEY;
import static lotto.config.LottoConstants.FIVE_CORRECT_MONEY;
import static lotto.config.LottoConstants.FOUR_CORRECT_MONEY;
import static lotto.config.LottoConstants.SIX_CORRECT_MONEY;
import static lotto.config.LottoConstants.THREE_CORRECT_MONEY;
import static lotto.domain.LottoScore.FIVE_BONUS_CORRECT;
import static lotto.domain.LottoScore.FIVE_CORRECT;
import static lotto.domain.LottoScore.FOUR_CORRECT;
import static lotto.domain.LottoScore.SIX_CORRECT;
import static lotto.domain.LottoScore.THREE_CORRECT;

public class LottoStatistic {
    private final List<LottoScore> lottoScores;

    public LottoStatistic(WinningLottery winningLottery, Lottos lottos) {
        this.lottoScores = lottos.getLottos()
                .stream()
                .map(winningLottery::getScore)
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoScoreDto getScore() {
        long three = getThree();
        long four = getFour();
        long five = getFive();
        long fiveBonus = getFiveBonus();
        long six = getSix();
        long totalMoney = three * THREE_CORRECT_MONEY.getValue() +
                four * FOUR_CORRECT_MONEY.getValue() +
                five * FIVE_CORRECT_MONEY.getValue() +
                fiveBonus * FIVE_BONUS_CORRECT_MONEY.getValue() +
                six * SIX_CORRECT_MONEY.getValue();
        double rate = (double) totalMoney / lottoScores.size() / 1000 * 100;
        return new LottoScoreDto(three, four, five, fiveBonus, six, rate);
    }

    private long getThree() {
        return lottoScores.stream()
                .filter(it -> it == THREE_CORRECT)
                .count();
    }

    private long getFour() {
        return lottoScores.stream()
                .filter(it -> it == FOUR_CORRECT)
                .count();
    }

    private long getFive() {
        return lottoScores.stream()
                .filter(it -> it == FIVE_CORRECT)
                .count();
    }

    private long getFiveBonus() {
        return lottoScores.stream()
                .filter(it -> it == FIVE_BONUS_CORRECT)
                .count();
    }

    private long getSix() {
        return lottoScores.stream()
                .filter(it -> it == SIX_CORRECT)
                .count();
    }
}
