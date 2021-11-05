package by.epamtc.pashunArtyom.digitalLibrary.service.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.DAOFactory;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.LibService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

import java.util.ArrayList;

public class TXTLibService implements LibService {

    @Override
    public void addBook(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("SERVICE ERROR: book is not exist");
        }
        if (book.getBookTitle() == null || book.getBookTitle().isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookTitle input");
        }
        if (book.getAuthorName() == null || book.getAuthorName().isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookAuthorName input");
        }
        try {
            DAOFactory.getFactoryLink().getTxtBooksDAO().addBook(book);
        } catch (DAOException | NullPointerException e) {
            throw new ServiceException("SERVICE ERROR: you could not add book");
        }
    }

    @Override
    public void editBook(Book book) throws ServiceException {
        if (book == null) {
            throw new ServiceException("SERVICE ERROR: book is not exist");
        }
        if (book.getBookTitle() == null || book.getBookTitle().isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookTitle input");
        }
        if (book.getAuthorName() == null || book.getAuthorName().isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookAuthorName input");
        }
        try {
            DAOFactory.getFactoryLink().getTxtBooksDAO().editBook();
        } catch (DAOException | NullPointerException e) {
            throw new ServiceException("SERVICE ERROR: book edit error");
        }
    }

    @Override
    public String findBook(String bookTitle) throws ServiceException {
        if (bookTitle == null || bookTitle.isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookTitle input");
        }
        StringBuilder sb = new StringBuilder();

        try {
            ArrayList<Book> bookResult = DAOFactory.getFactoryLink().getTxtBooksDAO().find(bookTitle);
            for (Book book : bookResult) {
                sb.append(book.toString()).append("\n");
            }
        } catch (DAOException | NullPointerException e) {
            throw new ServiceException("SERVICE ERROR: Book finding error");
        }
        if (sb == null | sb.length() == 0)
            return "There is no book with such bookTitle in library";
        return sb.toString();
    }
}
