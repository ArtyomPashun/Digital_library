package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public interface UserService {

    User register(User user) throws ServiceException;

    void delete(String login, String password) throws ServiceException;

    User logIn(String login, String password) throws ServiceException;
}
