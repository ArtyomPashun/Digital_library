package by.epamtc.pashunArtyom.digitalLibrary.controller;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public class Controller {
    private final static String paramSeparator = " ";

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) throws ControllerException, ServiceException {
        String commandName;
        Command executionCommand;

        commandName = request.contains(paramSeparator) ? request.substring(0, request.indexOf(paramSeparator)) : request;
        executionCommand = provider.getCommand(commandName);

        String response;
        request = request.contains(paramSeparator) ? request.substring(request.indexOf(paramSeparator) + paramSeparator.length()) : "";
        response = executionCommand.execute(request);

        return response;
    }
}
