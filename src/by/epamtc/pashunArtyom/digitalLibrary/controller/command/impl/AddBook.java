package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;

public class AddBook implements Command {

    @Override
    public String toDo(String request) throws ControllerException {

        String response = null;

        String[] temp = request.split("; ");
        Book newBook = new Book();
        newBook.setBookId(1);
        newBook.setBookTitle(temp[0]);
        newBook.setAuthorName(temp[1]);
        try {
            ServiceFactory.getServiceLink().getBookService().addBook(newBook);
            response = "Book has been added to library";
        } catch (ArrayIndexOutOfBoundsException | ServiceException e) {
            throw new ControllerException("Can't add a book");
        }
        //System.out.println(newBook.toString());

        return response;
    }
}
