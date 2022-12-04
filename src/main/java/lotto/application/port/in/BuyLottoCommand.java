package lotto.application.port.in;


import static lotto.util.Validator.isNumber;

public class BuyLottoCommand {

    private static final String INPUT_NULL_MESSAGE = "입력에 null 이 있으면 안됩니다";
    private static final String NOT_NUMBER_MESSAGE = "금액은 숫자로 이루어져야 합니다";
    private final Long amount;

    public BuyLottoCommand(String input) {
        validate(input);
        amount = toLong(input);
    }

    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
        if (!isNumber(input)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    private Long toLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 범위를 초과했습니다");
        }
    }

    public Long getAmount() {
        return amount;
    }
}
