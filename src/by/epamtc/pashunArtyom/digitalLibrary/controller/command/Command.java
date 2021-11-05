package by.epamtc.pashunArtyom.digitalLibrary.controller.command;

import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;

public interface Command {
    public String toDo(String request) throws ControllerException;
}
