package lotto.config;

public enum LottoConstants {
    THREE_CORRECT_MONEY(5_000),
    FOUR_CORRECT_MONEY(50_000),
    FIVE_CORRECT_MONEY(1_500_000),
    FIVE_BONUS_CORRECT_MONEY(30_000_000),
    SIX_CORRECT_MONEY(2_000_000_000),
    LOTTO_START_INCLUSIVE(1),
    LOTTO_END_INCLUSIVE(45),
    LOTTO_LENGTH(6);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
