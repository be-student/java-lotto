package handler;

import static org.assertj.core.api.Assertions.assertThat;

public class MockOutputHandler implements OutputHandler {
    private int current = 0;
    private String[] expected;

    public void setExpected(String... expected) {
        this.expected = expected;
    }

    @Override
    public void println(String content) {
        assertThat(content).isEqualTo(expected[current++]);
    }
}
