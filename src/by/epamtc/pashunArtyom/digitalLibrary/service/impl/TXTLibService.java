package by.epamtc.pashunArtyom.digitalLibrary.service.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.DAOFactory;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;
import by.epamtc.pashunArtyom.digitalLibrary.service.LibService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.validation.BookValidator;

import java.util.List;

public class TXTLibService implements LibService {

    @Override
    public boolean addBook(Book book) throws ServiceException {
        boolean isInputValid = false;
        BookValidator bookValidator = new BookValidator();

        if (bookValidator.isTitleValid(book.getBookTitle()) && bookValidator.isAuthorValid(book.getAuthorName())) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                daoObjectFactory.getTxtBooksDAO().addBook(book);
                isInputValid = true;
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: Book adding error", e);
            }
        }
        return isInputValid;
    }

    @Override
    public boolean removeBook(int bookId) throws ServiceException {
        boolean isInputValid = false;
        BookValidator bookValidator = new BookValidator();

        if (bookValidator.isIdValid(bookId)) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                daoObjectFactory.getTxtBooksDAO().removeBook(bookId);
                isInputValid = true;
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: Book deleting error", e);
            }
        }
        return isInputValid;
    }

    @Override
    public boolean editBook(int bookId, String newBookTitle, String newBookAuthor) throws ServiceException {
        boolean isInputValid = false;
        BookValidator bookValidator = new BookValidator();

        if (bookValidator.isIdValid(bookId) && bookValidator.isTitleValid(newBookTitle) &&
                bookValidator.isAuthorValid(newBookAuthor)) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                daoObjectFactory.getTxtBooksDAO().editBook(bookId, newBookTitle, newBookAuthor);
                isInputValid = true;
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: Book editing error", e);
            }
        }
        return isInputValid;
    }

    @Override
    public Book findBook(String bookTitle) throws ServiceException {
        Book book = null;
        BookValidator bookValidator = new BookValidator();

        if (bookValidator.isTitleValid(bookTitle)) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                book = daoObjectFactory.getTxtBooksDAO().findBook(bookTitle);
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: Book finding error", e);
            }
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
