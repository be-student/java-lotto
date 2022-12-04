package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final Lotto correctNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> correctNumbers, int bonusNumber) {
        validate(correctNumbers, bonusNumber);
        this.correctNumbers = new Lotto(correctNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validate(List<Integer> correctNumbers, int bonusNumber) {
        if (correctNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 값이 들어왔습니다");
        }
    }
}
