package lotto.domain;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class WinningLottery {
    private static final String BONUS_SIZE_ERROR = "당첨 번호가 " +
            LOTTO_START_INCLUSIVE.getValue() + "부터 " +
            LOTTO_END_INCLUSIVE.getValue() + "가 아닙니다";
    private static final String BONUS_DUPLICATE_ERROR = "당첨 번호와 보너스 번호의 중복이 있습니다";
    private final Lotto winLotto;
    private int bonusNumber;

    public WinningLottery(Lotto lotto) {
        this.winLotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        isValid(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isValid(int bonusNumber) {
        isInRange(bonusNumber);
        isUnique(bonusNumber);
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(BONUS_SIZE_ERROR);
        }
        if (bonusNumber > LOTTO_END_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(BONUS_SIZE_ERROR);
        }
    }

    private void isUnique(int bonusNumber) {
        if (winLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
        }
    }

    public LottoScore getScore(Lotto lotto) {
        if (isFiveCorrectAndBonus(lotto)) {
            return LottoScore.FIVE_BONUS_CORRECT;
        }
        int same = winLotto.getSame(lotto);

        return LottoScore.from(same);
    }

    private boolean isFiveCorrectAndBonus(Lotto lotto) {
        int same = winLotto.getSame(lotto);
        if (same != 5) {
            return false;
        }
        return lotto.contains(bonusNumber);
    }
}
