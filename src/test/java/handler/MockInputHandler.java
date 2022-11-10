package handler;

public class MockInputHandler implements InputHandler {
    private String[] expected;
    private int current = 0;

    public void setExpected(String... expected) {
        this.expected = expected;
    }

    @Override
    public String readLine() {
        return expected[current++];
    }
}
