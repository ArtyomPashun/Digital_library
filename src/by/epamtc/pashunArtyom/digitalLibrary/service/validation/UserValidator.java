package by.epamtc.pashunArtyom.digitalLibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private final static String NAME_PATTERN = "^[\\w-]{5,16}$";
    private final static String PASSWORD_PATTERN = "^[\\w-]{5,10}$";

    public boolean isLoginValid(String login) {
        return isArgValid(NAME_PATTERN, login);
    }

    public boolean isPasswordValid(String password) {
        return isArgValid(PASSWORD_PATTERN, password);
    }

    private boolean isArgValid(String pattern, String arg) {
        Pattern patternCompile = Pattern.compile(pattern);
        Matcher matcher = patternCompile.matcher(arg);
        return matcher.matches();
    }
}
