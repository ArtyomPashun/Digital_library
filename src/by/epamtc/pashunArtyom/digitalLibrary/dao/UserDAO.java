package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.entity.User;

public interface UserDAO {
    User authorization (String login, String password) throws DAOException;
    void registration (User newUser) throws DAOException;
}
