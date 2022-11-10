package lotto.domain;

public class LottoStatistic {
    private static final int THREE_MONEY = 5_000;
    private static final int FOUR_MONEY = 50_000;
    private static final int FIVE_MONEY = 1_500_000;
    private static final int FIVE_BONUS_MONEY = 30_000_000;
    private static final int SIX_MONEY = 2_000_000_000;
    private final Lottos lottos;
    private final WinningLottery winningLottery;

    private LottoStatistic(Lottos lottos, WinningLottery winningLottery) {
        this.lottos = lottos;
        this.winningLottery = winningLottery;
    }

    public static LottoStatistic calculate(Lottos lottos, WinningLottery winningLottery) {
        return new LottoStatistic(lottos, winningLottery);
    }

    public LottoScoreDto getScore() {
        int three = getThree();
        int four = getFour();
        int five = getFive();
        int fiveBonus = getFiveBonus();
        int six = getSix();
        double rate = getRate(three, four, five, fiveBonus, six);
        return new LottoScoreDto(three, four, five, fiveBonus, six, rate);
    }

    private int getThree() {
        int result = 0;
        for (Lotto lotto : lottos.getLottos()) {
            if (winningLottery.isThreeCorrect(lotto)) {
                result++;
            }
        }
        return result;
    }

    private int getFour() {
        int result = 0;
        for (Lotto lotto : lottos.getLottos()) {
            if (winningLottery.isFourCorrect(lotto)) {
                result++;
            }
        }
        return result;
    }

    private int getFive() {
        int result = 0;
        for (Lotto lotto : lottos.getLottos()) {
            if (winningLottery.isFiveCorrect(lotto)) {
                result++;
            }
        }
        return result;
    }

    private int getFiveBonus() {
        int result = 0;
        for (Lotto lotto : lottos.getLottos()) {
            if (winningLottery.isFiveBonusCorrect(lotto)) {
                result++;
            }
        }
        return result;
    }

    private int getSix() {
        int result = 0;
        for (Lotto lotto : lottos.getLottos()) {
            if (winningLottery.isSixCorrect(lotto)) {
                result++;
            }
        }
        return result;
    }

    private double getRate(int three, int four, int five, int fiveBonus, int six) {
        int investment = lottos.getLottos().size() * 1000;
        double sum = three * THREE_MONEY + four * FOUR_MONEY + five * FIVE_MONEY
                + fiveBonus * FIVE_BONUS_MONEY + six * SIX_MONEY;
        return sum / investment * 100;
    }
}
