package by.epamtc.pashunArtyom.digitalLibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookValidator {
    private final static String ID_PATTERN = "^\\d{1,10}$";
    private final static String TITLE_PATTERN = "^[\\w-]{5,30}$";
    private final static String AUTHOR_PATTERN = "^[\\a-zA-Z_-]{2,30}$";

    public boolean isTitleValid(String title) {
        return isArgValid(TITLE_PATTERN, title);
    }

    public boolean isAuthorValid(String author) {
        return isArgValid(AUTHOR_PATTERN, author);
    }

    public boolean isIdValid(int id) {
        return isArgValid(TITLE_PATTERN, String.valueOf(id));
    }

    private boolean isArgValid(String pattern, String arg) {
        Pattern patternCompile = Pattern.compile(pattern);
        Matcher matcher = patternCompile.matcher(arg);
        return matcher.matches();
    }
}
