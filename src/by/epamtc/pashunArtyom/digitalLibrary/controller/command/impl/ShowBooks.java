package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

import java.util.List;

public class ShowBooks implements Command {

    @Override
    public String execute(String request) throws ControllerException {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
        TXTLibService libraryService = serviceFactory.getBookService();

        try {
            List<Book> bookList = libraryService.findAllBooks();
            if (bookList == null)
                response = "CRR ERROR: Invalid input parameters!";
            else {
                StringBuilder responseBuilder = new StringBuilder();
                responseBuilder.append("Books:\n");
                for (Book book : bookList) {
                    responseBuilder.append(book).append('\n');
                }
                response = responseBuilder.toString();
            }
        } catch (ServiceException e) {
            throw new ControllerException("CRR ERROR: showing all books error", e);
        }
        return response;
    }
}

