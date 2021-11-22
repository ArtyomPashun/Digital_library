package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

import java.util.List;

public interface LibService {

    boolean addBook(Book book) throws ServiceException;

    boolean removeBook(int bookId) throws ServiceException;

    boolean editBook(int bookId, String newBookTitle, String newAuthorName) throws ServiceException;

    Book findBook(String bookTitle) throws ServiceException;

    List<Book> findAllBooks() throws ServiceException;
}
