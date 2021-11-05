package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

public class AddBook implements Command {
    @Override
    public String toDo(String request) throws ControllerException {
        ServiceFactory factory = ServiceFactory.getServiceLink();
        TXTLibService bookService = factory.getBookService();
        return bookService.addBook();
    }
}
