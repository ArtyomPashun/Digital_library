package by.epamtc.pashunArtyom.digitalLibrary.service.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.DAOFactory;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.service.UserService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;

public class TXTUserService implements UserService {

    @Override
    public void register(User user) throws ServiceException {
        if (user == null) {
            throw new ServiceException("SERVICE ERROR: user is not exist");
        }
        if (user.getUserLogin() == null || user.getUserLogin().isEmpty() ||
                user.getUserLogin().length() < 4) {
            throw new ServiceException("SERVICE ERROR:incorrect userLogin input");
        }
        if (user.getUserPassword() == null || user.getUserPassword().isEmpty() ||
                user.getUserPassword().length() < 4) {
            throw new ServiceException("SERVICE ERROR:incorrect userPassword input");
        }
        try {
            DAOFactory.getFactoryLink().getTxtUsersDAO().register(user);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: user can not be registered");
        }
    }

    @Override
    public void delete(String login, String password) throws ServiceException {
        try {
            DAOFactory.getFactoryLink().getTxtUsersDAO().delete(login, password);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: User deleting error", e);
        }
    }

    @Override
    public boolean logIn(String userLogin, String userPassword) throws ServiceException {
        if (userLogin == null || userLogin.isEmpty()) {
            throw new ServiceException("SERVICE ERROR: incorrect userLogin input");
        }
        if (userPassword == null || userPassword.isEmpty()) {
            throw new ServiceException("SERVICE ERROR:incorrect userPassword input");
        }
        try {
            DAOFactory.getFactoryLink().getTxtUsersDAO().logIn(userLogin, userPassword);
        } catch (DAOException e) {
            throw new ServiceException("SERVICE ERROR: Authorization is failed");
        }
        return true;
    }
}

