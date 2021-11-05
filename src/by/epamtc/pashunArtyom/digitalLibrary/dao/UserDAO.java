package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;

public interface UserDAO {

    void register(User user) throws DAOException;

    void authorize(String login, String password) throws DAOException;
}
