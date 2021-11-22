package by.epamtc.pashunArtyom.digitalLibrary.controller;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.command.CommandName;
import by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    private static final Map<CommandName, Command> commands = new HashMap<>();

    public Commands() {
        commands.put(CommandName.ADD_BOOK, new AddBook());
        //commands.put(CommandName.EDIT_BOOK, new EditBook());
        commands.put(CommandName.FIND_BOOK, new FindBook());
        commands.put(CommandName.REGISTER, new Register());
        commands.put(CommandName.SIGN_IN, new SignIn());
    }

    public Command getCommand(String request) {
        CommandName actions = CommandName.commandName(request);
        Command command;
        if (actions == null) {
            command = commands.get(CommandName.WRONG_REQUEST);
        } else {
            command = commands.get(actions);
        }
        return command;
    }
}
