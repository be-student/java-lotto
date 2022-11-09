package handler.console;

import camp.nextstep.edu.missionutils.Console;
import handler.InputHandler;

public enum ConsoleScanner implements InputHandler {
    INSTANCE;

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
