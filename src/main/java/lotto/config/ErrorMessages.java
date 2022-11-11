package lotto.config;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public enum ErrorMessages {
    AMOUNT_NOT_NUMBER_ERROR("구입 금액이 숫자만으로 이루어지지 않았습니다"),
    AMOUNT_NOT_THOUSANDS_ERROR("구입 금액이 1000으로 나누어 떨어지지 않음"),
    AMOUNT_NOT_POSITIVE_ERROR("구입 금액이 양수가 아님"),

    LOTTERY_FORMAT_ERROR("당첨 번호가 숫자,숫자 형식이 아닙니다"),
    LOTTERY_COUNT_ERROR("당첨 번호가 6개가 아닙니다"),
    LOTTERY_SIZE_ERROR("당첨 번호가 " + LOTTO_START_INCLUSIVE + "부터 " + LOTTO_END_INCLUSIVE + "가 아닙니다"),
    LOTTERY_DUPLICATE_ERROR("당첨 번호에 중복이 있습니다"),

    BONUS_FORMAT_ERROR("보너스 번호가 숫자만으로 이루어지지 않음"),
    BONUS_SIZE_ERROR("당첨 번호가 " + LOTTO_START_INCLUSIVE + "부터 " + LOTTO_END_INCLUSIVE + "가 아닙니다"),
    BONUS_DUPLICATE_ERROR("당첨 번호와 보너스 번호의 중복이 있습니다");

    private final String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
