package lotto.application.port.in;

import lotto.domain.LottoResultDto;
import lotto.domain.LottosDto;

public interface LottoUseCase {

    void buy(BuyLottoCommand buyLottoCommand);

    LottosDto getAllLottos();

    void changeWinningNumbers(WinningNumbersCommand winningNumbersCommand);

    void changeBonusNUmber(BonusNumberCommand bonusNumberCommand);

    LottoResultDto calculateStatistics();


}
