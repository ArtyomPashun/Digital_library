package by.epamtc.pashunArtyom.digitalLibrary.service.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.DAOFactory;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.LibService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

import java.util.List;

public class TXTLibService implements LibService {

    @Override
    public boolean addBook(Book book) throws ServiceException {
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
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: you could not add book");
        }
        return false;
    }

    @Override
    public boolean removeBook(int bookId) throws ServiceException {
        if (bookId <= 0)
            throw new ServiceException("SERVICE ERROR: incorrect bookId input");
        try {
            DAOFactory.getFactoryLink().getTxtBooksDAO().removeBook(bookId);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: can not remove this book or incorrect bookId input");
        }
        return false;
    }

    @Override
    public boolean editBook(int bookId, String newBookTitle, String newBookAuthor) throws ServiceException {
        if (bookId <= 0)
            throw new ServiceException("SERVICE ERROR: incorrect bookId input");
        if (newBookTitle == null) {
            throw new ServiceException("SERVICE ERROR: incorrect bookTitle input");
        }
        if (newBookAuthor == null) {
            throw new ServiceException("SERVICE ERROR: incorrect bookAuthorName input");
        }
        try {
            DAOFactory.getFactoryLink().getTxtBooksDAO().editBook(bookId, newBookTitle, newBookAuthor);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: book edit error");
        }
        return false;
    }

    @Override
    public Book findBook(String bookTitle) throws ServiceException {
        Book book;
        if (bookTitle == null || bookTitle.isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect bookTitle input");
        }
        try {
            book = DAOFactory.getFactoryLink().getTxtBooksDAO().findBook(bookTitle);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: Book finding error");
        }
        return book;
    }

    @Override
    public List<Book> findAllBooks() throws ServiceException {
        List<Book> bookList;

        try {
            bookList = DAOFactory.getFactoryLink().getTxtBooksDAO().findAllBooks();
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: Showing all books error", e);
        }
        return bookList;
    }
}
