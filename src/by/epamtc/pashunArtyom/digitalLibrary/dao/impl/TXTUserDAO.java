package by.epamtc.pashunArtyom.digitalLibrary.dao.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.UserDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;


public class TXTUserDAO implements UserDAO {

    public final static String PATH_TO_BOOK_LIST = "./resources/library.txt";
    public final static String DELIMITER = "; ";

    @Override
    public void register(User user) throws DAOException {

    }

    @Override
    public void authorize(String login, String password) throws DAOException {

    }
}
