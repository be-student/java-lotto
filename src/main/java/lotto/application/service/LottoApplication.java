package lotto.application.service;

import lotto.application.port.in.BonusNumberCommand;
import lotto.application.port.in.BuyLottoCommand;
import lotto.application.port.in.LottoUseCase;
import lotto.application.port.in.WinningNumbersCommand;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultDto;
import lotto.domain.Lottos;
import lotto.domain.LottosDto;
import lotto.domain.Money;

public class LottoApplication implements LottoUseCase {

    private final LottoGenerator lottoGenerator;
    private Lottos lottos;

    public LottoApplication(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public void buy(BuyLottoCommand buyLottoCommand) {
        Long amount = buyLottoCommand.getAmount();
        Money money = new Money(amount);
        lottos = new Lottos(lottoGenerator.generate(money.ableToBuyLottos()));
    }

    @Override
    public LottosDto getAllLottos() {
        return null;
    }

    @Override
    public void changeWinningNumbers(WinningNumbersCommand winningNumbersCommand) {

    }

    @Override
    public void changeBonusNUmber(BonusNumberCommand bonusNumberCommand) {

    }

    @Override
    public LottoResultDto calculateStatistics() {
        return null;
    }
}
