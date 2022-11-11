package handler;

public interface OutputHandler {
    void println(String content);

    void printf(String format, Object... args);
}
