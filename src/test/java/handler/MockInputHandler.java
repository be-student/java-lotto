package handler;

public class MockInputHandler implements InputHandler {
    private String expected;

    public void setExpected(String expected) {
        this.expected = expected;
    }

    @Override
    public String readLine() {
        return expected;
    }
}
