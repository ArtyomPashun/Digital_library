package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.impl.TXTLibDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.impl.TXTUserDAO;

public class DAOFactory {

    private static final DAOFactory factoryLink = new DAOFactory();
    private final LibDAO txtBookDAO = new TXTLibDAO();
    private final UserDAO txtUserDAO = new TXTUserDAO();

    public DAOFactory() {
    }

    public static DAOFactory getFactoryLink() {
        return factoryLink;
    }

    public LibDAO getTxtBooksDAO() {
        return txtBookDAO;
    }

    public UserDAO getTxtUsersDAO() {
        return txtUserDAO;
    }
}
