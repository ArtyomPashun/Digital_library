package by.epamtc.pashunArtyom.digitalLibrary.dao;

import by.epamtc.pashunArtyom.digitalLibrary.dao.impl.TXTLibDAO;
import by.epamtc.pashunArtyom.digitalLibrary.dao.impl.TXTUserDAO;

public class DAOFactory {

    private static final DAOFactory factoryLink = new DAOFactory();
    private final TXTLibDAO txtBookDAO = new TXTLibDAO();
    private final TXTUserDAO txtUserDAO = new TXTUserDAO();

    public DAOFactory() {
    }

    public static DAOFactory getFactoryLink() {
        return factoryLink;
    }

    public TXTLibDAO getTxtBooksDAO() {
        return txtBookDAO;
    }

    public TXTUserDAO getTxtUsersDAO() {
        return txtUserDAO;
    }
}
