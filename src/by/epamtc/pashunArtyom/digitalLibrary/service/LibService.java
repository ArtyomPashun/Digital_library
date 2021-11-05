package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public interface LibService {

    void addBook(Book book) throws ServiceException;

    void editBook(Book book) throws ServiceException;

    String findBook(String bookTitle) throws ServiceException;
}
