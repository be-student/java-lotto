package lotto.domain;

import java.text.MessageFormat;
import java.util.List;

import static lotto.config.LottoConstants.LOTTO_MESSAGE_PATTERN;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String printableString() {
        return MessageFormat.format(LOTTO_MESSAGE_PATTERN, numbers.toArray());
    }
}
