package by.epamtc.pashunArtyom.digitalLibrary.controller;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.command.CommandName;
import by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl.*;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {

        repository.put(CommandName.SIGN_IN, new SignInUser());
        repository.put(CommandName.REGISTER, new RegisterUser());
        repository.put(CommandName.DELETE, new DeleteUser());

        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.EDIT_BOOK, new EditBook());
        repository.put(CommandName.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandName.FIND_BOOK, new FindBook());
        repository.put(CommandName.SHOW_BOOKS, new ShowBooks());
    }

    public Command getCommand(String name) throws ControllerException {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new ControllerException("CRR ERROR: this action does not exist", e);
        }
        return command;
    }
}
