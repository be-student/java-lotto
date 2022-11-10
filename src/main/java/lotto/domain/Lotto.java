package lotto.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_MESSAGE_PATTERN;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> numbers1;
        validate(numbers);
        this.numbers = new ArrayList<>();
        numbers.forEach(this::appendIfUnique);
        this.numbers.sort(Comparator.naturalOrder());
    }

    private void isNumberInRange(int number) {
        if (number < LOTTO_START_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
        if (number > LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        numbers.forEach(this::isNumberInRange);
    }

    private void appendIfUnique(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
        numbers.add(number);
    }

    public String printableString() {
        return MessageFormat.format(LOTTO_MESSAGE_PATTERN, numbers.toArray());
    }
}
