package by.epamtc.pashunArtyom.digitalLibrary.controller.command;

public enum CommandName {
    SIGN_IN,
    REGISTER,
    ADD_BOOK,
    FIND_BOOK,
    WRONG_REQUEST;

    public static CommandName commandName(String request) {
        CommandName command;
        try {
            command = CommandName.valueOf(request.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            command = CommandName.WRONG_REQUEST;
        }
        return command;
    }
}
