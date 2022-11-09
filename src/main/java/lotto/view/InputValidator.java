package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    private InputValidator() {
    }

    public static int isAmountValidate(String input) {
        isNotNull(input);
        isNumber(input);
        int amount = Integer.parseInt(input);
        isBiggerThanZero(amount);
        isMultipleOfThousand(amount);
        return amount;
    }

    private static void isNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNumber(String string) {
        if (!NUMBER_PATTERN.matcher(string).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isBiggerThanZero(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void isMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto isLottoNumberValid(String input) {
        isNotNull(input);
        List<String> lottoTokens = List.of(input.split(","));
        lottoTokens.forEach(it -> isNumber(it));
        List<Integer> lottoNumbers = lottoTokens.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public static int isBonusNumberValid(String input) {
        isNotNull(input);
        isNumber(input);
        return Integer.parseInt(input);
    }
}
