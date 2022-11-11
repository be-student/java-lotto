package lotto.config;

public enum LottoConstants {
    LOTTO_START_INCLUSIVE(1), LOTTO_END_INCLUSIVE(45), LOTTO_LENGTH(6);

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
