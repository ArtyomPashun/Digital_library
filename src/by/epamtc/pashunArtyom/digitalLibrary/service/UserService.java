package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public interface UserService {

    void signIn(String userLogin, String userPassword) throws ServiceException;

    void register(User user) throws ServiceException;
}
