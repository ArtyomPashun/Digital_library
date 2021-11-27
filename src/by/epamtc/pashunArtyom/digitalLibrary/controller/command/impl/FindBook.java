package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;


public class FindBook extends AbsCommand {

    @Override
    public String execute(String request) throws ServiceException, ControllerException {
        String response;

        if (currentUser.getUserRole() == UserRole.GUEST)
            response = "You have no permission to search books in the library";
        else {
            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTLibService libraryService = serviceFactory.getBookService();
            try {
                Book bookList = libraryService.findBook(request);
                if (bookList == null)
                    response = "Invalid input parameters!";
                else {
                    response = "Book with title: " + request.toLowerCase() +
                            " is written by " + bookList.getAuthorName() + " BookID: " +
                            bookList.getBookId() + ":\n";
                }
            } catch (ServiceException e) {
                throw new ControllerException("CRR ERROR: Error during book searching", e);
            }
        }
        return response;
    }
}
