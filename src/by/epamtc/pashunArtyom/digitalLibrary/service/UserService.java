package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public interface UserService {

    void register(User user) throws ServiceException;

    void delete(String login, String password) throws ServiceException;

    boolean logIn(String login, String password) throws ServiceException;
}
