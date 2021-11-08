package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public class FindBook implements Command {
    @Override
    public String toDo(String request) throws ControllerException {
        String response = null;
        try {
            response = ServiceFactory.getServiceLink().getBookService().findBook(request);
        } catch (ServiceException | NullPointerException e) {
            throw new ControllerException("CONTROLLER ERROR: Can not find the book in library");
        }
        return response;
    }
}
