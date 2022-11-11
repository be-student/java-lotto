package lotto.view;

import lotto.config.ErrorMessages;
import lotto.domain.Lotto;
import lotto.domain.LottoException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern LOTTERY_NUMBERS = Pattern.compile("^([0-9],?)+[0-9]+$");

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
            throw LottoException.create(ErrorMessages.AMOUNT_NOT_NUMBER_ERROR);
        }
        if (!NUMBER.matcher(input).matches()) {
            throw LottoException.create(ErrorMessages.AMOUNT_NOT_NUMBER_ERROR);
        }
    }

    private static void isPositive(int amount) {
        if (amount < 0) {
            throw LottoException.create(ErrorMessages.AMOUNT_NOT_POSITIVE_ERROR);
        }
    }

    private static void isThousands(int amount) {
        if (amount % 1000 != 0) {
            throw LottoException.create(ErrorMessages.AMOUNT_NOT_THOUSANDS_ERROR);
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
            throw LottoException.create(ErrorMessages.LOTTERY_FORMAT_ERROR);
        }
        if (!LOTTERY_NUMBERS.matcher(input).matches()) {
            throw LottoException.create(ErrorMessages.LOTTERY_FORMAT_ERROR);
        }
    }
}
