package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern LOTTERY_NUMBERS = Pattern.compile("^([0-9],?)+[0-9]+$");
    private static final String AMOUNT_NOT_NUMBER_ERROR = "구입 금액이 숫자만으로 이루어지지 않았습니다";
    private static final String AMOUNT_NOT_THOUSANDS_ERROR = "구입 금액이 1000으로 나누어 떨어지지 않음";
    private static final String AMOUNT_NOT_POSITIVE_ERROR = "구입 금액이 양수가 아님";
    private static final String LOTTERY_FORMAT_ERROR = "당첨 번호가 숫자,숫자 형식이 아닙니다";
    private static final String BONUS_FORMAT_ERROR = "보너스 번호가 숫자만으로 이루어지지 않음";

    private InputValidator() {
    }

    public static int validateAmount(String input) {
        isNumber(input);
        int amount = Integer.parseInt(input);
        isPositive(amount);
        isThousands(amount);
        return amount;
    }

    private static void isNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException(AMOUNT_NOT_NUMBER_ERROR);
        }
        if (!NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException(AMOUNT_NOT_NUMBER_ERROR);
        }
    }

    private static void isPositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(AMOUNT_NOT_POSITIVE_ERROR);
        }
    }

    private static void isThousands(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_NOT_THOUSANDS_ERROR);
        }
    }

    public static Lotto validateLotteryNumbers(String input) {
        isRightFormat(input);
        List<Integer> numbers = Arrays.stream(input.split(","))
                .mapToInt(number -> Integer.parseInt(number))
                .boxed()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }

    private static void isRightFormat(String input) {
        if (input == null) {
            throw new IllegalArgumentException(LOTTERY_FORMAT_ERROR);
        }
        if (!LOTTERY_NUMBERS.matcher(input).matches()) {
            throw new IllegalArgumentException(LOTTERY_FORMAT_ERROR);
        }
    }

    public static int validateBonusNumber(String input) {
        isBonusNumber(input);
        return Integer.parseInt(input);
    }

    private static void isBonusNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException(BONUS_FORMAT_ERROR);
        }
        if (!NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException(BONUS_FORMAT_ERROR);
        }
    }
}
