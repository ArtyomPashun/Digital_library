package by.epamtc.pashunArtyom.digitalLibrary.service;

import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTLibService;
import by.epamtc.pashunArtyom.digitalLibrary.service.impl.TXTUserService;

public class ServiceFactory {

    public static ServiceFactory serviceLink = new ServiceFactory();
    TXTLibService bookService = new TXTLibService();
    TXTUserService userService = new TXTUserService();

    private ServiceFactory() {
    }

    public static ServiceFactory getServiceLink() {
        return serviceLink;
    }

    public TXTLibService getBookService() {
        return bookService;
    }

    public UserService getClientService() {
        return userService;
    }
}
