package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;

public interface UserDAO {

    void register(User newUser) throws DAOException;

    void delete(String login, String password) throws DAOException;

    User logIn(String login, String password) throws DAOException;
}
