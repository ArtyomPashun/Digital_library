package by.epamtc.pashunArtyom.digitalLibrary.controller.command;

import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public interface Command {

    public String execute(String request) throws ServiceException, ControllerException;

}
