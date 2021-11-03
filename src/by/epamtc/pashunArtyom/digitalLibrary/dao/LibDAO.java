package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.entity.Book;

import java.util.List;

public interface LibDAO {
    void add (Book book) throws DAOException;
    void remove (int idBook) throws DAOException;
    List <Book> find (String title) throws DAOException;
}
