package lotto.domain;

import java.util.Arrays;

public enum LottoScore {
    ZERO_CORRECT(0),
    ONE_CORRECT(1),
    TWO_CORRECT(2),
    THREE_CORRECT(3),
    FOUR_CORRECT(4),
    FIVE_CORRECT(5),
    FIVE_BONUS_CORRECT(1000),
    SIX_CORRECT(6);

    private final int value;

    LottoScore(int value) {
        this.value = value;
    }

    public static LottoScore from(int value) {
        return Arrays.stream(LottoScore.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
