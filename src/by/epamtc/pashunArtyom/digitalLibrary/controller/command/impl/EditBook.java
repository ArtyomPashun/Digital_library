package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

public class EditBook extends AbsCommand {
    @Override
    public String execute(String request) throws ServiceException, ControllerException {
        String response;

        int bookId;
        String newBookTitle;
        String newBookBookAuthor;
        String[] requestParams;

        if (currentUser.getUserRole() != UserRole.ADMIN)
            response = "You can't edit books in the library";
        else {
            requestParams = request.split(" ");
            bookId = Integer.parseInt(requestParams[0]);
            newBookTitle = requestParams[1];
            newBookBookAuthor = requestParams[2];

            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTLibService libraryService = serviceFactory.getBookService();

            try {
                if (libraryService.editBook(bookId, newBookTitle, newBookBookAuthor)) {
                    response = "Book successfully edited!";
                } else {
                    response = "Invalid input parameters!";
                }
            } catch (ServiceException e) {
                throw new ControllerException("CRR ERROR: Error during book editing", e);
            }
        }
        return response;
    }
}
