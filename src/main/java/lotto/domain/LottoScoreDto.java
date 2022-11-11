package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoScoreDto {
    private final Map<LottoScore, Integer> score = new HashMap<>();
    private final double rate;

    public LottoScoreDto(int threeCorrect, int fourCorrect, int fiveCorrect,
                         int fiveBonusCorrect, int sixCorrect, double rate) {
        score.put(LottoScore.THREE_CORRECT, threeCorrect);
        score.put(LottoScore.FOUR_CORRECT, fourCorrect);
        score.put(LottoScore.FIVE_CORRECT, fiveCorrect);
        score.put(LottoScore.FIVE_BONUS_CORRECT, fiveBonusCorrect);
        score.put(LottoScore.SIX_CORRECT, sixCorrect);
        this.rate = rate;
    }

    public int getThreeCorrect() {
        return score.get(LottoScore.THREE_CORRECT);
    }

    public int getFourCorrect() {
        return score.get(LottoScore.FOUR_CORRECT);
    }

    public int getFiveCorrect() {
        return score.get(LottoScore.FIVE_CORRECT);
    }

    public int getFiveBonusCorrect() {
        return score.get(LottoScore.FIVE_BONUS_CORRECT);
    }

    public int getSixCorrect() {
        return score.get(LottoScore.SIX_CORRECT);
    }

    public double getRate() {
        return rate;
    }
}
