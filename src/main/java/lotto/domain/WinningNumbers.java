package lotto.domain;

public class WinningNumbers {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }
}
