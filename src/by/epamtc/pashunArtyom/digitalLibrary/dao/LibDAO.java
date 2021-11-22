package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;

import java.util.List;


public interface LibDAO {

    void addBook(Book book) throws DAOException;

    void removeBook(int bookId) throws DAOException;

    void editBook(int bookId, String newBookTitle, String newAuthorName) throws DAOException;

    Book findBook(String bookTitle) throws DAOException;

    List<Book> findAllBooks() throws DAOException;
}
