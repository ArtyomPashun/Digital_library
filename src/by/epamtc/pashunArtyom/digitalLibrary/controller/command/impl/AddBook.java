package by.epamtc.pashunArtyom.digitalLibrary.controller.command.impl;

import by.epamtc.pashunArtyom.digitalLibrary.controller.command.Command;
import by.epamtc.pashunArtyom.digitalLibrary.controller.exception.ControllerException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.ServiceFactory;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

import java.util.Scanner;

public class AddBook implements Command {

    @Override
    public String toDo(String request) throws ControllerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id");
        String response;
        String[] temp = request.split("; ");
        Book newBook = new Book();
        newBook.setBookId(sc.nextInt());
        newBook.setBookTitle(temp[0]);
        newBook.setAuthorName(temp[1]);
        try {
            ServiceFactory.getServiceLink().getBookService().addBook(newBook);
            response = "Book has been added to library";
        } catch (ArrayIndexOutOfBoundsException | ServiceException e) {
            throw new ControllerException("CONTROLLER ERROR: Can not add a book");
        }
        return response;
    }
}
