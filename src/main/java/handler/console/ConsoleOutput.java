package handler.console;

import handler.OutputHandler;

public enum ConsoleOutput implements OutputHandler {
    INSTANCE;
    
    @Override
    public void println(String content) {
        System.out.println(content);
    }
}
