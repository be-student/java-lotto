package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoScoreDto {
    private final Map<LottoScore, Long> score = new HashMap<>();
    private final double rate;

    public LottoScoreDto(long threeCorrect, long fourCorrect, long fiveCorrect,
                         long fiveBonusCorrect, long sixCorrect, double rate) {
        score.put(LottoScore.THREE_CORRECT, threeCorrect);
        score.put(LottoScore.FOUR_CORRECT, fourCorrect);
        score.put(LottoScore.FIVE_CORRECT, fiveCorrect);
        score.put(LottoScore.FIVE_BONUS_CORRECT, fiveBonusCorrect);
        score.put(LottoScore.SIX_CORRECT, sixCorrect);
        this.rate = rate;
    }

    public long getThreeCorrect() {
        return score.get(LottoScore.THREE_CORRECT);
    }

    public long getFourCorrect() {
        return score.get(LottoScore.FOUR_CORRECT);
    }

    public long getFiveCorrect() {
        return score.get(LottoScore.FIVE_CORRECT);
    }

    public long getFiveBonusCorrect() {
        return score.get(LottoScore.FIVE_BONUS_CORRECT);
    }

    public long getSixCorrect() {
        return score.get(LottoScore.SIX_CORRECT);
    }

    public double getRate() {
        return rate;
    }
}
