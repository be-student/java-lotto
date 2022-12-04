package lotto.adapter.in.client;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.port.in.BuyLottoCommand;

public class InputView {

    private static final String ASK_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public BuyLottoCommand getAmountFromClient() {
        System.out.println(ASK_AMOUNT_MESSAGE);
        return new BuyLottoCommand(Console.readLine());
    }
}
