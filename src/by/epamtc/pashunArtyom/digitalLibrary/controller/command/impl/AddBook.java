package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

public class AddBook extends AbsCommand {
    @Override
    public String execute(String request) throws ServiceException, ControllerException {
        String response;

        int bookId;
        String title;
        String author;
        String[] requestParams;

        if (currentUser.getUserRole() != UserRole.ADMIN)
            response = "You can't add books to the library";
        else {
            requestParams = request.split(" ");

            bookId = Integer.parseInt(requestParams[0]);
            title = requestParams[1];
            author = requestParams[2];

            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTLibService libraryService = serviceFactory.getBookService();

            try {
                if (libraryService.addBook(new Book(bookId, title.toUpperCase(), author.toUpperCase()))) {
                    response = "Book is added to the library!";
                } else {
                    response = "Invalid input parameters!";
                }
            } catch (ServiceException e) {
                response = "Error during book adding";
                throw new ControllerException("CRR ERROR: adding book error", e);
            }
        }
        return response;
    }
}
