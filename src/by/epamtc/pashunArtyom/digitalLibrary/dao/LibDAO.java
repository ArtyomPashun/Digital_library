package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;

import java.util.ArrayList;


public interface LibDAO {

    void addBook(Book book) throws DAOException;

    void removeBook(int bookId) throws DAOException;

    void editBook() throws DAOException;

    ArrayList<Book> find(String bookTitle) throws DAOException;

}
