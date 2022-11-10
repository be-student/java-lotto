package lotto.domain;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
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
}
