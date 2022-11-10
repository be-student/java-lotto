package lotto.domain;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
        isValid();
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    private void isValid() {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getTotalLottos() {
        return amount / 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money)) {
            return false;
        }
        return ((Money) o).getTotalLottos() == this.getTotalLottos();
    }
}
