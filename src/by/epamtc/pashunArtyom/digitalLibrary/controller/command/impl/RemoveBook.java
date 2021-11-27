package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.AbsCommand;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.UserRole;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

public class RemoveBook extends AbsCommand {
    @Override
    public String execute(String request) throws ControllerException {
        String response;

        if (currentUser.getUserRole() == UserRole.ADMIN) {
            response = "You have no permission to delete books in the library";
        } else {
            ServiceFactory serviceFactory = ServiceFactory.getServiceLink();
            TXTLibService libraryService = serviceFactory.getBookService();
            try {
                int bookId = Integer.parseInt(request);
                if (libraryService.removeBook(bookId)) {
                    response = "Success deleting";
                } else {
                    response = "Invalid bookId input";
                }
            } catch (ServiceException e) {
                throw new ControllerException("CRR ERROR: You can not delete book", e);
            }
        }
        return response;
    }
}

