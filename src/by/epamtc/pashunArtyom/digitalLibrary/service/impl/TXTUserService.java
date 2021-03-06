package by.epamtc.pashunArtyom.digitalLibrary.service.impl;

import by.epamtc.pashunArtyom.digitalLibrary.dao.DAOFactory;
import by.epamtc.pashunArtyom.digitalLibrary.dao.exception.DAOException;
import by.epamtc.pashunArtyom.digitalLibrary.dao.impl.TXTUserDAO;
import by.epamtc.pashunArtyom.digitalLibrary.entity.User;
import by.epamtc.pashunArtyom.digitalLibrary.service.UserService;
import by.epamtc.pashunArtyom.digitalLibrary.service.exception.ServiceException;
import by.epamtc.pashunArtyom.digitalLibrary.service.validation.UserValidator;

public class TXTUserService implements UserService {

    @Override
    public User register(User user) throws ServiceException {
        UserValidator userValidator = new UserValidator();

        if (userValidator.isLoginValid(user.getUserLogin()) &&
                userValidator.isPasswordValid(user.getUserPassword())) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                daoObjectFactory.getTxtUsersDAO().register(user);
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: user can not be registered", e);
            }
        }
        return user;
    }

    @Override
    public void delete(String login, String password) throws ServiceException {
        UserValidator userValidator = new UserValidator();

        if (userValidator.isPasswordValid(password) &&
                userValidator.isLoginValid(login)) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            try {
                daoObjectFactory.getTxtUsersDAO().delete(login, password);
            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: User deleting error", e);
            }
        }
    }

    @Override
    public User logIn(String userLogin, String userPassword) throws ServiceException {
        User user = null;
        UserValidator userValidator = new UserValidator();

        if (userValidator.isPasswordValid(userPassword) &&
                userValidator.isLoginValid(userLogin)) {
            DAOFactory daoObjectFactory = DAOFactory.getFactoryLink();
            TXTUserDAO txtUserDAO = daoObjectFactory.getTxtUsersDAO();

            try {
                user = txtUserDAO.logIn(userLogin, userPassword);

            } catch (DAOException e) {
                throw new ServiceException("SERVICE ERROR: User log in error", e);
            }
        }
        return user;
    }
}

