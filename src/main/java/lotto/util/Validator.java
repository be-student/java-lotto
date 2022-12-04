package lotto.util;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER = Pattern.compile("^\\d$");

    private Validator() {
    }

    public static boolean isNumber(String input) {
        return NUMBER.matcher(input).matches();
    }
}
