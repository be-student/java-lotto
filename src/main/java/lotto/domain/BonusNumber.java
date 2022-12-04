package lotto.domain;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException("범위 밖의 숫자가 들어왔습니다");
        }
    }

    private boolean isInRange(int bonusNumber) {
        return LOTTO_START_INCLUSIVE <= bonusNumber && bonusNumber <= LOTTO_END_INCLUSIVE;
    }
}
