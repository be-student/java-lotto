package lotto.domain;

public class LottoScoreDto {
    private final int three;
    private final int four;
    private final int five;
    private final int fiveBonus;
    private final int six;

    private final double rate;

    public LottoScoreDto(int three, int four, int five, int fiveBonus, int six, double rate) {
        this.three = three;
        this.four = four;
        this.five = five;
        this.fiveBonus = fiveBonus;
        this.six = six;
        this.rate = rate;
    }

    public int getThree() {
        return three;
    }

    public int getFour() {
        return four;
    }

    public int getFive() {
        return five;
    }

    public int getFiveBonus() {
        return fiveBonus;
    }

    public int getSix() {
        return six;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "3개 일치 : " + three + "\n4개 일치 : " + four + "\n5개 일치 : "
                + five + "\n5개 보너스 일치 : " + fiveBonus + "\n6개 일치 : " + six;
    }
}
