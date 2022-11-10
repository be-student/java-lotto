package lotto.domain;

import java.util.stream.IntStream;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_SIZE;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class WinningLottery {
    private static final int UNSET = -9999;
    private final Lotto lotto;
    private int bonusNumber = UNSET;

    private WinningLottery(Lotto lotto) {
        this.lotto = lotto;
        isValid();
    }

    public static WinningLottery create(Lotto lotto) {
        return new WinningLottery(lotto);
    }

    private void isValid() {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        if (bonusNumber == UNSET) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        if (bonusNumber < LOTTO_START_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber > LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isThreeCorrect(Lotto other) {
        int score = getScore(other);
        return score == 3;
    }

    public boolean isFourCorrect(Lotto other) {
        return getScore(other) == 4;
    }

    public boolean isFiveCorrect(Lotto other) {
        if (getScore(other) != 5) {
            return false;
        }
        return !other.contains(bonusNumber);
    }

    public boolean isFiveBonusCorrect(Lotto other) {
        if (getScore(other) != 5) {
            return false;
        }
        return other.contains(bonusNumber);
    }

    public boolean isSixCorrect(Lotto other) {
        return getScore(other) == 6;
    }

    private int getScore(Lotto other) {
        return IntStream.range(0, LOTTO_SIZE)
                .reduce(0, (total, index) -> updateTotalScore(other, total, index));
    }

    private int updateTotalScore(Lotto other, int total, int index) {
        if (lotto.contains(other.getIndex(index))) {
            return total + 1;
        }
        return total;
    }
}
